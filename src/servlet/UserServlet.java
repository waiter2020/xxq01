package servlet;

import bean.Staff;
import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by  waiter on 18-7-12  下午9:48.
 *
 * @author waiter
 */
@WebServlet(name = "UserServlet",urlPatterns = {"/user/change"})
public class UserServlet extends HttpServlet {
    UserService userService = UserService.getUserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(6, uri.length());
        if ("change".equals(substring)) {
            changeUser(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void changeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNum = request.getParameter("phoneNum");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");
        Staff staff = loginInfo.getStaff();
        staff.setPhoneNum(phoneNum);
        staff.setAddress(address);
        staff.setEmail(email);
        loginInfo.setStaff(staff);
        boolean save = userService.save(loginInfo);
        if(save){
            request.setAttribute("msg","保存成功");
            request.getSession().setAttribute("loginInfo",loginInfo);
        }else {
            request.setAttribute("msg","保存失败，请检查输入信息");
        }
        request.getRequestDispatcher("/user/change").forward(request,response);
    }

}
