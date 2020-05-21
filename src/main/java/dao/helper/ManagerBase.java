package dao.helper;

import javax.persistence.EntityManager;

/**
 * @author jcebollado
 */
public abstract class ManagerBase<D> {
    private EntityManager em;

    public ManagerBase(EntityManager em) {
        this.em = em;
    }

    protected EntityManager getManager() {
        return this.em;
    }

    /**
     * Retourne à partir du support de persistance un objet en fonction de son identifiant
     *
     * @param id identifiant de l'objet
     * @return l'instance de l'objet
     * @throws ManagerBaseExeption en cas de problème
     */
    public abstract D find(int id) throws ManagerBaseExeption;

    /**
     * Rend persistant un objet qui n'avait pas encore de réprésentation sur le support de persistance
     *
     * @param data l'objet à rendre persistant
     * @throws ManagerBaseExeption en cas de problème
     */
    public abstract void create(D data) throws ManagerBaseExeption;

    /**
     * Met à jour le contenu correspondant à l'objet sur le support persistant (l'objet
     * avait déjà une représentation sur le support persistant)
     *
     * @param data l'objet modifié dont le contenu est à mettre à jour
     * @throws ManagerBaseExeption en cas de problème
     */
    public abstract void update(D data) throws ManagerBaseExeption;

    /**
     * Efface du support persistant le contenu équivalent à l'objet
     *
     * @param data l'objet à supprimer
     * @throws ManagerBaseExeption en cas de problème
     */
    public abstract void delete(D data) throws ManagerBaseExeption;

    public void DAO() throws ManagerBaseExeption {
    }
}
