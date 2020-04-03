/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author USER
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
        return "jpa_data.PlisPK[ partieId=" + partieId + ", mancheNb=" + mancheNb + ", plisNb=" + plisNb + " ]";
    }
    
}
