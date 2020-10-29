package controllers.persons;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utils.DBUtil;

/**
 * Servlet implementation class PersonsEditServlet
 */
@WebServlet("/persons/edit")
public class PersonsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Person p = em.find(Person.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("person", p);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("person_id", p.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/persons/edit.jsp");
        rd.forward(request, response);
    }

}
