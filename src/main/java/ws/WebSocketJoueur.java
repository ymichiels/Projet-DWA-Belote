package ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import upkeep.RegistryPlayer;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Envoie la liste des utilisateur connecté et garde le client a jour.
 */
@ServerEndpoint("/ws/users")
public class WebSocketJoueur implements RegistryPlayer.ChangeRegistry {
    protected Session session;

    /**
     * Methode appeler à l'ouverture du WebSocket.
     * Stocke la {@param session} et envoie la liste des joueurs connecté au client dans un tableau json
     * @param session la connection du websocket
     */
    @OnOpen
    public void start(Session session) {
        System.out.println("Got a sub to /ws/user by an user. Giving Id " + session.getId());
        this.session = session;
        try {
            try {
                ObjectMapper om = new ObjectMapper();
                String data = om.writeValueAsString(RegistryPlayer.listClient());
                session.getBasicRemote().sendText(data);
            } catch (JsonProcessingException err) {
                // failed to serialize the list of player
                session.getBasicRemote().sendText("[]");
                err.printStackTrace();
            }
        } catch (IOException err) {
            // failed to write data to the client
            err.printStackTrace();
        }
    }

    @OnClose
    public void end() {
        System.out.println("User to websocket /ws/user n°" + session.getId() + " has left");
        RegistryPlayer.unregister(this);
    }

    /**
     * Noop; pas de traitement de message particulier. Mais pas sure si la méthode peut être supprimé
     * TODO support change state player from message
     * @param message le message envoyer par le client
     */
    @OnMessage
    public void incoming(String message) {
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        // TODO error handling
    }

    @Override
    public void onPlayerStateChange(RegistryPlayer.Client cli) {
        try {
            ObjectMapper om = new ObjectMapper();
            String data = om.writeValueAsString(cli);
            this.session.getBasicRemote().sendText(data);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
