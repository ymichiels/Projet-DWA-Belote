package logic.party;

import dao.pojo.Carte;
import dao.pojo.EvenementPlis;

public class Play {
    private Carte carte;
    private EvenementPlis note = null;

    public Carte getCarte() {
        return carte;
    }
    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public EvenementPlis getNote() {
        return note;
    }
    public void setNote(EvenementPlis note) {
        this.note = note;
    }
}
