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
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login/check")
public class ValidLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityTransaction trans = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BelotePU");
        EntityManager em = emf.createEntityManager();

        ManagerHumain mh = new ManagerHumain(em);

        trans = em.getTransaction();
        trans.begin();
        List<Humain> listUser = mh.findByPseudo(req.getParameter("pseudo"));
        boolean success = false;
        if(listUser.isEmpty()) {
            // pas d'utilisateur avec ce nom

        } else {
            // un utilisateur avec ce nom
            Humain user = listUser.get(0);
            if(user.getMotDePasse().equals(req.getParameter("password"))) {
                // bon mot de passe
                req.getSession().setAttribute("humain", user);
                success = true;
            }
        }
        trans.commit();
        if(success) {
            resp.sendRedirect("../index.html");
        } else {
            resp.sendRedirect("../login"); // go back to login
        }
    }
}
