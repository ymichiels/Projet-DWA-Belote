/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.pojo_JPA;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcebollado
 */
@Entity
@Table(name = "main")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Main.findAll", query = "SELECT m FROM Main m")
    , @NamedQuery(name = "Main.findByPartieId", query = "SELECT m FROM Main m WHERE m.mainPK.partieId = :partieId")
    , @NamedQuery(name = "Main.findByMancheNb", query = "SELECT m FROM Main m WHERE m.mainPK.mancheNb = :mancheNb")
    , @NamedQuery(name = "Main.findByJoueurId", query = "SELECT m FROM Main m WHERE m.mainPK.joueurId = :joueurId")
    , @NamedQuery(name = "Main.findByCarte1", query = "SELECT m FROM Main m WHERE m.carte1 = :carte1")
    , @NamedQuery(name = "Main.findByCarte2", query = "SELECT m FROM Main m WHERE m.carte2 = :carte2")
    , @NamedQuery(name = "Main.findByCarte3", query = "SELECT m FROM Main m WHERE m.carte3 = :carte3")
    , @NamedQuery(name = "Main.findByCarte4", query = "SELECT m FROM Main m WHERE m.carte4 = :carte4")
    , @NamedQuery(name = "Main.findByCarte5", query = "SELECT m FROM Main m WHERE m.carte5 = :carte5")
    , @NamedQuery(name = "Main.findByCarte6", query = "SELECT m FROM Main m WHERE m.carte6 = :carte6")
    , @NamedQuery(name = "Main.findByCarte7", query = "SELECT m FROM Main m WHERE m.carte7 = :carte7")
    , @NamedQuery(name = "Main.findByCarte8", query = "SELECT m FROM Main m WHERE m.carte8 = :carte8")})
public class Main implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MainPK mainPK;
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
    @Column(name = "carte_5")
    private Carte carte5;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_6")
    private Carte carte6;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_7")
    private Carte carte7;
    @Enumerated(EnumType.STRING)
    @Column(name = "carte_8")
    private Carte carte8;
    @JoinColumns({
        @JoinColumn(name = "partie_id", referencedColumnName = "partie_id", insertable = false, updatable = false)
        , @JoinColumn(name = "manche_nb", referencedColumnName = "manche_nb", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Manche manche;
    @JoinColumn(name = "joueur_id", referencedColumnName = "joueur_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joueur joueur;

    public Main() {
    }

    public Main(MainPK mainPK) {
        this.mainPK = mainPK;
    }

    public Main(int partieId, short mancheNb, int joueurId) {
        this.mainPK = new MainPK(partieId, mancheNb, joueurId);
    }

    public MainPK getMainPK() {
        return mainPK;
    }

    public void setMainPK(MainPK mainPK) {
        this.mainPK = mainPK;
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

    public Carte getCarte5() {
        return carte5;
    }

    public void setCarte5(Carte carte5) {
        this.carte5 = carte5;
    }

    public Carte getCarte6() {
        return carte6;
    }

    public void setCarte6(Carte carte6) {
        this.carte6 = carte6;
    }

    public Carte getCarte7() {
        return carte7;
    }

    public void setCarte7(Carte carte7) {
        this.carte7 = carte7;
    }

    public Carte getCarte8() {
        return carte8;
    }

    public void setCarte8(Carte carte8) {
        this.carte8 = carte8;
    }

    public Manche getManche() {
        return manche;
    }

    public void setManche(Manche manche) {
        this.manche = manche;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mainPK != null ? mainPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Main)) {
            return false;
        }
        Main other = (Main) object;
        if ((this.mainPK == null && other.mainPK != null) || (this.mainPK != null && !this.mainPK.equals(other.mainPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.pojo.Main[ mainPK=" + mainPK + " ]";
    }
    
}
