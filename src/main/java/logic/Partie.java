package logic;

import dao.pojo.Carte;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Partie {
    private Random rand = new Random();
    private List<Carte> deck = new ArrayList<>(32);
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

        // fixme;  je suis pas en etat de coder le coeud de l'application :[.
        // globalement, il faudra faire bouger des trucs qui sont en paramettre en attribut et les mettres dans joueur (Position et atout)
        // Ajouter la liste de carte directement dans la classe joueur
        // bref, avoir logic.Joueur correspondre à un jour concret
    }

    public void jouerManche() throws ExecutionException, InterruptedException {
        // reset deck  & shuffle
        deck = Arrays.asList(Carte.values());
        Collections.shuffle(deck);

        // direction du joueur qui distribut
        Position distrib = Position.random(rand);
        // donne 3 puis 2 cartes a tout le monde
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()) {
            giveCard(joueurs.getSide(courrant), 3);
        }
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()) {
            giveCard(joueurs.getSide(courrant), 2);
        }


    }

    public void giveCard(Joueur joueur, int nbCarte){
        for(int i=0; i<nbCarte && !deck.isEmpty(); i++) {
            Carte last = deck.remove(deck.size()-1);
            joueur.addCarte(last);
        }
    }

    /**
     * Tente de déterminer l'atout.
     * Retourne l'atout si un est choisi
     * @param distrib la position du joueur commencant la distribution
     * @return l'aout ou null si aucun Atout n'a était choisi
     * @throws ExecutionException exception du aux futur
     * @throws InterruptedException exception du aux futur
     */
    public Carte selectAtout(Position distrib) throws ExecutionException, InterruptedException {
        // fait des demandes
        Carte propose = deck.remove(deck.size()-1);

        // vérifie si quelqu'un veux bien l'atout
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()) {
            Joueur joueur = joueurs.getSide(courrant);
            Boolean pris = joueur.proposeAtout(propose).get();
            if(pris != null && pris) {
                distributCarte(propose, courrant);
                return propose;
            }
        }
        // vérifie si quelqu'un veux bien proposé un atout
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()){
            Joueur joueur = joueurs.getSide(courrant);
            Carte carte = joueur.remplaceAtout(propose).get();
            // s'assure que le joueur possede la carte qu'il propose
            assert joueur.hasCarte(carte);
            if(carte != null) {
                distributCarte(propose, courrant);
                return carte;
            }
        }

        return null;
    }

    public void distributCarte(Carte propose, Position preneur) {
        Joueur joueurPreneur = joueurs.getSide(preneur);
        joueurPreneur.addCarte(propose);
        for(Position courrant = preneur.next(); preneur != courrant; courrant = preneur.next()) {
            giveCard(joueurs.getSide(courrant), 3);
        }
        giveCard(joueurPreneur, 2);
    }
}
