package dao.impl;

import bean.Station;
import dao.StationDao;
import utils.DBUtils;
import utils.PageBean;

import java.util.LinkedList;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:44 18-7-10
 */
public class StationDaoImpl implements StationDao{
    private static final StationDaoImpl stationDaoImpl = new StationDaoImpl();
    StationDaoImpl(){}

    @Override
    public PageBean listPage(PageBean pageBean){
        return DBUtils.getPage(pageBean,Station.class);
    }


    @Override
    public boolean stationInsert(Station station){
        return DBUtils.insert(station);
    }

    @Override
    public Station findByName(String stationname){
        LinkedList stationName = DBUtils.getListBySome(Station.class, "stationname", stationname+"");
        if(stationName.size()==0){
            return new Station(0,"not exist");
        }else{
            return (Station) stationName.remove(0);
        }
    }
    @Override
    public boolean deleteByName(String stationname){

        Station station=findByName(stationname);
        if(station.getStationname()==null){
            return false;
        }else{
            return DBUtils.delete(Station.class,station.getId());
        }

    }


    public static StationDaoImpl getStationDao(){
        return stationDaoImpl;
    }
}
