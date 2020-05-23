package message.partie.serveur;

import dao.pojo.Carte;

public class MessageSelectionAtout extends MessagePartie {
    protected Carte proposition;

    public Carte getProposition() {
        return proposition;
    }

    public void setProposition(Carte proposition) {
        this.proposition = proposition;
    }
}
