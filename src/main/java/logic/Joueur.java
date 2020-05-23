package logic;

import dao.pojo.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

abstract public class Joueur {
    protected List<Carte> main = new ArrayList<>();
    protected Position pos = Position.Nord;
    protected Carte.Couleur atout = Carte.Couleur.CARREAU;

    public void resetMain() {
        this.main.clear();
    }

    public void addCarte(Carte carte) {
        this.main.add(carte);
    }

    public boolean hasCarte(Carte carte) {
        return main.contains(carte);
    }

    public List<Carte> getMain() {
        return main;
    }

    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setAtout(Carte.Couleur atout) {
        this.atout = atout;
    }
    public Carte.Couleur getAtout() {
        return atout;
    }

    public void informeScore(Score diff, Score total) {}
    abstract public Future<Play> joueCarte(List<Carte> jouable, Plis plis);
    public void finAutreTour(Plis plis, Position tour) {}
    abstract public Future<Boolean> proposeAtout(Carte proposition);
    public void finSelectionAtout(Carte atout, boolean pris, Position tour) {}
    abstract public Future<Carte> remplaceAtout(Carte ancienAtout);
    public void finRemplacementAtout(Carte carte, Position tour) {}
}
