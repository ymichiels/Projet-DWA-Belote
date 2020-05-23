package message.setup;

import dao.pojo.Joueur;

public class MessageInvitationJoueur extends MessageSetup {
    protected Joueur joueur;
    protected int partieId;

    public Joueur getJoueur() {
        return joueur;
    }
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public int getPartieId() {
        return partieId;
    }

    public void setPartieId(int partieId) {
        this.partieId = partieId;
    }
}
