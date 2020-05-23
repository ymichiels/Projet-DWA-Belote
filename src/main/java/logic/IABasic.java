package logic;


import dao.pojo.Carte;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class IABasic extends Joueur {
    private Random random = new Random();

    public void informeScore(Score diff, Score total, Position position) {}

    public Future<Play> joueCarte(List<Carte> main, List<Carte> jouable, Plis plis, Carte.Couleur atout, Position position) {
        Carte carte = jouable.get(random.nextInt(jouable.size()));
        Play play = new Play();
        play.setCarte(carte);
        play.setNote(null);
        return CompletableFuture.completedFuture(play);
    }

    // 25% de chance de prendre l'atout
    public Future<Boolean> proposeAtout(List<Carte> main, Carte proposition, Position position) {
        return CompletableFuture.completedFuture(random.nextInt(4) == 0);
    }

    // 25% de chance de choisir une carte aléatoire comme atout
    public Future<Carte> remplaceAtout(List<Carte> main, Carte ancienAtout, Position position) {
        if(random.nextInt(4) == 0){
            return CompletableFuture.completedFuture(main.get(random.nextInt(main.size())));
        }
        return CompletableFuture.completedFuture(null);
    }
}
