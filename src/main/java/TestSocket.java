import dao.helper.ManagerJoueur;
import dao.pojo.Joueur;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import javax.websocket.*;
import javax.websocket.server.*;
import java.io.IOException;
import java.util.List;

// défini l'URL du socket
@ServerEndpoint("/ws/dummy")
public class TestSocket {
    private Session session;

    // methode appeler lorsque la connection se fait
    // la connection peut être récuper depuis la variable session
    // une nouvelle instance de TestSocket sera créé par connection
    @OnOpen
    public void start(Session session) {
        this.session = session;
        System.out.println("Starting session with " + session.getId());
    }

    @OnClose
    public void end() {
        System.out.println("Closing connection");
    }

    // on reçoit un message
    @OnMessage
    public void incoming(String message) {
        System.out.println("Received a message from the websocket: " + message);
        try {
            try {
                // récupère la liste de joueur en passant par JPA
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
                EntityManager em = emf.createEntityManager();
                EntityTransaction trans = em.getTransaction();
                trans.begin();
                ManagerJoueur mj = new ManagerJoueur(em);
                List<Joueur> ljoueur = mj.findByClassment(20);
                trans.commit();

                // serialize les données en json
                ObjectMapper om = new ObjectMapper();
                String data = om.writerWithDefaultPrettyPrinter().writeValueAsString(ljoueur);

                // envoie les données sur le websocket
                session.getBasicRemote().sendText(data);
            } catch (RuntimeException err) { // problème lors de l'exécution (probablement avec JPA)
                // fixme proper protocol
                String text = "{\"status\": \"error\", \"message\":\"" + err.getMessage() + "\"}";
                session.getBasicRemote().sendText(text);
                throw err;
            }
        } catch (IOException err) { // problème avec le websocket
            err.printStackTrace();
        }
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        // TODO error handling
    }
}
