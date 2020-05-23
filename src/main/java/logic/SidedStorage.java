package logic;

public class SidedStorage<T> {
    protected T nord;
    protected T est;
    protected T sud;
    protected T ouest;

    public T getSide(Position position) {
        switch (position) {
            case Nord:
                return this.nord;
            case Est:
                return this.est;
            case Sud:
                return this.sud;
            case Ouest:
                return this.ouest;
        }
        return null;
    }
    public void setSide(Position position, T elt) {
        switch (position) {
            case Nord:
                this.nord = elt;
            case Est:
                this.est = elt;
            case Sud:
                this.sud = elt;
            case Ouest:
                this.ouest = elt;
        }
    }

    public T getNord() {
        return nord;
    }
    public void setNord(T nord) {
        this.nord = nord;
    }

    public T getEst() {
        return est;
    }
    public void setEst(T est) {
        this.est = est;
    }

    public T getSud() {
        return sud;
    }
    public void setSud(T sud) {
        this.sud = sud;
    }

    public T getOuest() {
        return ouest;
    }
    public void setOuest(T ouest) {
        this.ouest = ouest;
    }
}
