/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "carte")
@NamedQueries({
    @NamedQuery(name = "Carte.findAll", query = "SELECT c FROM Carte c"),
    @NamedQuery(name = "Carte.findByCarteId", query = "SELECT c FROM Carte c WHERE c.carteId = :carteId")})
public class Carte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "carte_id")
    private Short carteId;
    @OneToMany(mappedBy = "carte1")
    private Collection<Plis> plisCollection;
    @OneToMany(mappedBy = "carte2")
    private Collection<Plis> plisCollection1;
    @OneToMany(mappedBy = "carte3")
    private Collection<Plis> plisCollection2;
    @OneToMany(mappedBy = "carte4")
    private Collection<Plis> plisCollection3;
    @JoinColumn(name = "couleur_id", referencedColumnName = "couleur_id")
    @ManyToOne(optional = false)
    private Couleur couleurId;
    @JoinColumn(name = "valeur_id", referencedColumnName = "valeur_id")
    @ManyToOne(optional = false)
    private Valeur valeurId;
    @OneToMany(mappedBy = "carte8")
    private Collection<Main> mainCollection;
    @OneToMany(mappedBy = "carte1")
    private Collection<Main> mainCollection1;
    @OneToMany(mappedBy = "carte2")
    private Collection<Main> mainCollection2;
    @OneToMany(mappedBy = "carte3")
    private Collection<Main> mainCollection3;
    @OneToMany(mappedBy = "carte4")
    private Collection<Main> mainCollection4;
    @OneToMany(mappedBy = "carte5")
    private Collection<Main> mainCollection5;
    @OneToMany(mappedBy = "carte6")
    private Collection<Main> mainCollection6;
    @OneToMany(mappedBy = "carte7")
    private Collection<Main> mainCollection7;
    @OneToMany(mappedBy = "atoutInitial")
    private Collection<Manche> mancheCollection;
    @OneToMany(mappedBy = "atoutFinal")
    private Collection<Manche> mancheCollection1;

    public Carte() {
    }

    public Carte(Short carteId) {
        this.carteId = carteId;
    }

    public Short getCarteId() {
        return carteId;
    }

    public void setCarteId(Short carteId) {
        this.carteId = carteId;
    }

    public Collection<Plis> getPlisCollection() {
        return plisCollection;
    }

    public void setPlisCollection(Collection<Plis> plisCollection) {
        this.plisCollection = plisCollection;
    }

    public Collection<Plis> getPlisCollection1() {
        return plisCollection1;
    }

    public void setPlisCollection1(Collection<Plis> plisCollection1) {
        this.plisCollection1 = plisCollection1;
    }

    public Collection<Plis> getPlisCollection2() {
        return plisCollection2;
    }

    public void setPlisCollection2(Collection<Plis> plisCollection2) {
        this.plisCollection2 = plisCollection2;
    }

    public Collection<Plis> getPlisCollection3() {
        return plisCollection3;
    }

    public void setPlisCollection3(Collection<Plis> plisCollection3) {
        this.plisCollection3 = plisCollection3;
    }

    public Couleur getCouleurId() {
        return couleurId;
    }

    public void setCouleurId(Couleur couleurId) {
        this.couleurId = couleurId;
    }

    public Valeur getValeurId() {
        return valeurId;
    }

    public void setValeurId(Valeur valeurId) {
        this.valeurId = valeurId;
    }

    public Collection<Main> getMainCollection() {
        return mainCollection;
    }

    public void setMainCollection(Collection<Main> mainCollection) {
        this.mainCollection = mainCollection;
    }

    public Collection<Main> getMainCollection1() {
        return mainCollection1;
    }

    public void setMainCollection1(Collection<Main> mainCollection1) {
        this.mainCollection1 = mainCollection1;
    }

    public Collection<Main> getMainCollection2() {
        return mainCollection2;
    }

    public void setMainCollection2(Collection<Main> mainCollection2) {
        this.mainCollection2 = mainCollection2;
    }

    public Collection<Main> getMainCollection3() {
        return mainCollection3;
    }

    public void setMainCollection3(Collection<Main> mainCollection3) {
        this.mainCollection3 = mainCollection3;
    }

    public Collection<Main> getMainCollection4() {
        return mainCollection4;
    }

    public void setMainCollection4(Collection<Main> mainCollection4) {
        this.mainCollection4 = mainCollection4;
    }

    public Collection<Main> getMainCollection5() {
        return mainCollection5;
    }

    public void setMainCollection5(Collection<Main> mainCollection5) {
        this.mainCollection5 = mainCollection5;
    }

    public Collection<Main> getMainCollection6() {
        return mainCollection6;
    }

    public void setMainCollection6(Collection<Main> mainCollection6) {
        this.mainCollection6 = mainCollection6;
    }

    public Collection<Main> getMainCollection7() {
        return mainCollection7;
    }

    public void setMainCollection7(Collection<Main> mainCollection7) {
        this.mainCollection7 = mainCollection7;
    }

    public Collection<Manche> getMancheCollection() {
        return mancheCollection;
    }

    public void setMancheCollection(Collection<Manche> mancheCollection) {
        this.mancheCollection = mancheCollection;
    }

    public Collection<Manche> getMancheCollection1() {
        return mancheCollection1;
    }

    public void setMancheCollection1(Collection<Manche> mancheCollection1) {
        this.mancheCollection1 = mancheCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carteId != null ? carteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carte)) {
            return false;
        }
        Carte other = (Carte) object;
        if ((this.carteId == null && other.carteId != null) || (this.carteId != null && !this.carteId.equals(other.carteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Carte[ carteId=" + carteId + " ]";
    }
    
}
