package DAO.helper;

import DAO.pojo.Carte;
import DAO.pojo.Manche;
import DAO.pojo.ManchePK;
import DAO.pojo.Partie;

import javax.persistence.EntityManager;

/**
 *
 * @author jcebollado
 */
public class ManagerManche extends ManagerBase {
    public ManagerManche(EntityManager em) {
        super(em);
    }
    
    public Manche create(Partie partie, Carte atoutInitial) {
        Manche manche = new Manche();
        manche.setManchePK(new ManchePK(partie.getPartieId(), (short)(partie.getMancheCollection().size()+1)));
        manche.setAtoutInitial(atoutInitial);
        manche.setPointManche((short)0);
        
        this.getManager().persist(manche);
        
        return manche;
    }
    
    public void update(Manche manche) {
        this.getManager().merge(manche);
    }
    
    public void delete(Manche manche) {
        this.getManager().remove(manche);
    }
}
