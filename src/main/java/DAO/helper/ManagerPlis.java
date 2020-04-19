/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.helper;

import dao.pojo.Joueur;
import dao.pojo.Manche;
import dao.pojo.ManchePK;
import dao.pojo.Plis;
import dao.pojo.PlisPK;
import javax.persistence.EntityManager;

/**
 *
 * @author jcebollado
 */
public class ManagerPlis extends ManagerBase {
    public ManagerPlis(EntityManager em) {
        super(em);
    }
    
    public Plis create(Manche manche, Joueur premier) {
        Plis plis = new Plis();
        ManchePK mpk = manche.getManchePK();
        plis.setPlisPK(new PlisPK(mpk.getPartieId(), mpk.getMancheNb(), (byte)(manche.getPlisCollection().size()+1)));
        // possible change; verifier que premier fait bien partie de la partie
        plis.setJoueurDebut(premier);
        
        this.getManager().persist(plis);
        
        return plis;
    }
    
     public void update(Plis plis) {
        this.getManager().merge(plis);
    }
    
    public void delete(Plis plis) {
        this.getManager().remove(plis);
    }
}
