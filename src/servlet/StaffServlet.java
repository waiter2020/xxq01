package servlet;

import bean.*;
import service.*;
import utils.BCrypt;
import utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by  waiter on 18-7-9  下午9:48.
 *
 * @author waiter
 */
@WebServlet(name = "StaffServlet", urlPatterns = {"/staff/list", "/staff/delete","/staff/change",
                                                "/staff/add","/staff/transfer","/staff/turn",
                                                "/staff/select","/staff/staff_report"})
public class StaffServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private StaffService staffService = StaffService.getStaffService();
    private DepartService departService = DepartService.getDepartService();
    private UserService userService = UserService.getUserService();
    private StationService stationService = StationService.getStationService();
    private RecordService recordService = RecordService.getRecordService();
    private OfficeService officeService = OfficeService.getOfficeService();
    private PerformanceService performanceService = PerformanceService.getPerformanceService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(7, uri.length());
        if ("change".equals(substring)) {
            changeStaff(request, response);
        }else if ("add".equals(substring)){
            addStaff(request,response);
        }else if("transfer".equals(substring)){
            transferStaff(request,response);
        }else if("turn".equals(substring)){
            turnStaff(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String substring = uri.substring(7, uri.length());
        if ("list".equals(substring)) {
            getStaffList(request, response);
        } else if ("delete".equals(substring)) {
            dismissStaff(request, response);
        }else if("add".equals(substring)){
            toAddStaff(request,response);
        }else if("transfer".equals(substring)) {
            toTransferStaff(request, response);
        }else if ("change".equals(substring)) {
            toChangeStaff(request, response);
        }else if("turn".equals(substring)){
            turnStaff(request,response);
        }else if ("select".equals(substring)){
            toSelect(request,response);
        }else if ("staff_report".equals(substring)){
            getStaffReport(request,response);
        }
    }

    /**
     * 获取员工列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getStaffList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        String currentPage = request.getParameter("currentPage");
        if (currentPage != null && !currentPage.isEmpty()) {
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");
        Staff byUserName = staffService.findByUserName(loginInfo.getUserName());
        logger.info("用户：" + byUserName + "查询了员工列表");
        pageBean = staffService.findByPageAndDepartmentAndIsWork(pageBean, byUserName.getDepartment().getId(), true);

        request.setAttribute("page", pageBean);
        request.getRequestDispatcher("/staff/list.jsp").forward(request, response);
    }

    /**
     * 辞退员工
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void dismissStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        User loginInfo = (User) request.getSession().getAttribute("loginInfo");

        if (id != null) {
            if (loginInfo.getId() != Integer.parseInt(id)) {
                Staff byId = staffService.findById(Integer.parseInt(id));
                if (byId != null) {
                    if (byId.getDepartment().getId() != loginInfo.getStaff().getDepartment().getId()) {
                        request.getRequestDispatcher("/staff/list").forward(request, response);
                    } else {
                        boolean b = staffService.dismissStaff(Integer.parseInt(id));
                        if (b) {
                            boolean save = officeService.save(byId, 2);
                            if (save) {
                                request.setAttribute("msg", "成功辞退员工");

                                logger.info(loginInfo + "辞退了" + id + "员工");
                            }
                        } else {
                            request.setAttribute("msg", "未知错误");
                        }
                    }
                }
            }
        }
        getStaffList(request,response);
    }


    /**
     * post方法，修改员工的几个信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void changeStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String staffName = request.getParameter("staffName");
        String idCard = request.getParameter("idCard");
        String phoneNum = request.getParameter("phoneNum");
        String wAges = request.getParameter("wAges");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if(id==null||"".equals(id)){
            request.getRequestDispatcher("/staff/change.jsp").forward(request,response);
            return;
        }
        Staff byId = staffService.findById(Integer.parseInt(id));
        byId.setStaffName(staffName);
        byId.setPhoneNum(phoneNum);
        byId.setwAges(Integer.parseInt(wAges));
        byId.setAge(Integer.parseInt(age));
        byId.setEmail(email);
        byId.setAddress(address);
        byId.setIdCard(idCard);
        boolean save = staffService.save(byId);
        if(save){
            request.setAttribute("msg","修改成功");
            getStaffList(request,response);
        }else {
            request.setAttribute("msg","修改出错，请检查参数是否有误");
            toChangeStaff(request,response);
        }
    }

    /**
     * 修改员工信息中转，需要提供参数员工id
     * 例如url后加？id=1
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toChangeStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Staff byId = staffService.findById(Integer.parseInt(id));
        request.setAttribute("change",byId);
        LinkedList<Station> all = stationService.findAll();
        request.setAttribute("stations",all);
        LinkedList<Depart> all1 = departService.findAll();
        request.setAttribute("departs",all1);
        request.getRequestDispatcher("/staff/change.jsp").forward(request,response);
    }


    /**
     * 添加员工接口，post方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffName = request.getParameter("staffName");
        String departMent = request.getParameter("departMent");
        String userName = request.getParameter("userName");
        String phoneNum = request.getParameter("phoneNum");
        String sex = request.getParameter("sex");
        String idCard = request.getParameter("idCard");
        String age = request.getParameter("age");
        String station = request.getParameter("station");
        String wAges = request.getParameter("wAges");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        Depart byId = departService.findById(Integer.parseInt(departMent));
        Station byId1 = stationService.findById(Integer.parseInt(station));

        Staff staff = new Staff(userName, staffName, byId, byId1, phoneNum, Integer.parseInt(age), idCard, true, Integer.parseInt(wAges),email,address,Integer.parseInt(sex));
        boolean save = staffService.save(staff);
        staff = staffService.findByUserName(userName);
        User user = new User(userName, staff, BCrypt.hashpw(userName,BCrypt.gensalt(10)), 1);

        boolean save1 = userService.save(user);
        if(save&&save1){
            request.setAttribute("msg","添加成功");
            getStaffList(request,response);
        }else {
            request.setAttribute("msg","添加出错，请检查参数是否有误");
            toAddStaff(request,response);
        }

    }

    /**
     * 添加员工之前的跳转，先请求到这里再跳转到添加员工的页面，
     * 在这里加入岗位和部门信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toAddStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LinkedList<Station> all = stationService.findAll();
        request.setAttribute("stations",all);
        LinkedList<Depart> all1 = departService.findAll();
        request.setAttribute("departs",all1);
        request.getRequestDispatcher("/staff/add.jsp").forward(request,response);
    }

    /**
     * 员工变更，仅需要提交员工id和变动的信息，post方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void transferStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mark = request.getParameter("mark");
        //员工id
        String id = request.getParameter("id");
        //各id
        //String srcStation = request.getParameter("srcStation");
        String resStation = request.getParameter("resStation");
        //String srcDepart = request.getParameter("srcDepart");
        String resDepart = request.getParameter("resDepart");
        Staff byId = staffService.findById(Integer.parseInt(id));

        Station resStations = stationService.findById(Integer.parseInt(resStation));
        Depart depart1 = departService.findById(Integer.parseInt(resDepart));

        boolean save = recordService.save(byId, Integer.parseInt(mark), byId.getStation(), resStations, byId.getDepartMent(), depart1);
        byId.setDepartment(depart1);
        byId.setStation(resStations);
        boolean save1 = staffService.save(byId);
        if(save&&save1){
            request.setAttribute("msg","变动成功");
        }

        getStaffList(request,response);
    }

    /**
     * 员工信息变动前的信息准备，在跳转到变动页前，先请求到这里，加入信息后转发
     * 部门信息和岗位信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toTransferStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Staff byId = staffService.findById(Integer.parseInt(id));
        request.setAttribute("staff",byId);
        LinkedList<Station> all = stationService.findAll();
        request.setAttribute("stations",all);
        LinkedList<Depart> all1 = departService.findAll();
        request.setAttribute("departs",all1);
        request.getRequestDispatcher("/staff/transfer.jsp").forward(request,response);
    }

    /**
     * 员工转正，post和get都可以
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void turnStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Staff byId = staffService.findById(Integer.parseInt(id));
        if(byId!=null){
        Office lastByStaff = officeService.findLastByStaff(byId.getId());
        if(lastByStaff!=null&&lastByStaff.getState()!=1){
            boolean save = officeService.save(byId, 1);
            if(save){
                request.setAttribute("msg","变更成功");
            }
        }else {
            request.setAttribute("msg","变更失败");
        }
        }
        getStaffList(request,response);
    }

    /**
     * 直接重定向到查询页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        String condition = request.getParameter("condition");
        if (op!=null&&condition!=null) {
            PageBean pageBean = new PageBean();
            String currentPage = request.getParameter("currentPage");
            if (currentPage != null && !currentPage.isEmpty()) {
                pageBean.setCurrentPage(Integer.parseInt(currentPage));
            }
            User loginInfo = (User) request.getSession().getAttribute("loginInfo");
            Staff byUserName = staffService.findByUserName(loginInfo.getUserName());
            logger.info("用户：" + byUserName + "查询了员工");

            switch (op){
                case "1":
                    Staff byUserName1 = staffService.findByUserName(condition);
                    pageBean.getPageData().add(byUserName1);
                    break;
                case "2":
                    pageBean=staffService.findPageByStaffName(pageBean,condition);
                    break;
                case "3":
                    Depart byName = departService.findByName(condition);
                    pageBean=staffService.findByPageAndDepartment(pageBean,byName.getId());
                    break;
                case "4":
                    pageBean=staffService.findPageBywAgesAfter(pageBean,Integer.parseInt(condition));
                    break;
                case "5":
                    pageBean=staffService.findPageBywAgesBefor(pageBean,Integer.parseInt(condition));
                default:

            }

            request.setAttribute("page", pageBean);
        }
        request.getRequestDispatcher("/staff/select.jsp").forward(request, response);
    }



    protected void getStaffReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Date parse = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        int m = calendar.get(Calendar.MONTH);
        if(m<=6){
            calendar.set(Calendar.YEAR-1,m-6+12,1);
        }else {
            calendar.set(Calendar.MONTH,m-6);
            calendar.set(Calendar.DATE,1);
        }
        Date time = calendar.getTime();
        calendar.setTime(parse);
        if (m==0){
            calendar.set(Calendar.YEAR-1,11,1);
        }else {
            calendar.set(Calendar.MONTH,m-1);
            calendar.set(Calendar.DATE,1);
        }

        Date time1 = calendar.getTime();
        LinkedList<Performance> byStaffAndAfterDate1 = performanceService.findByStaffAndAfterDate(Integer.parseInt(id), time1);
        LinkedList<Performance> byStaffAndAfterDate = performanceService.findByStaffAndAfterDate(Integer.parseInt(id), time);
        calendar.setTime(parse);

        request.setAttribute("six",byStaffAndAfterDate);
        request.setAttribute("one",byStaffAndAfterDate1);
        request.getRequestDispatcher("/staff/staff_report.jsp").forward(request,response);


    }

}
