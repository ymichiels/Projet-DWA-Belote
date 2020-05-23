package logic;


import dao.pojo.Carte;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class IABasic extends Joueur {
    private Random random = new Random();

    @Override
    public Future<Play> joueCarte(List<Carte> jouable, Plis plis) {
        Carte carte = jouable.get(random.nextInt(jouable.size()));
        Play play = new Play();
        play.setCarte(carte);
        play.setNote(null);
        return CompletableFuture.completedFuture(play);
    }

    // 25% de chance de prendre l'atout
    public Future<Boolean> proposeAtout(Carte proposition) {
        return CompletableFuture.completedFuture(random.nextInt(4) == 0);
    }

    // 25% de chance de choisir une carte aléatoire comme atout
    public Future<Carte> remplaceAtout(Carte ancienAtout) {
        if(random.nextInt(4) == 0){
            return CompletableFuture.completedFuture(main.get(random.nextInt(main.size())));
        }
        return CompletableFuture.completedFuture(null);
    }
}
