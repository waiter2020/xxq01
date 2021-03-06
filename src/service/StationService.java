package service;

import bean.Station;
import dao.StationDao;
import dao.impl.StationDaoImpl;
import utils.PageBean;

import java.util.LinkedList;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午1:01 18-7-11
 */
public class StationService {
    private final StationDao stationDao = StationDaoImpl.getStationDao();
    private static final StationService stationService = new StationService();

    private StationService() {
    }

    /**
     * 岗位分页查询方法
     *
     * @return 分页查询信息
     */
    public PageBean listPage(PageBean pageBean) {
        return stationDao.listPage(pageBean);
    }


    /**
     * 插入岗位信息
     *
     * @param station
     * @return 是否插入成功
     */
    public boolean stationInsert(Station station) {
        return stationDao.stationInsert(station);
    }

    /**
     * @param stationName
     * @return 通过岗位名查询信息
     */
    public Station findByName(String stationName) {
        return stationDao.findByName(stationName);
    }

    /**
     * 通过岗位名删除信息
     *
     * @param stationName
     * @return 是否删除成功
     */
    public boolean deleteByName(String stationName) {
        return stationDao.deleteByName(stationName);
    }

    /**
     * 通过id查找岗位
     *
     * @param id
     * @return
     */
    public Station findById(int id) {
        return stationDao.findById(id);
    }

    /**
     * 获取所有岗位列表
     *
     * @return
     */
    public LinkedList<Station> findAll() {
        return stationDao.findAll();
    }

    /**
     * 通过部门id分页查找
     *
     * @param pageBean
     * @param depart
     * @return
     */
    public PageBean getPageByDepart(PageBean pageBean, int depart) {
        return stationDao.getPageByDepart(pageBean, depart);
    }

    public Station findByNameAndDepart(String stationName, int depart) {
        return stationDao.findByNameAndDepart(stationName, depart);
    }

    public static StationService getStationService() {
        return stationService;
    }
}
