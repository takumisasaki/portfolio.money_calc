package controllers.moneys;

import java.io.IOException;

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
 * Servlet implementation class MoneysEditServlet
 */
@WebServlet("/moneys/edit")
public class MoneysEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneysEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    EntityManager em = DBUtil.createEntityManager();

    Money m = em.find(Money.class, Integer.parseInt(request.getParameter("id")));

    em.close();

    Person login_person = (Person)request.getSession().getAttribute("login_person");

    if(m != null && login_person.getId() == m.getPerson().getId()) {
        request.setAttribute("money", m);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("money_id", m.getId());
    }

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moneys/edit.jsp");
    rd.forward(request, response);
}
}

