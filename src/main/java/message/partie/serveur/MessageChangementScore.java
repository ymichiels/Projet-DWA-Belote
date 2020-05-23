package message.partie.serveur;

import logic.utils.Score;

public class MessageChangementScore extends MessagePartie {
    protected Score changement;
    protected Score total;

    public Score getChangement() {
        return changement;
    }
    public void setChangement(Score changement) {
        this.changement = changement;
    }

    public Score getTotal() {
        return total;
    }
    public void setTotal(Score total) {
        this.total = total;
    }
}
