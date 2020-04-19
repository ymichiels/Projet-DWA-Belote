package DAO.helper;

import DAO.pojo.*;

import javax.persistence.EntityManager;

/**
 *
 * @author jcebollado
 */
public class ManagerMain extends ManagerBase {
    public ManagerMain(EntityManager em) {
        super(em);
    }
    
    public Main create(Manche manche, Joueur joueur) {
        Main main = new Main();
        ManchePK mpk = manche.getManchePK();
        main.setMainPK(new MainPK(mpk.getPartieId(), mpk.getMancheNb(), joueur.getJoueurId()));
        
        this.getManager().persist(main);
        
        return main;
    }
    
    public void update(Main main) {
        this.getManager().merge(main);
    }
    
    public void delete(Main main) {
        this.getManager().remove(main);
    }
}
