package servlet;

import dao.helper.ManagerHumain;
import dao.pojo.Humain;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    //Modifie les informations pour l'affichage de notre site
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);

        String city = req.getParameter("city");
        //String sexe = req.getParameter("sexe");
        String age = req.getParameter("age");
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");

        EntityTransaction trans = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
            EntityManager em = emf.createEntityManager();
            trans = em.getTransaction();

            trans.begin();
//            ManagerHumain mh = new ManagerHumain(em);
//            Humain humain = mh.create(pseudo, password);
//            em.merge(humain);
            Humain humain = new Humain();
            humain.setPseudo(pseudo);
            humain.setMotDePasse(password);

            trans.commit();
            //registration success
            resp.sendRedirect("/index");

        } catch (PersistenceException err) {
            try {
                if (trans != null) {
                    trans.rollback();
                    //Registration failed
                    resp.sendRedirect("/register");
                }
            } catch (Exception rollErr) {
                System.err.println(rollErr);
            }
            throw (err);
        }
    }
}