package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/admin/*")
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            User user = (User) req.getSession().getAttribute("user");
            String role = req.getSession().getAttribute("adminSession").toString();
            if (user == null) {
                req.getRequestDispatcher("/auth").forward(req, res);
            } else if (role.equals(req.getSession().getId())) {
                filterChain.doFilter(req, res);
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/user");
                dispatcher.forward(req, res);
            }
        } catch (NullPointerException e) {
            res.sendRedirect("/auth");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
