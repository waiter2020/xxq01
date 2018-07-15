package dao.impl;

import bean.Staff;
import dao.StaffDao;
import utils.DBUtils;
import utils.PageBean;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by  waiter on 18-7-9  下午9:18.
 *
 * @author waiter
 */
public class StaffDaoImpl implements StaffDao {
    private static final StaffDaoImpl staffDao = new StaffDaoImpl();
    private StaffDaoImpl(){}
    @Override
    public PageBean findByPageAndDepartment(PageBean pageBean,int department) {
        return DBUtils.getPageBySome(pageBean,Staff.class,"department",department+"");
    }

    @Override
    public Staff findByUserName(String userName) {
        return (Staff) DBUtils.getListBySome(Staff.class,"userName",userName).remove(0);
    }

    @Override
    public PageBean findByPageAndDepartmentAndIsWork(PageBean pageBean, int department, boolean iswork) {
        Map<String,String> map = new TreeMap<>();
        map.put("department",department+"");
        map.put("iswork",String.valueOf(iswork));
        return DBUtils.getPageBySome(pageBean,Staff.class,map);
    }

    @Override
    public Staff findById(int id) {
        return (Staff) DBUtils.getObjectById(Staff.class,id);
    }

    @Override
    public boolean save(Staff staff) {
        //判断是要插入还是更新
        if(staff.getId()>0) {
            return DBUtils.update(staff);
        }else {
            return DBUtils.insert(staff);
        }
    }

    @Override
    public PageBean findPageByDepartAndStation(PageBean pageBean, int depart, int station) {
        Map<String,String> map = new TreeMap<>();
        map.put("department",depart+"");
        map.put("station",station+"");
        return DBUtils.getPageBySome(pageBean,Staff.class,map);
    }

    @Override
    public PageBean findPageByStaffName(PageBean pageBean, String staffName) {
        return DBUtils.getPageBySome(pageBean,Staff.class,"staffName",staffName);
    }

    @Override
    public PageBean findPageBywAgesAfter(PageBean pageBean, int wAges) {
        return DBUtils.getPageByAfterSome(pageBean,Staff.class,"wages",wAges+"");
    }

    @Override
    public PageBean findPageBywAgesBefor(PageBean pageBean, int wAges) {
        return DBUtils.getPageByBeforSome(pageBean,Staff.class,"wages",wAges+"");
    }

    @Override
    public int countBySexAndDepart(int sex,int depart) {
        Map<String,String> map = new TreeMap<>();
        map.put("sex",sex+"");
        map.put("department",depart+"");
        return DBUtils.getObjectCount(Staff.class,map);
    }

    @Override
    public LinkedList findAll() {
        return DBUtils.getList(Staff.class);
    }

    public synchronized static StaffDaoImpl getStaffDao() {
        return staffDao;
    }
}
