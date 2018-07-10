package dao.impl;

import bean.Staff;
import dao.StaffDao;
import utils.DBUtils;
import utils.PageBean;

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

    public synchronized static StaffDaoImpl getStaffDao() {
        return staffDao;
    }
}
