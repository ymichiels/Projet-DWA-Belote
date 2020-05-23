package dao.helper;

import javax.persistence.EntityManager;

/**
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
