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
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by  waiter on 18-7-9  下午9:48.
 *
 * @author waiter
 */
@WebServlet(name = "StaffServlet", urlPatterns = {"/staff/list", "/staff/delete","/staff/change","/staff/add","/staff/transfer"})
public class StaffServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private StaffService staffService = StaffService.getStaffService();
    private DepartService departService = DepartService.getDepartService();
    private UserService userService = UserService.getUserService();
    private StationService stationService = StationService.getStationService();
    RecordService recordService = RecordService.getRecordService();

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
        String uri = request.getRequestURI();
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
        String uri = request.getRequestURI();
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
                            request.setAttribute("msg", "成功辞退员工");

                            logger.info(loginInfo + "辞退了" + id + "员工");
                        } else {
                            request.setAttribute("msg", "未知错误");
                        }
                    }
                }
            }
        }
        request.getRequestDispatcher("/staff/list").forward(request, response);
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
        String phoneNum = request.getParameter("phoneNum");
        String wAges = request.getParameter("wAges");
        String age = request.getParameter("age");
        if(id==null||"".equals(id)){
            request.getRequestDispatcher("/staff/change.jsp").forward(request,response);
            return;
        }
        Staff byId = staffService.findById(Integer.parseInt(id));
        byId.setStaffName(staffName);
        byId.setPhoneNum(phoneNum);
        byId.setwAges(Integer.parseInt(wAges));
        byId.setAge(Integer.parseInt(age));
        boolean save = staffService.save(byId);
        if(save){
            request.setAttribute("msg","修改成功");
            request.getRequestDispatcher("/staff/list").forward(request, response);
        }else {
            request.setAttribute("msg","修改出错，请检查参数是否有误");
            request.getRequestDispatcher("/staff/change.jsp").forward(request, response);
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
    protected void toThangeStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Staff byId = staffService.findById(Integer.parseInt(id));
        request.setAttribute("change",byId);
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
        String idCard = request.getParameter("idCard");
        String age = request.getParameter("age");
        String station = request.getParameter("station");

        Depart byId = departService.findById(Integer.parseInt(departMent));
        Station byId1 = stationService.findById(Integer.parseInt(station));
        Staff staff = new Staff(userName, staffName, byId, byId1, phoneNum, Integer.parseInt(age), idCard, true, 0);
        User user = new User(userName, staff, BCrypt.hashpw(userName,BCrypt.gensalt(10)), 1);
        boolean save = staffService.save(staff);
        boolean save1 = userService.save(user);
        if(save&&save1){
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("/staff/list").forward(request, response);
        }else {
            request.setAttribute("msg","添加出错，请检查参数是否有误");
            request.getRequestDispatcher("/staff/add.jsp").forward(request, response);
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
        String result = request.getParameter("result");
        String id = request.getParameter("id");
        //得给我传一个部门或岗位的id
        String result_id = request.getParameter("result_id");
        Staff byId = staffService.findById(Integer.parseInt(id));
        if("1".equals(mark)){
            boolean save = recordService.save(byId, Integer.parseInt(mark), byId.getStation().getStationName(), result);
            if(save){
                Station byId1 = stationService.findById(Integer.parseInt(result_id));
                byId.setStation(byId1);
                boolean save1 = staffService.save(byId);
                if(save1){
                    request.setAttribute("msg","变动成功");
                }
            }
        }else {
            boolean save = recordService.save(byId, Integer.parseInt(mark), byId.getDepartment().getDepartName(), result);
            if(save){
                Depart byId1 = departService.findById(Integer.parseInt(result_id));
                byId.setDepartment(byId1);
                boolean save1 = staffService.save(byId);
                if(save1){
                    request.setAttribute("msg","变动成功");
                }
            }
        }

        request.getRequestDispatcher("/staff/list").forward(request,response);
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
        LinkedList<Station> all = stationService.findAll();
        request.setAttribute("stations",all);
        LinkedList<Depart> all1 = departService.findAll();
        request.setAttribute("departs",all1);
        request.getRequestDispatcher("/staff/transfer.jsp").forward(request,response);
    }

}
