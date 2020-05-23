package upkeep;

import dao.helper.ManagerJoueur;
import dao.pojo.Humain;
import dao.pojo.Robot;
import logic.joueur.Joueur;
import logic.joueur.JoueurHumain;
import ws.WebSocketPlayer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class PlayerFetcher {
    // 50 secondes d'attente avant de considerer un client comme "mort"
    public static final int MAX_TICK = 500;

    /**
     * Va chercher un composant logique {@link logic.joueur.Joueur} représentant le joueur
     * @param pseudo le pseudo du jour a initier
     * @return
     */
    public static Future<Joueur> fetchPlayer(String pseudo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        ManagerJoueur mj = new ManagerJoueur(em);
        List<dao.pojo.Joueur> listJoueur = mj.findByPseudo(pseudo);
        if(listJoueur.isEmpty()) {
            return CompletableFuture.completedFuture(null);
        }
        dao.pojo.Joueur joueur = listJoueur.get(0);
        if(joueur instanceof dao.pojo.Robot) {
            // c'est un robot, facile a généré
            return CompletableFuture.completedFuture(BotGenerator.getLogic((Robot) joueur));
        } else if (joueur instanceof dao.pojo.Humain) {
            // c'est un joueur, un peu plus chiant
            return CompletableFuture.supplyAsync(() -> {
                // on met a disposition un buffer en attendant qu'il se connecte
                ArrayBlockingQueue<WebSocketPlayer> abq = new ArrayBlockingQueue<>(1);
                // prépare la logique d'attende du client
                RegistryPlayers.AwaitConnection ac = (clientId, client) -> {
                    if(clientId == joueur.getJoueurId()){
                        try {
                            abq.put(client);
                        }catch (InterruptedException err) {
                            err.printStackTrace();
                        }
                        return false;
                    }
                    return true;
                };
                // attend le client
                RegistryPlayers.registerAwaiter(ac);
                // tant que le client n'est pas là, attends...
                int tick = 0;
                while(abq.isEmpty()) {
                    try {
                        Thread.sleep(100);
                        tick++;
                        if(tick > MAX_TICK){
                            break;
                        }
                    } catch (InterruptedException err) {
                        err.printStackTrace();
                    }
                }
                WebSocketPlayer wsp = abq.poll();
                if(wsp == null) {
                    return null;
                }
                return new JoueurHumain((Humain) joueur, wsp);
            });
        } else {
            return CompletableFuture.completedFuture(null);
        }
    }
}
