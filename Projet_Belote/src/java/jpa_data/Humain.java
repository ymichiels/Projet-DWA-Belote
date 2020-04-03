/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "humain")
@NamedQueries({
    @NamedQuery(name = "Humain.findAll", query = "SELECT h FROM Humain h"),
    @NamedQuery(name = "Humain.findByJoueurId", query = "SELECT h FROM Humain h WHERE h.joueurId = :joueurId"),
    @NamedQuery(name = "Humain.findByMotDePasse", query = "SELECT h FROM Humain h WHERE h.motDePasse = :motDePasse"),
    @NamedQuery(name = "Humain.findByAge", query = "SELECT h FROM Humain h WHERE h.age = :age"),
    @NamedQuery(name = "Humain.findByVille", query = "SELECT h FROM Humain h WHERE h.ville = :ville")})
public class Humain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "joueur_id")
    private Integer joueurId;
    @Basic(optional = false)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Column(name = "age")
    private Short age;
    @Column(name = "ville")
    private String ville;
    @JoinColumn(name = "joueur_id", referencedColumnName = "joueur_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Joueur joueur;

    public Humain() {
    }

    public Humain(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Humain(Integer joueurId, String motDePasse) {
        this.joueurId = joueurId;
        this.motDePasse = motDePasse;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        hash += (joueurId != null ? joueurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humain)) {
            return false;
        }
        Humain other = (Humain) object;
        if ((this.joueurId == null && other.joueurId != null) || (this.joueurId != null && !this.joueurId.equals(other.joueurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Humain[ joueurId=" + joueurId + " ]";
    }
    
}
