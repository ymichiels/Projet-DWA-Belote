package logic;

import dao.pojo.Carte;

public class Tapis {
    protected Carte nord;
    protected Carte est;
    protected Carte sud;
    protected Carte ouest;

    public Carte getCarte(Position position) {
        switch (position) {
            case Nord:
                return this.nord;
            case Est:
                return this.est;
            case Sud:
                return this.sud;
            case Ouest:
                return this.ouest;
        }
        return null;
    }
    public void setCarte(Position position, Carte carte) {
        switch (position) {
            case Nord:
                this.nord = carte;
            case Est:
                this.est = carte;
            case Sud:
                this.sud = carte;
            case Ouest:
                this.ouest = carte;
        }
    }

    public Carte getNord() {
        return nord;
    }
    public void setNord(Carte nord) {
        this.nord = nord;
    }

    public Carte getEst() {
        return est;
    }
    public void setEst(Carte est) {
        this.est = est;
    }

    public Carte getSud() {
        return sud;
    }
    public void setSud(Carte sud) {
        this.sud = sud;
    }

    public Carte getOuest() {
        return ouest;
    }
    public void setOuest(Carte ouest) {
        this.ouest = ouest;
    }

    public Position winingSide(Carte.Couleur atout, Carte.Couleur demande) {
        Position dirBest = null;
        Carte carteBest = null;
        Carte.Category cat = null;
        for(Position dir : Position.values()) {
            Carte carteCourrante = getCarte(dir);
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
