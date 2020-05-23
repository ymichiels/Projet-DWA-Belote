package logic;

import dao.pojo.Carte;
import dao.pojo.ManchePK;
import dao.pojo.PlisPK;

import java.util.ArrayList;
import java.util.List;

public class Plis {
    protected Position debut;
    protected Position courrante;
    protected Tapis tapis;

    public Plis(Position debut) {
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
        Carte.Couleur demander = tapis.getCarte(debut).getCouleur();

        // le partenaire domine le plis
        Carte best = tapis.getCarte(tapis.winingSide(atout, getDemander()));
        Carte cartePartenaire = tapis.getCarte(courrante.opposite());

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
        return tapis.getCarte(debut).getCouleur();
    }

    public void joueCarte(Carte carte) {
        this.tapis.setCarte(courrante, carte);
        courrante = courrante.next();
    }

    /**
     * Retourne un object de type dao.pojo contenant les bonnes cartes au bonnes position.
     * Le joueur débutant la manche doit encore être indiqué encore a ajouter.
     * @return un plis serializable dans la base de données.
     */
    public dao.pojo.Plis asDao(ManchePK mpk, byte pli) {
        dao.pojo.Plis plis = new dao.pojo.Plis(new PlisPK(mpk.getPartieId(), mpk.getMancheNb(), pli));
        Position pos = this.debut;
        plis.setCarte1(this.tapis.getCarte(pos));
        pos = pos.next();
        plis.setCarte2(this.tapis.getCarte(pos));
        pos = pos.next();
        plis.setCarte3(this.tapis.getCarte(pos));
        pos = pos.next();
        plis.setCarte4(this.tapis.getCarte(pos));
        return plis;
    }
}
