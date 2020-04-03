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
@Table(name = "robot")
@NamedQueries({
    @NamedQuery(name = "Robot.findAll", query = "SELECT r FROM Robot r"),
    @NamedQuery(name = "Robot.findByJoueurId", query = "SELECT r FROM Robot r WHERE r.joueurId = :joueurId"),
    @NamedQuery(name = "Robot.findByProgramme", query = "SELECT r FROM Robot r WHERE r.programme = :programme")})
public class Robot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "joueur_id")
    private Integer joueurId;
    @Basic(optional = false)
    @Column(name = "programme")
    private String programme;
    @JoinColumn(name = "joueur_id", referencedColumnName = "joueur_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Joueur joueur;

    public Robot() {
    }

    public Robot(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Robot(Integer joueurId, String programme) {
        this.joueurId = joueurId;
        this.programme = programme;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
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
        if (!(object instanceof Robot)) {
            return false;
        }
        Robot other = (Robot) object;
        if ((this.joueurId == null && other.joueurId != null) || (this.joueurId != null && !this.joueurId.equals(other.joueurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_data.Robot[ joueurId=" + joueurId + " ]";
    }
    
}
