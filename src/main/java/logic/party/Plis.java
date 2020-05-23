package logic.party;

import dao.pojo.Carte;
import dao.pojo.EvenementPlis;
import dao.pojo.ManchePK;
import dao.pojo.PlisPK;
import logic.utils.Position;
import logic.utils.Score;

import java.util.ArrayList;
import java.util.List;

public class Plis {
    protected Position debut;
    protected Position courrante;
    protected Manche manche;
    protected Tapis tapis;
    protected EvenementPlis note;
    protected Score score;

    public Plis(Manche manche, Position debut) {
        this.manche = manche;
        this.debut = debut;
        this.courrante = debut;
        this.tapis = new Tapis();
    }

    boolean isDone(){
        return debut.equals(courrante);
    }

    public Position getDebut() {
        return debut;
    }

    public Position getCourrante() {
        return courrante;
    }

    public Tapis getTapis() {
        return tapis;
    }

    public EvenementPlis getNote() {
        return note;
    }
    public void setNote(EvenementPlis note) {
        this.note = note;
    }

    /**
     * Produit la liste des cartes jouables pour un plis donnée.
     * NB! la valeur retourner peut être une référence vers {@param listCarte}
     * @param listCarte la liste des cartes dans la main
     * @param atout la couleur de l'atout
     * @return la liste des cartes jouable
     */
    public List<Carte> canPlay(List<Carte> listCarte, Carte.Couleur atout) {
        // 1re tour, toutes les cartes sont jouable
        if(courrante == debut) {
            return listCarte;
        }
        // récupère la couleur demander
        Carte.Couleur demander = tapis.getSide(debut).getCouleur();

        // le partenaire domine le plis
        Carte best = tapis.getSide(tapis.winingSide(atout, getDemander()));
        Carte cartePartenaire = tapis.getSide(courrante.opposite());

        if(cartePartenaire != null
                && !best.obtenirCategory(atout, demander).estMeilleur(cartePartenaire.obtenirCategory(atout, demander))
                && cartePartenaire.getPoint(atout) == best.getPoint(atout)
        ) {
            return listCarte;
        }

        List<Carte> carteJouable = new ArrayList<Carte>();
        // il y a un atout; c'est la meilleur carte
        if(best.getCouleur() == atout) {
            // on liste les atouts plus forts
            for(Carte carte : listCarte) {
                if(carte.getCouleur() == atout && carte.getPoint(atout) > best.getPoint(atout)) {
                    carteJouable.add(carte);
                }
            }
            if(carteJouable.size() > 0) {
                return carteJouable;
            }

            // pas d'atout plus fort
        } else {
            // il y a pas d'atout déjà posé
            // cherche les cartes de la même couleur
            for (Carte carte : listCarte) {
                if (carte.getCouleur() == demander) {
                    carteJouable.add(carte);
                }
            }
            if (carteJouable.size() > 0) {
                return carteJouable;
            }

            // pas de carte de la couleur demandé
        }
        // dans les 2 cas, on privilégie de jouer un atout

        // vérifie si on a un atout
        for(Carte carte : listCarte) {
            if(carte.getCouleur() == atout) {
                carteJouable.add(carte);
            }
        }
        if(carteJouable.size() > 0) {
            return carteJouable;
        }

        // pas d'atout, on peut jouer n'importe quelle carte
        return listCarte;
    }

    public Carte.Couleur getDemander() {
        return tapis.getSide(debut).getCouleur();
    }

    public void joueCarte(Carte carte) {
        this.tapis.setSide(courrante, carte);
        courrante = courrante.next();
    }

    /**
     * Score du plis
     * @return la valeur du plis attribuer à l'équipe l'ayant gagné
     */
    public Score getScore() {
        if(score == null && isDone() && this.tapis.getSide(debut) != null) {
            Carte.Couleur atout = getAtout();
            Position dir = tapis.winingSide(atout, getDemander());
            score = new Score();
            score.setScore(dir, tapis.getPoint(atout));
        }
        return score;
    }

    public Carte.Couleur getAtout(){
        return manche.getAtout().getCouleur();
    }

    public Position getPositionNote(){
        if(note != null) {
            Position posRoi = tapis.positionCarte(Carte.getCarte(getAtout(), Carte.Valeur.DAME));
            Position posDame = tapis.positionCarte(Carte.getCarte(getAtout(), Carte.Valeur.ROI));
            return posRoi == null ? posDame : posRoi;
        }
        return null;
    }

    /**
     * Retourne un object de type dao.pojo contenant les bonnes cartes au bonnes position.
     * Le joueur débutant la manche doit encore être indiqué encore a ajouter.
     * FIXME extract into dedicated serialization
     * @return un plis serializable dans la base de données.
     */
    public dao.pojo.Plis asDao(ManchePK mpk, byte pli) {
        dao.pojo.Plis plis = new dao.pojo.Plis(new PlisPK(mpk.getPartieId(), mpk.getMancheNb(), pli));
        Position pos = this.debut;
        plis.setCarte1(this.tapis.getSide(pos));
        pos = pos.next();
        plis.setCarte2(this.tapis.getSide(pos));
        pos = pos.next();
        plis.setCarte3(this.tapis.getSide(pos));
        pos = pos.next();
        plis.setCarte4(this.tapis.getSide(pos));

        // récupère le joueur correspondant à la direction début
        plis.setJoueurDebut(manche.getPartie().getJoueurs().getSide(debut).getDao());

        // set un eventuel Belote ou Rebelote
        plis.setNote(note);
        return plis;
    }
}
