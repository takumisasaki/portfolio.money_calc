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
import models.validators.MoneyValidator;
import utils.DBUtil;

/**
 * Servlet implementation class MoneysUpdateServlet
 */
@WebServlet("/moneys/update")
public class MoneysUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneysUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())){
            EntityManager em = DBUtil.createEntityManager();

            Money m = em.find(Money.class, (Integer)(request.getSession().getAttribute("money_id")));

            m.setCompany_name(request.getParameter("company_name"));
            m.setYear(request.getParameter("year"));

            String january = request.getParameter("january");
            if(january == null || january.equals("")) {
                m.setJanuary(0);
            } else{
                m.setJanuary(Integer.parseInt(request.getParameter("january")));
            }
            String february = request.getParameter("february");
            if(february == null || february.equals("")) {
                m.setFebruary(0);
            } else{
                m.setFebruary(Integer.parseInt(request.getParameter("february")));
            }
            String march = request.getParameter("march");
            if(march == null || march.equals("")) {
                m.setMarch(0);
            } else{
                m.setMarch(Integer.parseInt(request.getParameter("march")));
            }
            String april = request.getParameter("april");
            if(april == null || april.equals("")) {
                m.setApril(0);
            } else{
                m.setApril(Integer.parseInt(request.getParameter("april")));
            }
            String may = request.getParameter("may");
            if(may == null || may.equals("")) {
                m.setMay(0);
            } else{
                m.setMay(Integer.parseInt(request.getParameter("may")));
            }
            String june = request.getParameter("june");
            if(june == null || june.equals("")) {
                m.setJune(0);
            } else{
                m.setJune(Integer.parseInt(request.getParameter("june")));
            }
            String july = request.getParameter("july");
            if(july == null || july.equals("")) {
                m.setJuly(0);
            } else{
                m.setJuly(Integer.parseInt(request.getParameter("july")));
            }
            String august = request.getParameter("august");
            if(august == null || august.equals("")) {
                m.setAugust(0);
            } else{
                m.setAugust(Integer.parseInt(request.getParameter("august")));
            }
            String september = request.getParameter("september");
            if(september == null || september.equals("")) {
                m.setSeptember(0);
            } else{
                m.setSeptember(Integer.parseInt(request.getParameter("september")));
            }
            String october = request.getParameter("october");
            if(october == null || october.equals("")) {
                m.setOctober(0);
            } else{
                m.setOctober(Integer.parseInt(request.getParameter("october")));
            }
            String november = request.getParameter("november");
            if(november == null || november.equals("")) {
                m.setNovember(0);
            } else{
                m.setNovember(Integer.parseInt(request.getParameter("november")));
            }
            String december = request.getParameter("december");
            if(december == null || december.equals("")) {
                m.setDecember(0);
            } else{
                m.setDecember(Integer.parseInt(request.getParameter("december")));
            }

            List<String> errors = MoneyValidator.validate(m);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("money", m);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/moneys/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", m.getCompany_name() + "の情報を更新しました。");
                request.getSession().setAttribute("year", m.getYear());

                request.getSession().removeAttribute("money_id");

                response.sendRedirect(request.getContextPath() + "/index.html");
            }

      }
   }

}



