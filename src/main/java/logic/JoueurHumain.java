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
    public void informeScore(Score diff, Score total) {
        ObjectMapper om = new ObjectMapper();
        MessageChangementScore mcs = new MessageChangementScore();
        mcs.setChangement(diff);
        mcs.setTotal(total);
        mcs.setPosition(pos);
        mcs.setMain(null);
        mcs.setTour(null);
        wsp.send(mcs);
    }

    @Override
    public Future<Play> joueCarte(List<Carte> jouable, Plis plis) {
        MessagePlisBelote mpb = new MessagePlisBelote();
        mpb.setAtout(atout);
        mpb.setCarteJouable(jouable);
        mpb.setMain(main);
        mpb.setTapis(plis.getTapis());
        mpb.setTour(pos);
        mpb.setPosition(pos);
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
    public void finAutreTour(Plis plis, Position tour) {
        MessagePlisBelote mpb = new MessagePlisBelote();
        mpb.setAtout(atout);
        mpb.setCarteJouable(new ArrayList<>());
        mpb.setMain(main);
        mpb.setTapis(plis.getTapis());
        mpb.setTour(tour);
        mpb.setPosition(pos);
        wsp.send(mpb);
    }

    @Override
    public Future<Boolean> proposeAtout(Carte proposition) {
        MessageSelectionAtout msa = new MessageSelectionAtout();
        msa.setMain(main);
        msa.setProposition(proposition);
        msa.setPosition(pos);
        msa.setTour(pos);
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
    public void finSelectionAtout(Carte atout, boolean pris, Position tour) {
        MessageSelectionAtout msa = new MessageSelectionAtout();
        msa.setMain(main);
        msa.setProposition(atout);
        msa.setPosition(pos);
        msa.setTour(tour);
        wsp.send(msa);
    }

    @Override
    public Future<Carte> remplaceAtout(Carte ancienAtout) {
        MessageRemplacementAtout mra = new MessageRemplacementAtout();
        mra.setAncientAtout(ancienAtout);
        mra.setMain(main);
        mra.setPosition(pos);
        mra.setTour(pos);
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

    @Override
    public void finRemplacementAtout(Carte carte, Position tour) {
        MessageRemplacementAtout mra = new MessageRemplacementAtout();
        mra.setAncientAtout(carte);
        mra.setMain(main);
        mra.setPosition(pos);
        mra.setTour(tour);
        wsp.send(mra);
    }
}
