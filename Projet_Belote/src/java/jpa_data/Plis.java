/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "plis")
@NamedQueries({
    @NamedQuery(name = "Plis.findAll", query = "SELECT p FROM Plis p"),
    @NamedQuery(name = "Plis.findByPartieId", query = "SELECT p FROM Plis p WHERE p.plisPK.partieId = :partieId"),
    @NamedQuery(name = "Plis.findByMancheNb", query = "SELECT p FROM Plis p WHERE p.plisPK.mancheNb = :mancheNb"),
    @NamedQuery(name = "Plis.findByPlisNb", query = "SELECT p FROM Plis p WHERE p.plisPK.plisNb = :plisNb"),
    @NamedQuery(name = "Plis.findByNote", query = "SELECT p FROM Plis p WHERE p.note = :note")})
public class Plis implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlisPK plisPK;
    @Column(name = "note")
    private Character note;
    @JoinColumns({
        @JoinColumn(name = "partie_id", referencedColumnName = "partie_id", insertable = false, updatable = false),
        @JoinColumn(name = "manche_nb", referencedColumnName = "manche_nb", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Manche manche;
    @JoinColumn(name = "joueur_debut", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur joueurDebut;
    @JoinColumn(name = "carte_1", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte carte1;
    @JoinColumn(name = "carte_2", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte carte2;
    @JoinColumn(name = "carte_3", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte carte3;
    @JoinColumn(name = "carte_4", referencedColumnName = "carte_id")
    @ManyToOne
    private Carte carte4;

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

    public Character getNote() {
        return note;
    }

    public void setNote(Character note) {
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
        return "jpa_data.Plis[ plisPK=" + plisPK + " ]";
    }
    
}
