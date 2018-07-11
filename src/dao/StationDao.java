package dao;

import utils.PageBean;

public interface StationDao {
    /**
     * 岗位分页查询方法
     * @param pageBean
     * @return 分页查询信息
     */
    PageBean listPage(PageBean pageBean);
}
