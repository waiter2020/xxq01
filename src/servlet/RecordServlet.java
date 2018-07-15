package servlet;

import bean.Depart;
import bean.Station;
import service.DepartService;
import service.OfficeService;
import service.RecordService;
import service.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by  waiter on 18-7-14  下午5:00.
 *
 * @author waiter
 */
@WebServlet(name = "RecordServlet",urlPatterns = {"/record/r_form","/record/l_form","/record/b_form","/record/g_form"})
public class RecordServlet extends HttpServlet {
    private DepartService departService = DepartService.getDepartService();
    private OfficeService officeService = OfficeService.getOfficeService();
    private RecordService recordService = RecordService.getRecordService();
    private StationService stationService = StationService.getStationService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());
        if ("r_form".equals(substring)) {
            rForm(request, response);
        }else if ("l_form".equals(substring)) {
            lForm(request, response);
        }else if ("r_form".equals(substring)) {
            bForm(request, response);
        }else if ("l_form".equals(substring)) {
            gForm(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());

    }

    private void lForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        Date parse1=null;
        try {
            parse = sDateFormat.parse(start);
            parse1 = sDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LinkedList listByEndDateBeforAndStartAfterAndState = officeService.findListByEndDateBeforAndStartAfterAndState(parse1, parse, 2);
        request.setAttribute("list",listByEndDateBeforAndStartAfterAndState);
        request.getRequestDispatcher("/record/l_form.jsp").forward(request,response);

    }

    private void rForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        Date parse1=null;
        try {
            parse = sDateFormat.parse(start);
            parse1 = sDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LinkedList listByEndDateBeforAndStartAfterAndState = officeService.findListByEndDateBeforAndStartAfterAndState(parse1, parse, 0);
        request.setAttribute("list",listByEndDateBeforAndStartAfterAndState);
        request.getRequestDispatcher("/record/r_form.jsp").forward(request,response);
    }

    private void bForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        Date parse1=null;
        try {
            parse = sDateFormat.parse(start);
            parse1 = sDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LinkedList listByEndDateBeforAndStartAfterAndState = recordService.findListByEndDateBeforAndStartAfterAndMark(parse1, parse, 1);
        LinkedList listByEndDateBeforAndStartAfterAndMark = recordService.findListByEndDateBeforAndStartAfterAndMark(parse1, parse, 3);
        listByEndDateBeforAndStartAfterAndState.addAll(listByEndDateBeforAndStartAfterAndMark);
        request.setAttribute("list",listByEndDateBeforAndStartAfterAndState);
        request.getRequestDispatcher("/record/b_form.jsp").forward(request,response);
    }

    private void gForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        Date parse1=null;
        try {
            parse = sDateFormat.parse(start);
            parse1 = sDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LinkedList listByEndDateBeforAndStartAfterAndState = recordService.findListByEndDateBeforAndStartAfterAndMark(parse1, parse, 2);
        LinkedList listByEndDateBeforAndStartAfterAndMark = recordService.findListByEndDateBeforAndStartAfterAndMark(parse1, parse, 3);
        listByEndDateBeforAndStartAfterAndState.addAll(listByEndDateBeforAndStartAfterAndMark);
        request.setAttribute("list",listByEndDateBeforAndStartAfterAndState);
        request.getRequestDispatcher("/record/g_form.jsp").forward(request,response);
    }
}