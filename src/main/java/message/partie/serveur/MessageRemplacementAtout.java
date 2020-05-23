package message.partie.serveur;

import dao.pojo.Carte;

public class MessageRemplacementAtout extends MessagePartie {
    protected Carte ancientAtout;

    public Carte getAncientAtout() {
        return ancientAtout;
    }

    public void setAncientAtout(Carte ancientAtout) {
        this.ancientAtout = ancientAtout;
    }
}
