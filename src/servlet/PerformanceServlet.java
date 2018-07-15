package servlet;

import bean.Performance;
import service.PerformanceService;

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
import java.util.List;

@WebServlet(name = "PerformanceServlet")
public class PerformanceServlet extends HttpServlet {
    private PerformanceService performanceService = new PerformanceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        int id = Integer.parseInt(request.getParameter("id"));
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        Date parse1=null;
        try {
            parse = sDateFormat.parse(start);
            parse1 = sDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Performance> listPerformanceByIdAndBetweenStartDateAndEndDate = performanceService.getPerformanceByIdAndBetweenStartDateAndEndDate(parse,parse1,id);
        request.setAttribute("list",listPerformanceByIdAndBetweenStartDateAndEndDate);
        request.getRequestDispatcher("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
