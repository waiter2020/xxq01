package dao;

import bean.Office;
import utils.PageBean;

public interface OfficeDao {
    /**
     * 分页查询符合日期范围的报表
     * @param pageBean
     * @param cls
     * @param name1
     * @param value1
     * @param name2
     * @param value2
     * @return 符合日期范围的信息
     */
    PageBean findByDate(PageBean pageBean, Class cls, String name1, String value1, String name2, String value2);

    boolean save(Office office);
}
