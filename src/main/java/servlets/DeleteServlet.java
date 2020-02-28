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
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert user != null;
        String name = user.getName();
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deleteUser.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.deleteUser(userService.getUserById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/admin/list");
    }
}
