/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.pojo_JPA;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 *
 * @author jcebollado
 */
@Embeddable
public class Equipe {
    @JoinColumn(name = "joueurA")
    private Joueur joueurA;
    @JoinColumn(name = "joueurB")
    private Joueur joueurB;
    @Column(name = "score")
    private Short score;

    public Joueur getJoueurA() {
        return joueurA;
    }

    public void setJoueurA(Joueur joueurA) {
        this.joueurA = joueurA;
    }

    public Joueur getJoueurB() {
        return joueurB;
    }

    public void setJoueurB(Joueur joueurB) {
        this.joueurB = joueurB;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
    
}
