package servlet;

import bean.Staff;
import bean.User;
import service.UserService;
import utils.BCrypt;

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
@WebServlet(name = "UserServlet",urlPatterns = {"/user/change","/user/change_pwd"})
public class UserServlet extends HttpServlet {
    private UserService userService = UserService.getUserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(6, uri.length());
        if ("change".equals(substring)) {
            changeUser(request, response);
        }if("change_pwd".equals(substring)){
            changePwd(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     *修改用户信息，post方法
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
        request.getRequestDispatcher("/user/change.jsp").forward(request,response);
    }

    /**
     * 修改用户密码，post
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void changePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pwd = request.getParameter("pwd");
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");
        if ("".equals(pwd)||pwd==null){
            request.setAttribute("msg","修改失败,新密码不能为空");
        }else {
            loginInfo.setPassWd(BCrypt.hashpw(pwd,BCrypt.gensalt(10)));
            boolean save = userService.save(loginInfo);
            if(save){
                request.setAttribute("msg","修改成功");
            }else {
                request.setAttribute("msg","修改失败，请检查输入");
            }
        }
        request.getRequestDispatcher("/user/change_pwd.jsp").forward(request,response);

    }


}
