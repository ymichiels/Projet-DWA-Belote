package message.setup;

import dao.pojo.Joueur;

public class MessageReponseInvitationJoueur extends MessageSetup {
    public enum Response{
        Accept,
        Refuse,
    }

    protected Joueur joueur;
    protected int partieId;
    protected Response response;

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

    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }

}
