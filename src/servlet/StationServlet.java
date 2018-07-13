package servlet;

import bean.Depart;
import service.DepartService;
import service.StationService;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;


@WebServlet(name = "StationServlet",urlPatterns = {"/station/list"})
public class StationServlet extends HttpServlet {
    private StationService stationService = StationService.getStationService();
    private DepartService departService=DepartService.getDepartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(9, uri.length());
        if ("list".equals(substring)) {
            getStationList(request, response);
        }
    }

    protected void getStationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Depart> all = departService.findAll();
        request.setAttribute("departs",all);
        String depart = request.getParameter("depart");
        if(!"".equals(depart)&&depart!=null) {
            PageBean pageBean = new PageBean();
            String currentPage = request.getParameter("currentPage");
            if (currentPage != null && !currentPage.isEmpty()) {
                pageBean.setCurrentPage(Integer.parseInt(currentPage));
            }

            pageBean = stationService.listPage(pageBean);
            request.setAttribute("depart",depart);
            request.setAttribute("page", pageBean);
        }
        request.getRequestDispatcher("/station/list.jsp").forward(request,response);
    }


}
