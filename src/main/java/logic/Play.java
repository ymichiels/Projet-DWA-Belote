package logic;

import dao.pojo.Carte;

public class Play {
    private Carte carte;
    private Note note;

    public Carte getCarte() {
        return carte;
    }
    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Note getNote() {
        return note;
    }
    public void setNote(Note note) {
        this.note = note;
    }

    public enum Note {
        Belote, Rebelote;
    }
}
