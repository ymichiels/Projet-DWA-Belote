package dao.helper;


import dao.pojo.Robot;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author jcebollado
 */
public class ManagerRobot extends ManagerBase {

    public ManagerRobot(EntityManager em) {
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

    public Robot create(String pseudo, String programme) {
        Robot robot = new Robot();
        robot.setPseudo(pseudo);
        robot.setProgramme(programme);
        robot.setNbPartie(0);
        robot.setNbVictoire(0);
        robot.setScoreMoyen(0f);

        this.getManager().persist(robot);

        return robot;
    }

    public void update(Robot robot) {
        this.getManager().merge(robot);
    }

    public void delete(Robot robot) {
        this.getManager().remove(robot);
    }

    public Robot find(Integer joueurId) {
        Query query = this.getManager().createQuery("select r from Robot r where r.joueurId=:'" + joueurId + "'");
        query.setParameter("id", joueurId);

        return (Robot) query.getSingleResult();
    }

    public List<Robot> findByPseudo(String pseudo) {
        Query query = this.getManager().createQuery("select r from Robot r where r.pseudo=:'" + pseudo + "'");
        query.setParameter("pseudo", pseudo);

        return query.getResultList();
    }
    
    /*public List<Robot> findByClassment(int nb) {
        Query query = this.getManager().createQuery("select r from Robot r order by r.nbVictoire / r.nbPartie limit :top");
        query.setParameter("top", nb);
        
        return query.getResultList();
    }*/
}
