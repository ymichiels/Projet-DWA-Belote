package message.partie.client;

import dao.pojo.Carte;

public class ResponseRemplacementAtout extends ResponsePartie {
    protected Carte remplacement;

    public Carte getRemplacement() {
        return remplacement;
    }
    public void setRemplacement(Carte remplacement) {
        this.remplacement = remplacement;
    }
}
