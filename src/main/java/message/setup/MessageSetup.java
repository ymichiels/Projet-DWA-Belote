package message.setup;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dao.pojo.Humain;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessageCreationPartie.class, name = "newPartie"),
        @JsonSubTypes.Type(value = MessageDemandePartie.class, name = "retPartie"),
        @JsonSubTypes.Type(value = MessageInvitationJoueur.class, name = "invitation"),
        @JsonSubTypes.Type(value = MessageReponseInvitationJoueur.class, name = "response")
})
abstract public class MessageSetup {
    protected Humain host;

    public Humain getHost() {
        return this.host;
    }

    public void setHost(Humain host) {
        this.host = host;
    }
}
