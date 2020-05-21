package dao.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author jcebollado
 */
@Entity
@Table(name = "partie")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Partie.findAll", query = "SELECT p FROM Partie p")
        , @NamedQuery(name = "Partie.findByPartieId", query = "SELECT p FROM Partie p WHERE p.partieId = :partieId")
        , @NamedQuery(name = "Partie.findByScoreEq1", query = "SELECT p FROM Partie p WHERE p.scoreEq1 = :scoreEq1")
        , @NamedQuery(name = "Partie.findByScoreEq2", query = "SELECT p FROM Partie p WHERE p.scoreEq2 = :scoreEq2")
        , @NamedQuery(name = "Partie.findByDuree", query = "SELECT p FROM Partie p WHERE p.duree = :duree")})
public class Partie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @TableGenerator(
            name = "partiePkGen",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "joueur",
            valueColumnName = "SEQ_COUNT",
            table = "SEQUENCE"
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "partiePkGen")
    @Column(name = "partie_id")
    private Integer partieId;

    @JoinColumn(name = "eq_1a")
    private Joueur eq1a;
    @JoinColumn(name = "eq_1b")
    private Joueur eq1b;
    @Column(name = "score_eq1")
    private Short scoreEq1;

    @JoinColumn(name = "eq_2a")
    private Joueur eq2a;
    @JoinColumn(name = "eq_2b")
    private Joueur eq2b;
    @Column(name = "score_eq2")
    private Short scoreEq2;

    /* BUGGER (soit un bug dans eclipse link, soit un problème dans le code ?)
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(column = @Column(name = "score_eq1"), name = "score"),
        @AttributeOverride(column = @Column(name = "eq_1a"), name = "joueurA"),
        @AttributeOverride(column = @Column(name = "eq_1b"), name = "joueurB")
    })
    private Equipe equipe1;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(column = @Column(name = "score_eq2"), name = "score"),
        @AttributeOverride(column = @Column(name = "eq_2a"), name = "joueurA"),
        @AttributeOverride(column = @Column(name = "eq_2b"), name = "joueurB")
    })
    private Equipe equipe2;*/
    @Column(name = "duree")
    @Temporal(TemporalType.TIME)
    private Date duree;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partie")
    private Collection<Manche> mancheCollection;

    public Partie() {
    }

    public Partie(Integer partieId) {
        this.partieId = partieId;
    }

    public Integer getPartieId() {
        return partieId;
    }

    public void setPartieId(Integer partieId) {
        this.partieId = partieId;
    }

    public Joueur getEq1a() {
        return eq1a;
    }

    public void setEq1a(Joueur eq1a) {
        this.eq1a = eq1a;
    }

    public Joueur getEq1b() {
        return eq1b;
    }

    public void setEq1b(Joueur eq1b) {
        this.eq1b = eq1b;
    }

    public Short getScoreEq1() {
        return scoreEq1;
    }

    public void setScoreEq1(Short scoreEq1) {
        this.scoreEq1 = scoreEq1;
    }

    public Joueur getEq2a() {
        return eq2a;
    }

    public void setEq2a(Joueur eq2a) {
        this.eq2a = eq2a;
    }

    public Joueur getEq2b() {
        return eq2b;
    }

    public void setEq2b(Joueur eq2b) {
        this.eq2b = eq2b;
    }

    public Short getScoreEq2() {
        return scoreEq2;
    }

    public void setScoreEq2(Short scoreEq2) {
        this.scoreEq2 = scoreEq2;
    }

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    /*public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }*/

    @XmlTransient
    public Collection<Manche> getMancheCollection() {
        return mancheCollection;
    }

    public void setMancheCollection(Collection<Manche> mancheCollection) {
        this.mancheCollection = mancheCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partieId != null ? partieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partie)) {
            return false;
        }
        Partie other = (Partie) object;
        if ((this.partieId == null && other.partieId != null) || (this.partieId != null && !this.partieId.equals(other.partieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.Partie[ partieId=" + partieId + " ]";
    }

}
