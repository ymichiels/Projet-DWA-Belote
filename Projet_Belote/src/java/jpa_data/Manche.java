/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "manche")
@NamedQueries({
    @NamedQuery(name = "Manche.findAll", query = "SELECT m FROM Manche m"),
    @NamedQuery(name = "Manche.findByPartieId", query = "SELECT m FROM Manche m WHERE m.manchePK.partieId = :partieId"),
    @NamedQuery(name = "Manche.findByMancheNb", query = "SELECT m FROM Manche m WHERE m.manchePK.mancheNb = :mancheNb"),
    @NamedQuery(name = "Manche.findByCouleurAtout", query = "SELECT m FROM Manche m WHERE m.couleurAtout = :couleurAtout"),
    @NamedQuery(name = "Manche.findByPointManche", query = "SELECT m FROM Manche m WHERE m.pointManche = :pointManche")})
public class Manche implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManchePK manchePK;
    @Column(name = "couleur_atout")
    private String couleurAtout;
    @Column(name = "point_manche")
    private Short pointManche;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manche")
    private Collection<Plis> plisCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manche")
    private Collection<Main> mainCollection;
    @JoinColumn(name = "partie_id", referencedColumnName = "partie_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partie partie;
    @JoinColumn(name = "joueur_prenant", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur joueurPrenant;
    @JoinColumn(name = "atout_initial", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte atoutInitial;
    @JoinColumn(name = "atout_final", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte atoutFinal;

    public Manche() {
    }

    public Manche(ManchePK manchePK) {
        this.manchePK = manchePK;
    }

    public Manche(int partieId, short mancheNb) {
        this.manchePK = new ManchePK(partieId, mancheNb);
    }

    public ManchePK getManchePK() {
        return manchePK;
    }

    public void setManchePK(ManchePK manchePK) {
        this.manchePK = manchePK;
    }

    public String getCouleurAtout() {
        return couleurAtout;
    }

    public void setCouleurAtout(String couleurAtout) {
        this.couleurAtout = couleurAtout;
    }

    public Short getPointManche() {
        return pointManche;
    }

    public void setPointManche(Short pointManche) {
        this.pointManche = pointManche;
    }

    public Collection<Plis> getPlisCollection() {
        return plisCollection;
    }

    public void setPlisCollection(Collection<Plis> plisCollection) {
        this.plisCollection = plisCollection;
    }

    public Collection<Main> getMainCollection() {
        return mainCollection;
    }

    public void setMainCollection(Collection<Main> mainCollection) {
        this.mainCollection = mainCollection;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public Joueur getJoueurPrenant() {
        return joueurPrenant;
    }

    public void setJoueurPrenant(Joueur joueurPrenant) {
        this.joueurPrenant = joueurPrenant;
    }

    public Carte getAtoutInitial() {
        return atoutInitial;
    }

    public void setAtoutInitial(Carte atoutInitial) {
        this.atoutInitial = atoutInitial;
    }

    public Carte getAtoutFinal() {
        return atoutFinal;
    }

    public void setAtoutFinal(Carte atoutFinal) {
        this.atoutFinal = atoutFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manchePK != null ? manchePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manche)) {
            return false;
        }
        Manche other = (Manche) object;
        if ((this.manchePK == null && other.manchePK != null) || (this.manchePK != null && !this.manchePK.equals(other.manchePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Manche[ manchePK=" + manchePK + " ]";
    }
    
}
