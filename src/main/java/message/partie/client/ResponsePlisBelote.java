package message.partie.client;

import dao.pojo.Carte;
import logic.Play;

public class ResponsePlisBelote extends ResponsePartie {
    /**
     * Peut être null, "belote" ou "rebelote"
     */
    private Play.Note note;
    private Carte carte;

    public Play.Note getNote() {
        return note;
    }
    public void setNote(Play.Note note) {
        this.note = note;
    }

    public Carte getCarte() {
        return carte;
    }
    public void setCarte(Carte carte) {
        this.carte = carte;
    }
}
