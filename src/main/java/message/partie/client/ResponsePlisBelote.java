package message.partie.client;

import dao.pojo.Carte;
import dao.pojo.EvenementPlis;

public class ResponsePlisBelote extends ResponsePartie {
    /**
     * Peut être null, "belote" ou "rebelote"
     */
    private EvenementPlis note;
    private Carte carte;

    public EvenementPlis getNote() {
        return note;
    }
    public void setNote(EvenementPlis note) {
        this.note = note;
    }

    public Carte getCarte() {
        return carte;
    }
    public void setCarte(Carte carte) {
        this.carte = carte;
    }
}
