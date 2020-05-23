package logic.party;

import dao.pojo.Carte;
import logic.joueur.Joueur;
import logic.utils.Position;
import logic.utils.Score;
import logic.utils.SidedStorage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Partie {
    private Random rand = new Random();
    private List<Manche> listManches = new ArrayList<>();
    private SidedStorage<Joueur> joueurs = new SidedStorage<>();

    public Random getRand() {
        return rand;
    }

    public SidedStorage<Joueur> getJoueurs() {
        return joueurs;
    }

    // setup la partie
    public void jouerPartie(Joueur north, Joueur est, Joueur sud, Joueur ouest) {
        joueurs.setNord(north);
        joueurs.setEst(est);
        joueurs.setSud(sud);
        joueurs.setOuest(ouest);

        Score score = new Score();
        while (score.getEstOuest() < 501 && score.getNordSud() < 501) {
            Manche manche = new Manche(this);
            listManches.add(manche);
            try {
                manche.jouer();
                score.add(manche.getScore());
            } catch (InterruptedException | ExecutionException err) {
                err.printStackTrace();
            }
        }
    }

    public dao.pojo.Partie saveDao(EntityManager em){
        // generate partie_id
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        dao.pojo.Partie partie = new dao.pojo.Partie();
        em.merge(partie);

        Collection<dao.pojo.Manche> mancheCollections = partie.getMancheCollection();
        Score score = new Score();
        for(Manche manche : listManches) {
            dao.pojo.Manche pojoManche = manche.asDao(partie.getPartieId(), (short)mancheCollections.size());
            mancheCollections.add(pojoManche);
            pojoManche.setPartie(partie);
            score.add(manche.getScore());
        }
        partie.setEq1a(joueurs.getNord().getDao());
        partie.setEq2a(joueurs.getOuest().getDao());
        partie.setEq1b(joueurs.getSud().getDao());
        partie.setEq2b(joueurs.getEst().getDao());
        partie.setDuree(new Date()); // fixme purpose for this field

        partie.setScoreEq1((short)score.getNordSud());
        partie.setScoreEq2((short)score.getEstOuest());

        em.merge(partie);
        transaction.commit();

        return partie;
    }
}
