package dao.helper;

import dao.pojo.Carte;
import dao.pojo.Manche;
import dao.pojo.ManchePK;
import dao.pojo.Partie;

import javax.persistence.EntityManager;

/**
 * @author jcebollado
 */
public class ManagerManche extends ManagerBase {
    public ManagerManche(EntityManager em) {
        super(em);
    }

    public Object find(int id) throws ManagerBaseExeption {
        return null;
    }

    public void create(Object data) throws ManagerBaseExeption {

    }

    public void update(Object data) throws ManagerBaseExeption {

    }

    public void delete(Object data) throws ManagerBaseExeption {

    }

    public Manche create(Partie partie, Carte atoutInitial) {
        Manche manche = new Manche();
        manche.setManchePK(new ManchePK(partie.getPartieId(), (short) (partie.getMancheCollection().size() + 1)));
        manche.setAtoutInitial(atoutInitial);
        manche.setPointManche((short) 0);

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
