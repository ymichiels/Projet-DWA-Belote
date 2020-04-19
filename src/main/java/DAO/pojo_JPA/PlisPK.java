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
public class PlisPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "partie_id")
    private int partieId;
    @Basic(optional = false)
    @Column(name = "manche_nb")
    private short mancheNb;
    @Basic(optional = false)
    @Column(name = "plis_nb")
    private short plisNb;

    public PlisPK() {
    }

    public PlisPK(int partieId, short mancheNb, short plisNb) {
        this.partieId = partieId;
        this.mancheNb = mancheNb;
        this.plisNb = plisNb;
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

    public short getPlisNb() {
        return plisNb;
    }

    public void setPlisNb(short plisNb) {
        this.plisNb = plisNb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) partieId;
        hash += (int) mancheNb;
        hash += (int) plisNb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlisPK)) {
            return false;
        }
        PlisPK other = (PlisPK) object;
        if (this.partieId != other.partieId) {
            return false;
        }
        if (this.mancheNb != other.mancheNb) {
            return false;
        }
        if (this.plisNb != other.plisNb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.PlisPK[ partieId=" + partieId + ", mancheNb=" + mancheNb + ", plisNb=" + plisNb + " ]";
    }
    
}
