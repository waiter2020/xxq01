package service;

import bean.Staff;
import dao.StaffDao;
import dao.impl.StaffDaoImpl;
import utils.PageBean;

/**
 * Created by  waiter on 18-7-9  下午9:20.
 *
 * @author waiter
 */
public class StaffService {
    private static final StaffService staffService = new StaffService();
    private StaffService(){}
    StaffDao staffDao = StaffDaoImpl.getStaffDao();

    /**
     * 通过部门分页查找员工
     * @param pageBean
     * @param department
     * @return
     */
    public PageBean findByPageAndDepartment(PageBean pageBean,int department){
        return staffDao.findByPageAndDepartment(pageBean,department);
    }


    /**
     * 通过用户名查找员工
     * @param userName
     * @return
     */
    public Staff findByUserName(String userName){
        return staffDao.findByUserName(userName);
    }

    /**
     * 通过部门id和工作状态分页查找员工
     * @param pageBean
     * @param department
     * @param iswork
     * @return
     */
    public PageBean findByPageAndDepartmentAndIsWork(PageBean pageBean,int department,boolean iswork){
       return staffDao.findByPageAndDepartmentAndIsWork(pageBean,department,iswork);
    }

    /**
     * 辞退员工
     * @param id
     * @return
     */
    public boolean dismissStaff(int id){
        boolean b = false;
        Staff byId = staffDao.findById(id);
        byId.setIsWork(false);
        b = staffDao.save(byId);
        return b;
    }

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    public Staff findById(int id){
        return staffDao.findById(id);
    }

    /**
     * 保存员工
     * @param staff
     * @return
     */
    public boolean save(Staff staff){
        return staffDao.save(staff);
    }

    public PageBean findPageByDepartAndStation(PageBean pageBean, int depart, int station){
        return staffDao.findPageByDepartAndStation(pageBean,depart,station);
    }

    public static StaffService getStaffService() {
        return staffService;
    }

}
