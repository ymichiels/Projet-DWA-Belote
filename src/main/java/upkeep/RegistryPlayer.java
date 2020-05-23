package upkeep;

import dao.pojo.Humain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Une class stockant la liste de tous les joueurs connecté dans une hashmap pour pouvoir récuperer leur état.
 * A terme, pourrait être intégré dans la BdD. A terme.
 */
public class RegistryPlayer {
    private static HashMap<Humain, State> playerRegistry = new HashMap<Humain, State>();
    private static List<ChangeRegistry> listCR = new ArrayList<>();

    public static void setState(Humain humain, State state) {
        if(state == State.Disconnected) {
            playerRegistry.remove(humain);
        } else {
            playerRegistry.put(humain, state);
        }
        Client cli = buildClient(humain, state);
        for(ChangeRegistry cr : listCR) {
            cr.onPlayerStateChange(cli);
        }
    }

    public static List<Client> listClient() {
        List<Client> lst = new ArrayList<>(playerRegistry.size());
        // FIXME iter both key and value to reduce complexity
        for(Humain hum : playerRegistry.keySet()) {
            State state = playerRegistry.get(hum);
            lst.add(buildClient(hum, state));
        }
        return lst;
    }

    public static Client buildClient(Humain hum, State state) {
        Client cli = new Client();
        cli.setAge(hum.getAge());
        cli.setPseudo(hum.getPseudo());
        cli.setConnecte(state);
        cli.setNbPartie(hum.getNbPartie());
        cli.setNbPartieGagne(hum.getNbVictoire());
        return cli;
    }

    public static void register(ChangeRegistry cr) {
        listCR.add(cr);
    }
    public static void unregister(ChangeRegistry cr) {
        listCR.remove(cr);
    }

    public interface ChangeRegistry {
        void onPlayerStateChange(Client cli);
    }


    enum State {
        Disconnected,
        Libre,
        Waiting,
        Jouent
    }

    public static class Client {
        private String pseudo;
        private int nbPartie;
        private int nbPartieGagne;
        private int age;
        private State connecte;

        public String getPseudo() {
            return pseudo;
        }
        public void setPseudo(String pseudo) {
            this.pseudo = pseudo;
        }

        public int getNbPartie() {
            return nbPartie;
        }
        public void setNbPartie(int nbPartie) {
            this.nbPartie = nbPartie;
        }

        public int getNbPartieGagne() {
            return nbPartieGagne;
        }
        public void setNbPartieGagne(int nbPartieGagne) {
            this.nbPartieGagne = nbPartieGagne;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public State getConnecte() {
            return connecte;
        }
        public void setConnecte(State connecte) {
            this.connecte = connecte;
        }
    }
}
