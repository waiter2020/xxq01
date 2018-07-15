package servlet;

import bean.Depart;
import bean.Performance;
import dao.impl.ReportDaoImpl;
import service.DepartService;
import service.OfficeService;
import service.PerformanceService;
import service.StaffService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "PerformanceServlet",urlPatterns = {"/record/report","/record/staff_report"})
public class PerformanceServlet extends HttpServlet {
    private PerformanceService performanceService = PerformanceService.getPerformanceService();
    private OfficeService officeService = OfficeService.getOfficeService();
    private StaffService staffService = StaffService.getStaffService();
    private DepartService departService = DepartService.getDepartService();
    private ReportDaoImpl reportDao = ReportDaoImpl.getReportDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(8, uri.length());
        if ("report".equals(substring)) {
            getReport(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void getReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("date");
        request.setAttribute("date",start);
        Date parse = new Date();
        Date parse1 = null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        int year = calendar.get(Calendar.YEAR);
        if(Integer.parseInt(start) - 2<0){
            calendar.set(year-1, Integer.parseInt(start) - 2+12, 28);
        }else {
            calendar.set(year, Integer.parseInt(start) - 2, 28);
        }

        parse.setTime(calendar.getTimeInMillis());

        calendar.set(year, Integer.parseInt(start) - 1, 28);
        parse1 = new Date(calendar.getTimeInMillis());


        List<Performance> performances = performanceService.getPerformanceBetweenStartDateAndEndDate(parse, parse1);
        java.sql.Date startDates = new java.sql.Date(parse.getTime());
        java.sql.Date endDates = new java.sql.Date(parse1.getTime());
        LinkedList report1 = reportDao.getReport1(startDates.toString(), endDates.toString());
        LinkedList report2 = reportDao.getReport2(startDates.toString(), endDates.toString());
        LinkedList report3 = reportDao.getReport3(startDates.toString(), endDates.toString());
        LinkedList report4 = reportDao.getReport4(startDates.toString(), endDates.toString());
        LinkedList report5 = reportDao.getReport5(startDates.toString(), endDates.toString());
        LinkedList report6 = reportDao.getReport6(startDates.toString(), endDates.toString());
        LinkedList report7 = reportDao.getReport7(startDates.toString(), endDates.toString());
        LinkedList report8 = reportDao.getReport8(startDates.toString(), endDates.toString());
        LinkedList report9 = reportDao.getReport9(startDates.toString(), endDates.toString());

        request.setAttribute("1",report1);
        request.setAttribute("2",report2);
        request.setAttribute("3",report3);
        request.setAttribute("4",report4);
        request.setAttribute("5",report5);
        request.setAttribute("6",report6);
        request.setAttribute("7",report7);
        request.setAttribute("8",report8);
        request.setAttribute("9",report9);


        request.getRequestDispatcher("/record/report.jsp").forward(request, response);

    }


}