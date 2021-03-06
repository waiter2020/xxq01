package dao.impl;

import bean.Station;
import dao.StationDao;
import utils.DBUtils;
import utils.PageBean;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:44 18-7-10
 */
public class StationDaoImpl implements StationDao {
    private static final StationDaoImpl stationDaoImpl = new StationDaoImpl();

    private StationDaoImpl() {
    }

    @Override
    public PageBean listPage(PageBean pageBean) {
        return DBUtils.getPage(pageBean, Station.class);
    }

    @Override
    public PageBean getPageByDepart(PageBean pageBean, int depart) {
        return DBUtils.getPageBySome(pageBean, Station.class, "depart", depart + "");
    }


    @Override
    public boolean stationInsert(Station station) {
        return DBUtils.insert(station);
    }

    @Override
    public Station findByName(String stationName) {
        LinkedList listBySome = DBUtils.getListBySome(Station.class, "stationname", stationName + "");
        if (listBySome.size() == 0) {
            return new Station(0, "not exist");
        } else {
            //取第一个
            return (Station) listBySome.remove(0);
        }
    }

    @Override
    public boolean deleteByName(String stationname) {

        Station station = findByName(stationname);
        if (station.getStationName() == null) {
            return false;
        } else {
            return DBUtils.delete(Station.class, station.getId());
        }

    }

    @Override
    public Station findById(int id) {
        return (Station) DBUtils.getObjectById(Station.class, id);
    }

    @Override
    public LinkedList<Station> findAll() {
        return DBUtils.getList(Station.class);
    }

    @Override
    public Station findByNameAndDepart(String stationName, int depart) {
        Map<String, String> map = new TreeMap<>();
        map.put("stationname", stationName);
        map.put("depart", depart + "");
        LinkedList listBySome = DBUtils.getListBySome(Station.class, map);
        if (listBySome == null) {
            return null;
        }
        return (Station) listBySome.remove(0);
    }


    public static StationDaoImpl getStationDao() {
        return stationDaoImpl;
    }
}
