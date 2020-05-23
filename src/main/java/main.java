import com.fasterxml.jackson.databind.ObjectMapper;
import dao.pojo.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws Exception {
        /*EntityTransaction trans = null;

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
        }*/

        Temp temp = new Temp();
        temp.carte = Carte.CARREAU_10;

        ObjectMapper om = new ObjectMapper();
        String data = om.writerWithDefaultPrettyPrinter().writeValueAsString(temp);

        System.out.println(data);

        Temp other = om.readValue(data, Temp.class);
        System.out.println(other.carte);

        other = om.readValue("{\"carte\": null}", Temp.class);
        System.out.println(other.carte);

        Lel lel = new Lel();
        lel.values = new ArrayList<Integer>();
        lel.values.add(1);
        lel.values.add(2);
        lel.values.add(3);
        data = om.writerWithDefaultPrettyPrinter().writeValueAsString(lel);
        System.out.println(data);
        Lel lel2 = om.readValue(data, Lel.class);
        System.out.println(lel2.values);
        // TODO code application logic here
    }
    static class Temp {
        Carte carte;

        public Carte getCarte() {
            return carte;
        }
        public void setCarte(Carte carte) {
            this.carte = carte;
        }
    }

    static class Lel {
        List<Integer> values;

        public List<Integer> getValues() {
            return values;
        }

        public void setValues(List<Integer> values) {
            this.values = values;
        }
    }
}
