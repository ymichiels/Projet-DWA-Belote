/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "couleur")
@NamedQueries({
    @NamedQuery(name = "Couleur.findAll", query = "SELECT c FROM Couleur c"),
    @NamedQuery(name = "Couleur.findByCouleurId", query = "SELECT c FROM Couleur c WHERE c.couleurId = :couleurId"),
    @NamedQuery(name = "Couleur.findByIntitule", query = "SELECT c FROM Couleur c WHERE c.intitule = :intitule")})
public class Couleur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "couleur_id")
    private Short couleurId;
    @Column(name = "intitule")
    private String intitule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couleurId")
    private Collection<Carte> carteCollection;

    public Couleur() {
    }

    public Couleur(Short couleurId) {
        this.couleurId = couleurId;
    }

    public Short getCouleurId() {
        return couleurId;
    }

    public void setCouleurId(Short couleurId) {
        this.couleurId = couleurId;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Collection<Carte> getCarteCollection() {
        return carteCollection;
    }

    public void setCarteCollection(Collection<Carte> carteCollection) {
        this.carteCollection = carteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couleurId != null ? couleurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Couleur)) {
            return false;
        }
        Couleur other = (Couleur) object;
        if ((this.couleurId == null && other.couleurId != null) || (this.couleurId != null && !this.couleurId.equals(other.couleurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Couleur[ couleurId=" + couleurId + " ]";
    }
    
}
