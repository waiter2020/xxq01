package dao;

import bean.Staff;
import utils.PageBean;

/**
 * Created by  waiter on 18-7-9  下午9:17.
 *
 * @author waiter
 */
public interface StaffDao {
    /**
     * 分页查询,通过部门id
     * @param pageBean
     * @param department 部门id
     * @return
     */
    PageBean findByPageAndDepartment(PageBean pageBean,int department);

    /**
     * 通过用户名查找员工
     * @param userName
     * @return
     */
    Staff findByUserName(String userName);
}
