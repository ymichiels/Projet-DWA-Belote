package DAO.helper;

import DAO.pojo.Humain;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author jcebollado
 */
public class ManagerHumain extends ManagerBase {
    public ManagerHumain(EntityManager em){
        super(em);
    }
    
    public Humain create(String pseudo, String motDePasse, short age, char sexe, String ville) {
        Humain humain = new Humain();
        humain.setPseudo(pseudo);
        humain.setMotDePasse(motDePasse);
        humain.setAge(age);
        humain.setSexe(sexe);
        humain.setVille(ville);
        humain.setNbPartie(0);
        humain.setNbVictoire(0);
        humain.setScoreMoyen(0f);
        
        this.getManager().persist(humain);
        
        return humain;
    }
    
    public void update(Humain humain) {
        this.getManager().merge(humain);
    }
    
    public void delete(Humain humain) {
        this.getManager().remove(humain);
    }
    
    public Humain find(Integer joueurId) {
        Query query = this.getManager().createQuery("select h from Humain h where h.joueurId=:id");
        query.setParameter("id", joueurId);
        
        return (Humain)query.getSingleResult();
    }
    
    public List<Humain> findByPseudo(String pseudo) {
        Query query = this.getManager().createQuery("select h from Humain h where h.pseudo=:pseudo");
        query.setParameter("pseudo", pseudo);
        
        return query.getResultList();
    }
    
    public List<Humain> findByClassment(int nb) {
        Query query = this.getManager().createQuery("select h from Humain h order by h.nbVictoire / h.nbPartie limit :top");
        query.setParameter("top", nb);
        
        return query.getResultList();
    }
}
