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
import java.util.logging.Logger;

/**
 * Created by  waiter on 18-7-9  下午9:48.
 *
 * @author waiter
 */
@WebServlet(name = "StaffServlet",urlPatterns = {"/staff/list","/staff/delete"})
public class StaffServlet extends HttpServlet {
    Logger logger=Logger.getLogger(this.getClass().getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(7, uri.length());
        if("list".equals(substring)){
            getStaffList(request,response);
        }else if ("delete".equals(substring)){
            dismissStaff(request,response);
        }
    }

    /**
     * 获取员工列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getStaffList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String uri = request.getRequestURI();
        StaffService staffService = StaffService.getStaffService();
        PageBean pageBean = new PageBean();
        String currentPage = request.getParameter("currentPage");
        if(currentPage!=null&&!currentPage.isEmpty()){
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");
        Staff byUserName = staffService.findByUserName(loginInfo.getUserName());
        logger.info("用户："+byUserName+"查询了员工列表");
        pageBean = staffService.findByPageAndDepartmentAndIsWork(pageBean,byUserName.getDepartment().getId(),true);

        request.setAttribute("page",pageBean);
        request.getRequestDispatcher("/staff/list.jsp").forward(request,response);
    }

    /**
     * 辞退员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void dismissStaff(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String uri = request.getRequestURI();
        StaffService staffService = StaffService.getStaffService();
        String id = request.getParameter("id");
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");

        if(id!=null){
            if (loginInfo.getId()!=Integer.parseInt(id)) {
                boolean b = staffService.dismissStaff(Integer.parseInt(id));
                if (b) {
                    request.setAttribute("msg", "成功辞退员工");

                    logger.info(loginInfo + "辞退了" + id + "员工");
                } else {
                    request.setAttribute("msg", "未知错误");
                }
            }
        }
        request.getRequestDispatcher("/staff/list").forward(request,response);
    }
}
