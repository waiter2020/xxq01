package servlet;

import service.StationService;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StationServlet",urlPatterns = {"/station/list"})
public class StationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationService stationService = StationService.getStationService();
        PageBean pageBean = new PageBean();
        String currentPage = request.getParameter("currentPage");
        if(currentPage!=null&&!currentPage.isEmpty()){
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }

        pageBean = stationService.listPage(pageBean);

        request.setAttribute("page",pageBean);
        request.getRequestDispatcher("/station/list.jsp").forward(request,response);
    }
}
