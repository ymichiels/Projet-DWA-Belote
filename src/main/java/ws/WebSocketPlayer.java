package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import message.partie.client.ResponsePartie;
import upkeep.RegistryPlayers;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Web socket utiliser pour les communication durant une partie
 * TODO implementer un secret a inserer dans la page.jsp pour attester de l'identité du client
 */
@ServerEndpoint("/ws/partie")
public class WebSocketPlayer {
    public static final int BUFFER_MAX_MESSAGE = 20;
    private Session session;
    /**
     * Buffer storing message until processed by the JoueurHumain
     */
    private ArrayBlockingQueue<ResponsePartie> messageBackLog = new ArrayBlockingQueue<>(BUFFER_MAX_MESSAGE);

    /**
     * Pourra stocker une chaine de caractère vérifiant que l'utilisateur est bien
     */
    private String secret;

    @OnOpen
    public void start(Session session) {

        Pattern regPartieId = Pattern.compile("(?:^|&)idClient=(\\d+)(?:&|$)");
        Matcher partie = regPartieId.matcher(session.getRequestURI().getQuery());
        if (!partie.find()) {
            try {
                session.getBasicRemote().sendText("{\"error\":\"No partie Id in the URI\"}");
                session.close();
            } catch (IOException err) {
                err.printStackTrace();
            }
            return;
        }
        int idPartie = Integer.parseInt(partie.group(1));
        RegistryPlayers.registerClient(idPartie, this);
        this.session = session;
    }

    public void send(Object obj) {
        ObjectMapper om = new ObjectMapper();
        try {
            String data = om.writeValueAsString(obj);
            session.getBasicRemote().sendText(data);
        }catch (IOException err) {
            err.printStackTrace();
        }
    }

    /**
     * Retourne le dernier message recu par le websocket
     * Peut stocker jusqu'à {@link WebSocketPlayer#BUFFER_MAX_MESSAGE} message
     * @return le derniemer message recu par le websocket
     */
    public ResponsePartie poll() {
        return messageBackLog.poll();
    }

    @OnMessage
    public void incoming(String message) {
        ObjectMapper om = new ObjectMapper();
        try {
            ResponsePartie rp = om.readValue(message, ResponsePartie.class);
            this.messageBackLog.add(rp);
        }catch (IOException err) {
            err.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        // TODO error handling
    }
}
