package dao;

import bean.Office;
import utils.PageBean;

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


}
