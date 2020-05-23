package message.partie.client;

import logic.Position;

abstract public class ResponsePartie {
    protected Position position;

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
