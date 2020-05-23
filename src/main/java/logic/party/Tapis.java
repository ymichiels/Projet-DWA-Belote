package logic.party;

import dao.pojo.Carte;
import logic.utils.Position;
import logic.utils.SidedStorage;

public class Tapis extends SidedStorage<Carte> {
    public Position winingSide(Carte.Couleur atout, Carte.Couleur demande) {
        Position dirBest = null;
        Carte carteBest = null;
        Carte.Category cat = null;
        for(Position dir : Position.values()) {
            Carte carteCourrante = getSide(dir);
            if(carteCourrante == null) {
                continue;
            }
            Carte.Category catCourrante = carteCourrante.obtenirCategory(atout, demande);

            if(carteBest == null || catCourrante.estMeilleur(cat) || carteCourrante.getPoint(atout) >= carteBest.getPoint(atout)) {
                carteBest = carteCourrante;
                dirBest = dir;
                cat = catCourrante;
            }
        }
        return dirBest;
    }

    public boolean contientCouleur(Carte.Couleur couleur) {
        if(nord != null && nord.getCouleur() == couleur) {
            return true;
        }
        if(est != null && est.getCouleur() == couleur) {
            return true;
        }
        if(sud != null && sud.getCouleur() == couleur) {
            return true;
        }
        if(ouest != null && ouest.getCouleur() == couleur) {
            return true;
        }
        return false;
    }

    /**
     * Retourne la direction de la carte a rechercher ou null si elle ne se trouve pas dans le plis
     * @param carte la carte a chercher
     * @return la position de la carte
     */
    public Position positionCarte(Carte carte) {
        for(Position dir : Position.values()) {
            if(getSide(dir) == carte) {
                return dir;
            }
        }
        return null;
    }

    public int getPoint(Carte.Couleur atout) {
        int point = 0;
        for(Position dir : Position.values()) {
            point += this.getSide(dir).getPoint(atout);
        }
        return point;
    }
}
