package logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.pojo.Carte;
import message.partie.client.ResponsePartie;
import message.partie.client.ResponsePlisBelote;
import message.partie.client.ResponseRemplacementAtout;
import message.partie.client.ResponseSelectionAtout;
import message.partie.serveur.MessageChangementScore;
import message.partie.serveur.MessagePlisBelote;
import message.partie.serveur.MessageRemplacementAtout;
import message.partie.serveur.MessageSelectionAtout;
import ws.WebSocketPartie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class JoueurHumain extends Joueur {
    WebSocketPartie wsp;

    public JoueurHumain(WebSocketPartie wsp) {
        this.wsp = wsp;
    }

    @Override
    public void informeScore(Score diff, Score total, Position position) {
        ObjectMapper om = new ObjectMapper();
        MessageChangementScore mcs = new MessageChangementScore();
        mcs.setChangement(diff);
        mcs.setTotal(total);
        mcs.setPosition(position);
        mcs.setMain(null);
        mcs.setTour(null);
        wsp.send(mcs);
    }

    @Override
    public Future<Play> joueCarte(List<Carte> main, List<Carte> jouable, Plis plis, Carte.Couleur atout, Position position) {
        MessagePlisBelote mpb = new MessagePlisBelote();
        mpb.setAtout(atout);
        mpb.setCarteJouable(jouable);
        mpb.setMain(main);
        mpb.setTapis(plis.getTapis());
        mpb.setTour(position);
        mpb.setPosition(position);
        wsp.send(mpb);
        // await client response... I think
        return CompletableFuture.supplyAsync(() -> {
            ResponsePartie rp;
            while(true) {
                while((rp = wsp.poll()) == null) {
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException err) {
                        // noop
                    }
                }
                if(rp instanceof ResponsePlisBelote) {
                    ResponsePlisBelote rpb = (ResponsePlisBelote) rp;
                    Play play = new Play();
                    play.setNote(rpb.getNote());
                    play.setCarte(rpb.getCarte());
                    return play;
                }
            }
        });
    }

    @Override
    public void finAutreTour(List<Carte> main, Plis plis, Carte.Couleur atout, Position position, Position tour) {
        MessagePlisBelote mpb = new MessagePlisBelote();
        mpb.setAtout(atout);
        mpb.setCarteJouable(new ArrayList<>());
        mpb.setMain(main);
        mpb.setTapis(plis.getTapis());
        mpb.setTour(tour);
        mpb.setPosition(position);
        wsp.send(mpb);
    }

    @Override
    public Future<Boolean> proposeAtout(List<Carte> main, Carte proposition, Position position) {
        MessageSelectionAtout msa = new MessageSelectionAtout();
        msa.setMain(main);
        msa.setProposition(proposition);
        msa.setPosition(position);
        msa.setTour(position);
        wsp.send(msa);
        return CompletableFuture.supplyAsync(() -> {
            ResponsePartie rp;
            while(true) {
                while((rp = wsp.poll()) == null) {
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException err) {
                        // noop
                    }
                }
                if(rp instanceof ResponseSelectionAtout) {
                    ResponseSelectionAtout rsa = (ResponseSelectionAtout) rp;
                    return rsa.isPrendAtout();
                }
            }
        });
    }

    @Override
    public Future<Carte> remplaceAtout(List<Carte> main, Carte ancienAtout, Position position) {
        MessageRemplacementAtout mra = new MessageRemplacementAtout();
        mra.setAncientAtout(ancienAtout);
        mra.setMain(main);
        mra.setPosition(position);
        mra.setTour(position);
        wsp.send(mra);
        return CompletableFuture.supplyAsync(() -> {
            ResponsePartie rp;
            while(true) {
                while((rp = wsp.poll()) == null) {
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException err) {
                        // noop
                    }
                }
                if(rp instanceof ResponseRemplacementAtout) {
                    ResponseRemplacementAtout rra = (ResponseRemplacementAtout) rp;
                    return rra.getRemplacement();
                }
            }
        });
    }
}
