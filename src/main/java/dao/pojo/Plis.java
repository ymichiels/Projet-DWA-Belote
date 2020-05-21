package dao.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author jcebollado
 */
@Entity
@Table(name = "plis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plis.findAll", query = "SELECT p FROM Plis p")
    , @NamedQuery(name = "Plis.findByPartieId", query = "SELECT p FROM Plis p WHERE p.plisPK.partieId = :partieId")
    , @NamedQuery(name = "Plis.findByMancheNb", query = "SELECT p FROM Plis p WHERE p.plisPK.mancheNb = :mancheNb")
    , @NamedQuery(name = "Plis.findByPlisNb", query = "SELECT p FROM Plis p WHERE p.plisPK.plisNb = :plisNb")
    , @NamedQuery(name = "Plis.findByCarte1", query = "SELECT p FROM Plis p WHERE p.carte1 = :carte1")
    , @NamedQuery(name = "Plis.findByCarte2", query = "SELECT p FROM Plis p WHERE p.carte2 = :carte2")
    , @NamedQuery(name = "Plis.findByCarte3", query = "SELECT p FROM Plis p WHERE p.carte3 = :carte3")
    , @NamedQuery(name = "Plis.findByCarte4", query = "SELECT p FROM Plis p WHERE p.carte4 = :carte4")
    , @NamedQuery(name = "Plis.findByNote", query = "SELECT p FROM Plis p WHERE p.note = :note")})
public class Plis implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlisPK plisPK;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_1")
    private Carte carte1;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_2")
    private Carte carte2;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_3")
    private Carte carte3;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_4")
    private Carte carte4;
    @Enumerated(EnumType.STRING)
    @Column(name = "note")
    private EvenementPlis note;
    @JoinColumns({
        @JoinColumn(name = "partie_id", referencedColumnName = "partie_id", insertable = false, updatable = false)
        , @JoinColumn(name = "manche_nb", referencedColumnName = "manche_nb", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Manche manche;
    @JoinColumn(name = "joueur_debut", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur joueurDebut;

    public Plis() {
    }

    public Plis(PlisPK plisPK) {
        this.plisPK = plisPK;
    }

    public Plis(int partieId, short mancheNb, short plisNb) {
        this.plisPK = new PlisPK(partieId, mancheNb, plisNb);
    }

    public PlisPK getPlisPK() {
        return plisPK;
    }

    public void setPlisPK(PlisPK plisPK) {
        this.plisPK = plisPK;
    }

    public Carte getCarte1() {
        return carte1;
    }

    public void setCarte1(Carte carte1) {
        this.carte1 = carte1;
    }

    public Carte getCarte2() {
        return carte2;
    }

    public void setCarte2(Carte carte2) {
        this.carte2 = carte2;
    }

    public Carte getCarte3() {
        return carte3;
    }

    public void setCarte3(Carte carte3) {
        this.carte3 = carte3;
    }

    public Carte getCarte4() {
        return carte4;
    }

    public void setCarte4(Carte carte4) {
        this.carte4 = carte4;
    }

    public EvenementPlis getNote() {
        return note;
    }

    public void setNote(EvenementPlis note) {
        this.note = note;
    }

    public Manche getManche() {
        return manche;
    }

    public void setManche(Manche manche) {
        this.manche = manche;
    }

    public Joueur getJoueurDebut() {
        return joueurDebut;
    }

    public void setJoueurDebut(Joueur joueurDebut) {
        this.joueurDebut = joueurDebut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plisPK != null ? plisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plis)) {
            return false;
        }
        Plis other = (Plis) object;
        if ((this.plisPK == null && other.plisPK != null) || (this.plisPK != null && !this.plisPK.equals(other.plisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.Plis[ plisPK=" + plisPK + " ]";
    }
    
}
