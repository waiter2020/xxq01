package servlet;


import bean.Depart;
import service.DepartService;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DepartServlet",urlPatterns = {"/depart/list","/depart/add"})
public class DepartServlet extends HttpServlet {
    private DepartService departService = DepartService.getDepartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());
        if ("add".equals(substring)) {
            addDepart(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());
        if ("list".equals(substring)) {
            getDpartPage(request, response);
        }
    }

    /**
     * 获取部门列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getDpartPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        String currentPage = request.getParameter("currentPage");
        if(currentPage!=null&&!currentPage.isEmpty()){
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }

        pageBean = departService.listPage(pageBean);

        request.setAttribute("page",pageBean);
        request.getRequestDispatcher("/depart/list.jsp").forward(request,response);
    }

    /**
     * 添加岗位
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addDepart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departName = request.getParameter("departName");
        String describe = request.getParameter("describe");
        boolean b = departService.addDepart(new Depart(departName, describe));
        if(b){
            request.setAttribute("msg","添加成功");
        }else {
            request.setAttribute("msg","添加失败，请检查输入信息");
        }
        getDpartPage(request,response);
    }


}
