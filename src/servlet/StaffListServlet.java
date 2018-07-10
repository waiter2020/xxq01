package servlet;

import bean.Staff;
import bean.User;
import service.StaffService;
import service.UserService;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by  waiter on 18-7-9  下午9:48.
 *
 * @author waiter
 */
@WebServlet(name = "StaffListServlet",urlPatterns = {"/staff/list"})
public class StaffListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StaffService staffService = StaffService.getStaffService();
        PageBean pageBean=null;
        String currentPage = request.getParameter("currentPage");
        if(currentPage!=null&&!currentPage.isEmpty()){
            pageBean= (PageBean) request.getAttribute("page");
        }
        if (pageBean==null) {
            pageBean=new PageBean();
            User loginInfo = (User) request.getSession().getAttribute("loginInfo");
            Staff byUserName = staffService.findByUserName(loginInfo.getUserName());
            pageBean = staffService.findByPageAndDepartment(pageBean, byUserName.getDepartment());
        }else {
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
            pageBean = staffService.findByPageAndDepartment(pageBean,((Staff)pageBean.getPageData().getFirst()).getDepartment());
        }
        request.setAttribute("page",pageBean);
        request.getRequestDispatcher("/staff/list.jsp").forward(request,response);
    }
}
