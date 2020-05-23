package message.partie.serveur;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dao.pojo.Carte;
import logic.Position;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "etape"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessageSelectionAtout.class, name = "selectionAtout"),
        @JsonSubTypes.Type(value = MessageRemplacementAtout.class, name = "remplacementAtout"),
        @JsonSubTypes.Type(value = MessagePlisBelote.class, name = "invitation"),
        @JsonSubTypes.Type(value = MessageChangementScore.class, name = "changementScore")
})
abstract public class MessagePartie {

    protected Position tour;
    protected Position position;
    protected List<Carte> main;

    public Position getTour() {
        return tour;
    }
    public void setTour(Position tour) {
        this.tour = tour;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Carte> getMain() {
        return main;
    }
    public void setMain(List<Carte> main) {
        this.main = main;
    }
}
