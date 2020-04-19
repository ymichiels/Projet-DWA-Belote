/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.helper;

import javax.persistence.EntityManager;

/**
 *
 * @author jcebollado
 */
public class ManagerBase {
    private EntityManager em;
    
    public ManagerBase(EntityManager em) {
        this.em = em;
    }
    
    protected EntityManager getManager() {
        return this.em;
    }
}
