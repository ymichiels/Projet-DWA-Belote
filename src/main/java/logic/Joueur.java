package logic;

import dao.pojo.Carte;

import java.util.List;
import java.util.concurrent.Future;

abstract public class Joueur {
    abstract public void informeScore(Score diff, Score total, Position position);
    abstract public Future<Play> joueCarte(List<Carte> main, List<Carte> jouable, Plis plis, Carte.Couleur atout, Position position);
    public void finAutreTour(List<Carte> main, Plis plis, Carte.Couleur atout, Position position, Position tour) {}
    abstract public Future<Boolean> proposeAtout(List<Carte> main, Carte proposition, Position position);
    // TODO interface pacive pour log proposeAttout et remplaceAtout quand d'autre joueur le font
    abstract public Future<Carte> remplaceAtout(List<Carte> main, Carte ancienAtout, Position position);
}
