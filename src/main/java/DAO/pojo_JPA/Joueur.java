package DAO.pojo_JPA;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author jcebollado
 * inheritance based on http://www.thejavageek.com/2014/05/17/jpa-joined-inheritance-example/
 */
@Entity
@Table(name = "joueur")
@XmlRootElement
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
    @NamedQuery(name = "Joueur.findAll", query = "SELECT j FROM Joueur j")
    , @NamedQuery(name = "Joueur.findByJoueurId", query = "SELECT j FROM Joueur j WHERE j.joueurId = :joueurId")
    , @NamedQuery(name = "Joueur.findByNbVictoire", query = "SELECT j FROM Joueur j WHERE j.nbVictoire = :nbVictoire")
    , @NamedQuery(name = "Joueur.findByScoreMoyen", query = "SELECT j FROM Joueur j WHERE j.scoreMoyen = :scoreMoyen")
    , @NamedQuery(name = "Joueur.findByNbPartie", query = "SELECT j FROM Joueur j WHERE j.nbPartie = :nbPartie")
    , @NamedQuery(name = "Joueur.findByPseudo", query = "SELECT j FROM Joueur j WHERE j.pseudo = :pseudo")})
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(
            name = "joueurPkGen",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "joueur",
            valueColumnName = "SEQ_COUNT", 
            table = "SEQUENCE"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "joueurPkGen")
    @Column(name = "joueur_id")
    private Integer joueurId;
    @Column(name = "nb_victoire")
    private Integer nbVictoire;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "score_moyen")
    private Float scoreMoyen;
    @Column(name = "nb_partie")
    private Integer nbPartie;
    @Basic(optional = false)
    @Column(name = "pseudo")
    private String pseudo;
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "joueur")
    private Robot robot;*/
    @OneToMany(mappedBy = "joueurDebut")
    private Collection<Plis> plisCollection;
    @OneToMany(mappedBy = "eq1a")
    private Collection<Partie> partieCollection;
    @OneToMany(mappedBy = "eq1b")
    private Collection<Partie> partieCollection1;
    @OneToMany(mappedBy = "eq2a")
    private Collection<Partie> partieCollection2;
    @OneToMany(mappedBy = "eq2b")
    private Collection<Partie> partieCollection3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joueur")
    private Collection<Main> mainCollection;
    @OneToMany(mappedBy = "joueurPrenant")
    private Collection<Manche> mancheCollection;
    /*@OneToOne(cascade = CascadeType.ALL, mappedBy = "joueur")
    private Humain humain;*/

    public Joueur() {
    }

    public Joueur(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Joueur(Integer joueurId, String pseudo) {
        this.joueurId = joueurId;
        this.pseudo = pseudo;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Integer getNbVictoire() {
        return nbVictoire;
    }

    public void setNbVictoire(Integer nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

    public Float getScoreMoyen() {
        return scoreMoyen;
    }

    public void setScoreMoyen(Float scoreMoyen) {
        this.scoreMoyen = scoreMoyen;
    }

    public Integer getNbPartie() {
        return nbPartie;
    }

    public void setNbPartie(Integer nbPartie) {
        this.nbPartie = nbPartie;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /*public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }*/

    @XmlTransient
    public Collection<Plis> getPlisCollection() {
        return plisCollection;
    }

    public void setPlisCollection(Collection<Plis> plisCollection) {
        this.plisCollection = plisCollection;
    }

    @XmlTransient
    public Collection<Partie> getPartieCollection() {
        return partieCollection;
    }

    public void setPartieCollection(Collection<Partie> partieCollection) {
        this.partieCollection = partieCollection;
    }

    @XmlTransient
    public Collection<Partie> getPartieCollection1() {
        return partieCollection1;
    }

    public void setPartieCollection1(Collection<Partie> partieCollection1) {
        this.partieCollection1 = partieCollection1;
    }

    @XmlTransient
    public Collection<Partie> getPartieCollection2() {
        return partieCollection2;
    }

    public void setPartieCollection2(Collection<Partie> partieCollection2) {
        this.partieCollection2 = partieCollection2;
    }

    @XmlTransient
    public Collection<Partie> getPartieCollection3() {
        return partieCollection3;
    }

    public void setPartieCollection3(Collection<Partie> partieCollection3) {
        this.partieCollection3 = partieCollection3;
    }

    @XmlTransient
    public Collection<Main> getMainCollection() {
        return mainCollection;
    }

    public void setMainCollection(Collection<Main> mainCollection) {
        this.mainCollection = mainCollection;
    }

    @XmlTransient
    public Collection<Manche> getMancheCollection() {
        return mancheCollection;
    }

    public void setMancheCollection(Collection<Manche> mancheCollection) {
        this.mancheCollection = mancheCollection;
    }

    /*public Humain getHumain() {
        return humain;
    }

    public void setHumain(Humain humain) {
        this.humain = humain;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (joueurId != null ? joueurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.joueurId == null && other.joueurId != null) || (this.joueurId != null && !this.joueurId.equals(other.joueurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.Joueur[ joueurId=" + joueurId + " ]";
    }
    
}
