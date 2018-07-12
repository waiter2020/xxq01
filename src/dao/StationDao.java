package dao;

import bean.Station;
import utils.PageBean;

public interface StationDao {
    /**
     * 岗位分页查询方法
     *
     * @return 分页查询信息
     */
    PageBean listPage(PageBean pageBean);


    /**
     * 插入岗位信息
     * @param station
     * @return 是否插入成功
     */
    boolean stationInsert(Station station);

    /**
     *
     * @param stationName
     * @return 通过岗位名查询信息
     */
    Station findByName(String stationName);

    /**
     * 通过岗位名删除信息
     * @param stationName
     * @return 是否删除成功
     */
    boolean deleteByName(String stationName);
}
