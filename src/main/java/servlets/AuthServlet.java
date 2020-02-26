package servlets;

import dao.UserHibernateDAO;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if ((boolean) req.getSession(false).getAttribute("logined") &&
                    req.getSession(false).getAttribute("adminSession")
                            .equals(req.getSession(false).getId())) {
                resp.sendRedirect("/admin/list");
            } else if ((boolean) req.getSession(false).getAttribute("logined") &&
                    req.getSession(false).getAttribute("userSession")
                            .equals(req.getSession(false).getId())) {
                resp.sendRedirect("/user");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/auth.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (NullPointerException e) {
            resp.sendRedirect("/auth.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = null;
        try {
            user = UserService.getInstance().getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            resp.sendRedirect("/index.jsp");
            } else if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            boolean logined = true;
            req.getSession().setAttribute("logined", logined);
            if (user.getRole().equals("admin")) {
                String adminSession = req.getSession().getId();
                req.getSession().setAttribute("adminSession", adminSession);
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/admin/list");
            } else {
                String userSession = req.getSession().getId();
                req.getSession().setAttribute("userSession", userSession);
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/user");
            }
        } else {
            resp.sendRedirect("/index.jsp");
        }
    }
}