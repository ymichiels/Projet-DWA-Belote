import dao.pojo.*;
import javax.persistence.*;

public class main {

    public static void main(String[] args) {
        EntityTransaction trans = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
        EntityManager em = emf.createEntityManager();

        try {
            trans = em.getTransaction();
            trans.begin();

            int partieId = 1;
            byte mancheId = 1;

            Humain hum = new Humain();
            hum.setPseudo("dummy");

            //Partie partie = em.find(Partie.class, partieId);
            //Partie partie = new Partie();
            //partie.setPartieId(partieId);

            //Manche manche = em.find(Manche.class, new ManchePK(partieId, mancheId));
            //Manche manche = new Manche();
            //manche.setManchePK(new ManchePK(partieId, mancheId));
            //manche.setAtoutInitial(Carte.PIQUE_7);
            //manche.setAtoutFinal(Carte.PIQUE_8);

            //partie.getMancheCollection().add(manche);

            //em.merge(partie);
            //System.out.println(manche.getAtoutFinal() + " - " + manche.getAtoutInitial());
            em.merge(hum);

            trans.commit();
        } catch(PersistenceException err) {
            try {
                if(trans != null) {
                    trans.rollback();
                }
            } catch(Exception rollErr) {
                System.err.println(rollErr);
            }
            throw(err);
        }
        // TODO code application logic here
    }
}
