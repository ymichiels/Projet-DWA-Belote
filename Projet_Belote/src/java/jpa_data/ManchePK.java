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
public class ManchePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "partie_id")
    private int partieId;
    @Basic(optional = false)
    @Column(name = "manche_nb")
    private short mancheNb;

    public ManchePK() {
    }

    public ManchePK(int partieId, short mancheNb) {
        this.partieId = partieId;
        this.mancheNb = mancheNb;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) partieId;
        hash += (int) mancheNb;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManchePK)) {
            return false;
        }
        ManchePK other = (ManchePK) object;
        if (this.partieId != other.partieId) {
            return false;
        }
        if (this.mancheNb != other.mancheNb) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.ManchePK[ partieId=" + partieId + ", mancheNb=" + mancheNb + " ]";
    }
    
}
