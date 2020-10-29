package controllers.moneys;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Money;
import models.Person;
import utils.DBUtil;

/**
 * Servlet implementation class MoneysIndexServlet
 */
@WebServlet("/moneys/index")
public class MoneysIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneysIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        Person login_person =(Person) request.getSession().getAttribute("login_person");
        String year = request.getParameter("year");

        List<Money> m = em.createNamedQuery("getMyAllMoneys", Money.class)
                           .setParameter("person", login_person)
                           .setParameter("year", year)
                           .getResultList();

        long m1 = (long)em.createNamedQuery("getMoneysMonth1", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m2 = (long)em.createNamedQuery("getMoneysMonth2", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m3 = (long)em.createNamedQuery("getMoneysMonth3", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m4 = (long)em.createNamedQuery("getMoneysMonth4", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m5 = (long)em.createNamedQuery("getMoneysMonth5", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m6 = (long)em.createNamedQuery("getMoneysMonth6", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m7 = (long)em.createNamedQuery("getMoneysMonth7", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m8 = (long)em.createNamedQuery("getMoneysMonth8", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m9 = (long)em.createNamedQuery("getMoneysMonth9", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m10 = (long)em.createNamedQuery("getMoneysMonth10", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m11 = (long)em.createNamedQuery("getMoneysMonth11", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();
        long m12 = (long)em.createNamedQuery("getMoneysMonth12", Long.class)
                .setParameter("person", login_person)
                .setParameter("year", year)
                .getSingleResult();



        request.getSession().setAttribute("m", m);
        request.setAttribute("year", year);
        request.setAttribute("m1", m1);
        request.setAttribute("m2", m2);
        request.setAttribute("m3", m3);
        request.setAttribute("m4", m4);
        request.setAttribute("m5", m5);
        request.setAttribute("m6", m6);
        request.setAttribute("m7", m7);
        request.setAttribute("m8", m8);
        request.setAttribute("m9", m9);
        request.setAttribute("m10", m10);
        request.setAttribute("m11", m11);
        request.setAttribute("m12", m12);
        em.close();


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moneys/index.jsp");
        rd.forward(request, response);
    }

}
