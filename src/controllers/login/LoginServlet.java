package controllers.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("hasError", false);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 認証結果を格納する変数
        Boolean check_result = false;


        String number = request.getParameter("number");
        String plain_pass = request.getParameter("password");

        Person p = null;

        if(number != null && !number.equals("") && plain_pass != null && !plain_pass.equals("")) {
            EntityManager em = DBUtil.createEntityManager();

            String password = EncryptUtil.getPasswordEncrypt(
                    plain_pass,
                    (String)this.getServletContext().getAttribute("pepper")
                    );

            // 社員番号とパスワードが正しいかチェックする
            try {
                p = em.createNamedQuery("checkLoginNumberAndPassword", Person.class)
                        .setParameter("number", number)
                        .setParameter("pass", password)
                        .getSingleResult();
            } catch(NoResultException ex) {}
                em.close();

                if(p != null && p.getDelete_flag() == 0){
                    check_result = true;


                }
            }

            if(!check_result) {
                // 認証できなかったらログイン画面に戻る
                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("hasError", true);
                request.setAttribute("number", number);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
                rd.forward(request, response);
            } else {


                request.getSession().setAttribute("login_person", p);
                request.getSession().setAttribute("flush", "ログインしました。");

                // 認証できて初回ログインの場合はMoney新規作成画面へリダイレクト
                if(p.getLogin_count() == 0) {
                    request.getSession().setAttribute("person_id", p.getId());
                    response.sendRedirect(request.getContextPath() + "/persons/logincount");
                } else {
                // 認証できたらログイン状態にしてトップページへリダイレクト
                    response.sendRedirect(request.getContextPath() + "/index.html");
                }
            }
        }
    }


