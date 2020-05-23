package ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import message.partie.client.ResponsePartie;
import upkeep.RegistryClient;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ServerEndpoint("/ws/partie")
public class WebSocketPartie {
    private Session session;
    /**
     * Buffer storing message until processed by the JoueurHumain
     */
    private ArrayBlockingQueue<ResponsePartie> messageBackLog = new ArrayBlockingQueue<>(20);

    @OnOpen
    public void start(Session session) {

        Pattern r = Pattern.compile("(?:^|&)idClient=(\\d+)(?:&|$)");
        Matcher partie = r.matcher(session.getRequestURI().getQuery());
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
        RegistryClient.registerClient(idPartie, this);
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
}
