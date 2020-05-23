package upkeep;

import ws.WebSocketPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Waiting room for the parties until all the client connect
 */
public class RegistryPlayers {
    private static HashMap<Integer, WebSocketPlayer> listClient = new HashMap<>();

    private static List<AwaitConnection> listWaiter = new ArrayList<>();

    interface AwaitConnection {
        /**
         * Interface for partie to wait for an client to connect.
         * Return false when the Awaiter is done waiting; true if more value are needed
         * @param clientId the id of the client
         * @param client the class handling the connection
         * @return whether the handler should still be call
         */
        boolean onConnect(int clientId, WebSocketPlayer client);
    }

    static public void registerClient(int clientId, WebSocketPlayer webSocketPartie) {
        listClient.put(clientId, webSocketPartie);
        List<AwaitConnection> newList = new ArrayList<>();
        for(AwaitConnection ac : listWaiter) {
            if(ac.onConnect(clientId, webSocketPartie)) {
                newList.add(ac);
            }
        }
        listWaiter = newList;
    }
    static public void unregisterClient(int clientId) {
        listClient.remove(clientId);
    }

    static public void registerAwaiter(AwaitConnection ac) {
        for(Integer key : listClient.keySet()){
            WebSocketPlayer wsp = listClient.get(key);
            if(!ac.onConnect(key, wsp)) {
                return;
            }
        }
        listWaiter.add(ac);
    }
}
