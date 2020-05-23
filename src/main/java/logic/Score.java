package logic;

public class Score {
    protected int nordSud = 0;
    protected int estOuest = 0;

    public int getNordSud() {
        return nordSud;
    }
    public void setNordSud(int nordSud) {
        this.nordSud = nordSud;
    }

    public int getEstOuest() {
        return estOuest;
    }
    public void setEstOuest(int estOuest) {
        this.estOuest = estOuest;
    }

    public void add(Score other){
        this.estOuest += other.estOuest;
        this.nordSud += other.nordSud;
    }
}
