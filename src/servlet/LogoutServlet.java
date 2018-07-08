package servlet;

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
@WebServlet(name = "LogoutServlet",urlPatterns = "do_logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loginInfo",null);
        request.setAttribute("msg","退出成功");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
