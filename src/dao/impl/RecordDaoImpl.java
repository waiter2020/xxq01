package dao.impl;

import bean.Record;
import dao.RecordDao;
import utils.DBUtils;
import utils.PageBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by  waiter on 18-7-11  下午12:47.
 *
 * @author waiter
 */
public class RecordDaoImpl implements RecordDao {

    private static final RecordDaoImpl ChangeDaoImpl = new RecordDaoImpl();

    @Override
    public Record findByUserName(String userName) {
        LinkedList userName1 = DBUtils.getListBySome(Record.class, "userName", userName);
        if(userName1==null||userName1.size()==0){
            return null;
        }
        return (Record) userName1.remove(0);
    }

    @Override
    public boolean save(Record record) {
        boolean b=DBUtils.insert(record);
        return b;
    }

    @Override
    public PageBean findPageByEndDateBeforAndStartAfter(PageBean pageBean, Date endDate, Date startDate) {
        //类型转换
        java.sql.Date startDates = new java.sql.Date(startDate.getTime());
        java.sql.Date endDates = new java.sql.Date(endDate.getTime());
        return DBUtils.getPageByBeforSomeAndAfterSome(pageBean, Record.class,"date",endDates.toString(),"date",startDates.toString());
    }

    public static RecordDaoImpl getChangeDaoImpl() {
        return ChangeDaoImpl;
    }
}
