package DAO.pojo_JPA;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author jcebollado
 */
@Embeddable
public class MainPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "partie_id")
    private int partieId;
    @Basic(optional = false)
    @Column(name = "manche_nb")
    private short mancheNb;
    @Basic(optional = false)
    @Column(name = "joueur_id")
    private int joueurId;

    public MainPK() {
    }

    public MainPK(int partieId, short mancheNb, int joueurId) {
        this.partieId = partieId;
        this.mancheNb = mancheNb;
        this.joueurId = joueurId;
    }

    public int getPartieId() {
        return partieId;
    }

    public void setPartieId(int partieId) {
        this.partieId = partieId;
    }

    public short getMancheNb() {
        return mancheNb;
    }

    public void setMancheNb(short mancheNb) {
        this.mancheNb = mancheNb;
    }

    public int getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(int joueurId) {
        this.joueurId = joueurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) partieId;
        hash += (int) mancheNb;
        hash += (int) joueurId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MainPK)) {
            return false;
        }
        MainPK other = (MainPK) object;
        if (this.partieId != other.partieId) {
            return false;
        }
        if (this.mancheNb != other.mancheNb) {
            return false;
        }
        if (this.joueurId != other.joueurId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.MainPK[ partieId=" + partieId + ", mancheNb=" + mancheNb + ", joueurId=" + joueurId + " ]";
    }
    
}
