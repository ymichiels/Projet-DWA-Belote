/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "partie")
@NamedQueries({
    @NamedQuery(name = "Partie.findAll", query = "SELECT p FROM Partie p"),
    @NamedQuery(name = "Partie.findByPartieId", query = "SELECT p FROM Partie p WHERE p.partieId = :partieId"),
    @NamedQuery(name = "Partie.findByScoreEq1", query = "SELECT p FROM Partie p WHERE p.scoreEq1 = :scoreEq1"),
    @NamedQuery(name = "Partie.findByScoreEq2", query = "SELECT p FROM Partie p WHERE p.scoreEq2 = :scoreEq2"),
    @NamedQuery(name = "Partie.findByDuree", query = "SELECT p FROM Partie p WHERE p.duree = :duree")})
public class Partie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "partie_id")
    private Integer partieId;
    @Column(name = "score_eq1")
    private Short scoreEq1;
    @Column(name = "score_eq2")
    private Short scoreEq2;
    @Column(name = "duree")
    @Temporal(TemporalType.TIME)
    private Date duree;
    @JoinColumn(name = "eq_1a", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur eq1a;
    @JoinColumn(name = "eq_1b", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur eq1b;
    @JoinColumn(name = "eq_2a", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur eq2a;
    @JoinColumn(name = "eq_2b", referencedColumnName = "joueur_id")
    @ManyToOne
    private Joueur eq2b;
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

    public Short getScoreEq1() {
        return scoreEq1;
    }

    public void setScoreEq1(Short scoreEq1) {
        this.scoreEq1 = scoreEq1;
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
        return "jpa_data.Partie[ partieId=" + partieId + " ]";
    }
    
}
