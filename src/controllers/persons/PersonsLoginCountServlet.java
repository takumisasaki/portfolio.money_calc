package controllers.persons;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utils.DBUtil;

/**
 * Servlet implementation class PersonsLoginCountServlet
 */
@WebServlet("/persons/logincount")
public class PersonsLoginCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsLoginCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();



        Person p = em.find(Person.class, (Integer)(request.getSession().getAttribute("person_id")));



          p.setLogin_count(1);


          em.getTransaction().begin();
          em.getTransaction().commit();
          em.close();
          request.getSession().setAttribute("flush", "登録完了");

          response.sendRedirect(request.getContextPath() + "/moneys/new");

    }

}
