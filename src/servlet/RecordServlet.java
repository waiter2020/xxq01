package servlet;

import bean.Depart;
import bean.Station;
import service.DepartService;
import service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by  waiter on 18-7-14  下午5:00.
 *
 * @author waiter
 */
@WebServlet(name = "RecordServlet",urlPatterns = {"/record/to_form"})
public class RecordServlet extends HttpServlet {
    private DepartService departService = DepartService.getDepartService();

    private StationService stationService = StationService.getStationService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());
        if("to_form".equals(substring)){
            toForm(request,response);
        }
    }

    protected void toForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Depart> all = departService.findAll();
        LinkedList<Station> all1 = stationService.findAll();
        request.setAttribute("departs",all);
        request.setAttribute("station",all1);
        request.getRequestDispatcher("/record/form.jsp").forward(request,response);
    }
}
