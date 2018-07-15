package dao.impl;

import bean.Office;
import dao.OfficeDao;
import utils.DBUtils;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午4:25 18-7-11
 */
public class OfficeDaoImpl implements OfficeDao{
    public OfficeDaoImpl(){}
    private final static OfficeDaoImpl officeDaoImpl = new OfficeDaoImpl();

    @Override
    public PageBean findByDate(PageBean pageBean,Class cls,String name1,String value1,String name2,String value2){
        pageBean = DBUtils.getPageByBeforSomeAndAfterSome(pageBean,cls,name1,value1,name2,value2);
        return pageBean;
    }

    @Override
    public boolean save(Office office) {
        return DBUtils.insert(office);
    }

    @Override
    public Office findLastByStaff(int staff) {
        LinkedList listBySome = DBUtils.getListBySome(Office.class, "staff", staff + "");
        if(listBySome==null){
            return null;
        }
        //取最后一个
        return (Office) listBySome.getLast();
    }

    @Override
    public LinkedList findListByEndDateBeforAndStartAfterAndState(Date endDate, Date startDate,int state) {
        java.sql.Date startDates = new java.sql.Date(startDate.getTime());
        java.sql.Date endDates = new java.sql.Date(endDate.getTime());
        return DBUtils.getListByBeforSomeAndAfterSomeAndSome( Office.class,"date",endDates.toString(),"date",startDates.toString(),"state",state+"");
    }

    @Override
    public int countByEndDateBeforAndStartAfterAndState(Date endDate, Date startDate, int state) {
        java.sql.Date startDates = new java.sql.Date(startDate.getTime());
        java.sql.Date endDates = new java.sql.Date(endDate.getTime());
        Map<String, String> map = new TreeMap<>();
        map.put(endDates.toString(), "date");
        map.put(startDates.toString(), "date");
        return DBUtils.getObjectCount( Office.class,map, ">", "<");
    }


    public static OfficeDaoImpl getOfficeDaoImpl(){
        return officeDaoImpl;
    }
}
