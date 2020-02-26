package servlets;

import dao.UserHibernateDAO;
import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/list")
public class ListServlet extends HttpServlet {
    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = new ArrayList<>();
        try {
            list = userService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("users", list);
        req.getRequestDispatcher("/listOfUsers.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
