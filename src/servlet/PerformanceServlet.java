package servlet;

import bean.Performance;
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

        int z = officeService.countByEndDateBeforAndStartAfterAndState(parse1, parse, 1);
        int x = officeService.countByEndDateBeforAndStartAfterAndState(parse1, parse, 0);
        int l = officeService.countByEndDateBeforAndStartAfterAndState(parse1, parse, 2);
        //在职
        request.setAttribute("z", z + x);
        //离职
        request.setAttribute("l", l);
        //实习
        request.setAttribute("x", x);
        //正式
        request.setAttribute("z", z);

        double avgAge = staffService.avgAge();
        request.setAttribute("avgAge", avgAge);

        int i = staffService.countBySex(0);
        request.setAttribute("man", i);
        int i1 = staffService.countBySex(1);
        request.setAttribute("woman", i1);

        performances.sort(Comparator.naturalOrder());
        request.setAttribute("performances ", performances);


        request.getRequestDispatcher("/record/report.jsp").forward(request, response);

    }


}