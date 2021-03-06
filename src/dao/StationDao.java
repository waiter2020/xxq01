package dao;

import bean.Station;
import utils.PageBean;

import java.util.LinkedList;

public interface StationDao {
    /**
     * 岗位分页查询方法
     *
     * @param pageBean
     * @return 分页查询信息
     */
    PageBean listPage(PageBean pageBean);

    /**
     * 根据部门号分页查找
     *
     * @param pageBean
     * @param depart
     * @return
     */
    PageBean getPageByDepart(PageBean pageBean, int depart);

    /**
     * 插入岗位信息
     *
     * @param station
     * @return 是否插入成功
     */
    boolean stationInsert(Station station);

    /**
     * 通过岗位名查找岗位
     *
     * @param stationName
     * @return 通过岗位名查询信息
     */
    Station findByName(String stationName);

    /**
     * 通过岗位名删除信息
     *
     * @param stationName
     * @return 是否删除成功
     */
    boolean deleteByName(String stationName);

    /**
     * 通过id查找一个岗位
     *
     * @param id
     * @return
     */
    Station findById(int id);

    /**
     * 查找所有岗位，返回链表
     *
     * @return
     */
    LinkedList findAll();

    Station findByNameAndDepart(String stationName, int depart);

}
