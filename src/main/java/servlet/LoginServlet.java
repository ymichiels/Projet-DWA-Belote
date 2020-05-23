package servlet;

import dao.helper.ManagerHumain;
import dao.pojo.Humain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login/")
public class LoginServlet extends HttpServlet {

    //Modifie les informations pour l'affichage de notre site
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    //Récupère informations passées dans un formulaire
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //HttpSession session = req.getSession();
            String pseudo = req.getParameter("pseudo");
            String password = req.getParameter("password");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
            EntityManager em = emf.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            ManagerHumain mh = new ManagerHumain(em);
            List<Humain> match = mh.findByPseudo(pseudo);


            if (match.isEmpty()) {
                // pas de joueur correspondant

            } else {
                Humain hum = match.get(0);
                String formPasswordName = "password";
                if (pseudo.equals(match.get(0).getPseudo()) && password.equals(match.get(0).getMotDePasse())) {
                    req.getSession().setAttribute("user", match.get(0).getPseudo());
                    resp.sendRedirect("/index");
                } else {
                    // mauvais mot de passe
                    resp.sendRedirect("/error");
                }
            }
            trans.commit();

        }catch (Exception ex) {
            // System.err.println("Initial SessionFactory creation failed.");
            ex.printStackTrace();
            System.exit(0);
        }
    }
}

