package logic.party;

import dao.pojo.Carte;
import dao.pojo.ManchePK;
import logic.joueur.Joueur;
import logic.utils.Position;
import logic.utils.Score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Manche {
    private Partie partie;
    private List<Carte> deck = new ArrayList<>(32);
    private Carte atout = null;
    private Carte propose = null;
    private Position preneur = null;
    private Plis listPlis[];
    private Score score;

    public Manche(Partie partie) {
        this.partie = partie;
    }

    public Partie getPartie() {
        return partie;
    }

    public Carte getAtout() {
        return atout;
    }

    public Score jouer() throws ExecutionException, InterruptedException{

        // reset deck  & shuffle
        deck = Arrays.asList(Carte.values());
        Collections.shuffle(deck);

        for(Position pos : Position.values()) {
            partie.getJoueurs().getSide(pos).resetMain();
        }

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
        this.listPlis = new Plis[8];
        this.atout = atout;

        Position first = distrib.next();
        for(int i=0; i<8; ++i) {
            Plis plis = new Plis(this, first);
            do {
                Position courrant = plis.getCourrante();
                Joueur joueur = partie.getJoueurs().getSide(courrant);

                // attend coup joueur
                Play play = joueur.joueCarte(plis.canPlay(joueur.getMain(), atout.getCouleur()), plis).get();

                // update le plis
                if(play.getNote() != null) {
                    plis.setNote(play.getNote());
                }
                plis.getTapis().setSide(courrant, play.getCarte());

                // met à jour la main
                joueur.getMain().remove(play.getCarte());

                // informe les autres joueur de l'état du tapis à la fin du tour
                for(Position notCourrant = courrant.next(); notCourrant != courrant; notCourrant = courrant.next()){
                    partie.getJoueurs().getSide(notCourrant).finAutreTour(plis, notCourrant);
                }
            } while (!plis.isDone());
            listPlis[i] = plis;
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
            assert joueur.contientCarte(carte);
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

        this.propose = propose;
        this.preneur = preneur;
    }

    public Score getScore() {
        if(score == null && this.listPlis[7] != null) {
            // ajoute les score des plis
            Score total = new Score();
            Position posBelote = null;
            Position posRebelote = null;
            for(int i=0; i<8; ++i) {
                total.add(listPlis[i].getScore());

                // stock la direction de la belote
                switch (listPlis[i].getNote()) {
                    case BELOTE:
                        // sanity check
                        if(posRebelote != null) {
                            break;
                        }
                        posBelote = listPlis[i].getPositionNote();
                        break;
                    case REBELOTE:
                        // sabity check
                        if(posBelote == null) {
                            break;
                        }
                        posRebelote = listPlis[i].getPositionNote();
                        break;
                }
            }

            Score belote = new Score();
            // on a un rebelote
            if(posBelote != null && posBelote == posRebelote) {
                belote.setScore(posBelote, 20);
            }

            total.add(belote);
            // si l'équipe ayant pris marque suffisament de point
            if(total.getScore(preneur) < 81) {
                total = new Score();
                // met les points
                total.setScore(preneur.next(), 162);
                total.add(belote);
            } else {
                // set le score de l'autre équipe a la valeur de leur belote (defaut; 0)
                total.setScore(preneur.next(), belote.getScore(preneur.next()));
            }
            score = total;
        }
        return score;
    }

    public dao.pojo.Manche asDao(int partieId, short mancheId) {
        dao.pojo.Manche manche = new dao.pojo.Manche();
        ManchePK manchePK = new ManchePK(partieId, mancheId);
        manche.setManchePK(manchePK);
        manche.setAtoutInitial(propose);
        manche.setAtoutFinal(atout);
        manche.setJoueurPrenant(partie.getJoueurs().getSide(preneur).getDao());

        Score score = getScore();
        manche.setPointMancheEstOuest((short)score.getEstOuest());
        manche.setPointMancheNordSud((short)score.getNordSud());

        for(int i=0; i<listPlis.length; ++i) {
            dao.pojo.Plis plis = listPlis[i].asDao(manchePK, (byte)i);
            plis.setManche(manche);
            manche.getPlisCollection().add(plis);
        }
        return manche;
    }
}
