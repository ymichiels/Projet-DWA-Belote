package message.partie.serveur;

import dao.pojo.Carte;
import logic.Tapis;

import java.util.List;

public class MessagePlisBelote extends MessagePartie {
    protected Carte.Couleur atout;
    protected Tapis tapis;
    protected List<Carte> carteJouable;

    public Carte.Couleur getAtout() {
        return atout;
    }
    public void setAtout(Carte.Couleur atout) {
        this.atout = atout;
    }

    public Tapis getTapis() {
        return tapis;
    }
    public void setTapis(Tapis tapis) {
        this.tapis = tapis;
    }

    public List<Carte> getCarteJouable() {
        return carteJouable;
    }
    public void setCarteJouable(List<Carte> carteJouable) {
        this.carteJouable = carteJouable;
    }
}
