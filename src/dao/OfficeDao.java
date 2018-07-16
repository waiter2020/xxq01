package dao;

import bean.Office;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;

public interface OfficeDao {
    /**
     * 分页查询符合日期范围的报表
     * @param pageBean 页面实体
     * @param cls Class字节码
     * @param name1 第一个字段名
     * @param value1 结束日期
     * @param name2
     * @param value2 开始日期
     * @return 符合日期范围的信息
     */
    PageBean findByDate(PageBean pageBean, Class cls, String name1, String value1, String name2, String value2);

    /**
     * 保存
     * @param office
     * @return 是否成功
     */
    boolean save(Office office);

    /**
     * 通过员工id查找最后一条记录
     * @param staff
     * @return
     */
    Office findLastByStaff(int staff);

    LinkedList findListByEndDateBeforAndStartAfterAndState(Date endDate, Date startDate,int state);

    int countByEndDateBeforAndStartAfterAndState(Date endDate, Date startDate,int state);
}
