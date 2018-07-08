package servlet;

import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/do_login")
public class LoginServlet extends HttpServlet {
    UserService userService=UserService.getUserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User byUserName = userService.findByUserName(username);
        request.getSession().setAttribute("loginInfo",byUserName);
        response.sendRedirect("/index.jsp");
        //request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login").forward(request,response);
    }
}
