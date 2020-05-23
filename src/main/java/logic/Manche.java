package logic;

import dao.pojo.Carte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Manche {
    private Partie partie;
    private List<Carte> deck = new ArrayList<>(32);

    public Manche(Partie partie) {
        this.partie = partie;
    }

    public Partie getPartie() {
        return partie;
    }

    public Score jouer() throws ExecutionException, InterruptedException{

        // reset deck  & shuffle
        deck = Arrays.asList(Carte.values());
        Collections.shuffle(deck);

        // direction du joueur qui distribut
        Position distrib = Position.random(partie.getRand());
        // donne 3 puis 2 cartes a tout le monde
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()) {
            giveCard(partie.getJoueurs().getSide(courrant), 3);
        }
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()) {
            giveCard(partie.getJoueurs().getSide(courrant), 2);
        }

        // tente de récuperer un atout ou null
        Carte atout = selectAtout(distrib);

        Score score = new Score();
        // 0 points, on annule la manche
        if(atout == null) {
            return score;
        }

        for(int i=0; i<8; ++i) {
            Plis plis = new Plis(distrib.next());
            do {
                Position courrant = plis.getCourrante();
                Joueur joueur = partie.getJoueurs().getSide(courrant);
                Play play = joueur.joueCarte(plis.canPlay(joueur.getMain(), atout.getCouleur()), plis).get();
                if(play.getNote() != null) {
                    plis.setNote(play.getNote());
                }
                plis.getTapis().setSide(courrant, play.getCarte());

                // informe les autres joueur de l'état du tapis à la fin du tour
                for(Position notCourrant = courrant.next(); notCourrant != courrant; notCourrant = courrant.next()){
                    partie.getJoueurs().getSide(notCourrant).finAutreTour(plis, notCourrant);
                }
            } while (!plis.isDone());
        }

        return score;
    }

    /**
     * Donne les {@param nbCarte} au joueur {@param joueur}.
     * @param joueur le joueur auquel donnerles cartes
     * @param nbCarte le nombre de carte a donner
     */
    public void giveCard(Joueur joueur, int nbCarte){
        for(int i=0; i<nbCarte; i++) {
            if(deck.isEmpty()){
                System.err.println("Ran out of card. Not normal.");
                return;
            }
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
            Joueur joueur = partie.getJoueurs().getSide(courrant);
            Boolean pris = joueur.proposeAtout(propose).get();
            if(pris != null && pris) {
                distributCarte(propose, courrant);
                return propose;
            }
        }
        // vérifie si quelqu'un veux bien proposé un atout
        for(Position courrant=distrib.next(); courrant != distrib; courrant = courrant.next()){
            Joueur joueur = partie.getJoueurs().getSide(courrant);
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
        Joueur joueurPreneur = partie.getJoueurs().getSide(preneur);
        joueurPreneur.addCarte(propose);
        for(Position courrant = preneur.next(); preneur != courrant; courrant = preneur.next()) {
            giveCard(partie.getJoueurs().getSide(courrant), 3);
        }
        giveCard(joueurPreneur, 2);
    }
}
