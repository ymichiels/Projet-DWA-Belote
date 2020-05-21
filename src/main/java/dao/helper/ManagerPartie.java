package dao.helper;

import dao.pojo.Joueur;
import dao.pojo.Partie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author jcebollado
 */
public class ManagerPartie extends ManagerBase {
    public ManagerPartie(EntityManager em) {
        super(em);
    }
    
    public Partie create(Joueur eq1JoueurA, Joueur eq1JoueurB, Joueur eq2JoueurA, Joueur eq2JoueurB) {
        Partie partie = new Partie();
        partie.setEq1a(eq1JoueurA);
        partie.setEq1b(eq1JoueurB);
        partie.setEq2a(eq2JoueurA);
        partie.setEq2b(eq2JoueurB);
        partie.setScoreEq1((short)0);
        partie.setScoreEq2((short)0);
        partie.setDuree(null);
        
        this.getManager().persist(partie);
        
        return partie;
    }
    
    public void update(Partie partie) {
        this.getManager().merge(partie);
    }
    
    public void delete(Partie partie) {
        this.getManager().remove(partie);
    }
    
    public Partie find(Integer partieId) {
        Query query = this.getManager().createQuery("select p from Partie p where p.partieId=:id");
        query.setParameter("id", partieId);
        
        return (Partie)query.getSingleResult();
    }
    
    public List<Partie> findPartieAvecJoueur(Joueur j) {
        Query query = this.getManager().createQuery("select p from Partie p where p.eq1a=:joueur or p.eq1b=:joueur or p.eq2a=:joueur or p.eq2a=:joueur or p.eq2b=:joueur");
        query.setParameter("joueur", j);
        
        return query.getResultList();
    }
}
