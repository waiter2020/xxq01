package dao.impl;

import bean.Station;
import dao.StationDao;
import utils.DBUtils;
import utils.PageBean;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:44 18-7-10
 */
public class StationDaoImpl implements StationDao{
    private static final StationDaoImpl stationDaoImpl = new StationDaoImpl();
    StationDaoImpl(){}

    public PageBean listPage(PageBean pageBean){
        return DBUtils.getPage(pageBean,Station.class);
    }

    public static StationDaoImpl getStationDao(){
        return stationDaoImpl;
    }
}
