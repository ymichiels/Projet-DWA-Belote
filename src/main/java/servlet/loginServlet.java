package servlet;

import dao.helper.ManagerHumain;
import dao.pojo.Humain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class loginServlet extends HttpServlet {

    //Modifie les informations pour l'affichage de notre site
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    //Récupère informations passées dans un formulaire
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pseudo = req.getParameter("pseudo");
        String password = req.getParameter("password");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        ManagerHumain mh = new ManagerHumain(em);
        List<Humain> match = mh.findByPseudo(pseudo);


        if (pseudo.equals(match.get(0).getPseudo()) && password.equals(match.get(0).getMotDePasse())) {
            req.getSession().setAttribute("user", new Humain(pseudo, password));
            resp.sendRedirect("index");

        }
        else {
            resp.sendRedirect("login");
        }
    }
}
