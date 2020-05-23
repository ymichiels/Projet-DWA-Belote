package logic;

import dao.pojo.Carte;

public class Tapis extends SidedStorage<Carte>{
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
}
