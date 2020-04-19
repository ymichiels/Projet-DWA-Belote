package DAO.pojo_JPA;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author jcebollado
 */
@Entity
@Table(name = "manche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manche.findAll", query = "SELECT m FROM Manche m")
    , @NamedQuery(name = "Manche.findByPartieId", query = "SELECT m FROM Manche m WHERE m.manchePK.partieId = :partieId")
    , @NamedQuery(name = "Manche.findByMancheNb", query = "SELECT m FROM Manche m WHERE m.manchePK.mancheNb = :mancheNb")
    , @NamedQuery(name = "Manche.findByAtoutInitial", query = "SELECT m FROM Manche m WHERE m.atoutInitial = :atoutInitial")
    , @NamedQuery(name = "Manche.findByAtoutFinal", query = "SELECT m FROM Manche m WHERE m.atoutFinal = :atoutFinal")
    , @NamedQuery(name = "Manche.findByPointManche", query = "SELECT m FROM Manche m WHERE m.pointManche = :pointManche")})
public class Manche implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManchePK manchePK;
    @Enumerated(EnumType.STRING)
    @Column(name = "atout_initial")
    private Carte atoutInitial;
    @Enumerated(EnumType.STRING)
    @Column(name = "atout_final")
    private Carte atoutFinal;
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

    public Carte getAtoutInitial() {
        return atoutInitial;
    }

    public void setAtoutInitial(Carte atoutInitial) {
        this.atoutInitial = atoutInitial;
        if(this.atoutFinal == null) {
            this.atoutFinal = atoutInitial;
        }
    }

    public Carte getAtoutFinal() {
        return atoutFinal;
    }

    public void setAtoutFinal(Carte atoutFinal) {
        this.atoutFinal = atoutFinal;
    }

    public Short getPointManche() {
        return pointManche;
    }

    public void setPointManche(Short pointManche) {
        this.pointManche = pointManche;
    }

    @XmlTransient
    public Collection<Plis> getPlisCollection() {
        return plisCollection;
    }

    public void setPlisCollection(Collection<Plis> plisCollection) {
        this.plisCollection = plisCollection;
    }

    @XmlTransient
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
    
    public Carte.Couleur getCouleurAtout() {
        return this.atoutFinal.getCouleur();
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
        return "dao.pojo.Manche[ manchePK=" + manchePK + " ]";
    }
    
}
