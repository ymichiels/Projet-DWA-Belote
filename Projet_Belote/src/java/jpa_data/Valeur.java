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
@Table(name = "valeur")
@NamedQueries({
    @NamedQuery(name = "Valeur.findAll", query = "SELECT v FROM Valeur v"),
    @NamedQuery(name = "Valeur.findByValeurId", query = "SELECT v FROM Valeur v WHERE v.valeurId = :valeurId"),
    @NamedQuery(name = "Valeur.findByIntitule", query = "SELECT v FROM Valeur v WHERE v.intitule = :intitule")})
public class Valeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "valeur_id")
    private Short valeurId;
    @Basic(optional = false)
    @Column(name = "intitule")
    private String intitule;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valeurId")
    private Collection<Carte> carteCollection;

    public Valeur() {
    }

    public Valeur(Short valeurId) {
        this.valeurId = valeurId;
    }

    public Valeur(Short valeurId, String intitule) {
        this.valeurId = valeurId;
        this.intitule = intitule;
    }

    public Short getValeurId() {
        return valeurId;
    }

    public void setValeurId(Short valeurId) {
        this.valeurId = valeurId;
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
        hash += (valeurId != null ? valeurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valeur)) {
            return false;
        }
        Valeur other = (Valeur) object;
        if ((this.valeurId == null && other.valeurId != null) || (this.valeurId != null && !this.valeurId.equals(other.valeurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Valeur[ valeurId=" + valeurId + " ]";
    }
    
}
