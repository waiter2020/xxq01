package service;

import bean.Depart;
import bean.Record;
import bean.Staff;
import bean.Station;
import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by  waiter on 18-7-11  下午12:50.
 *
 * @author waiter
 */
public class RecordService {
    private static final RecordService RecordService = new RecordService();
    private RecordDao recordDao = RecordDaoImpl.getChangeDaoImpl();

    /**
     * 通过用户名查找一条记录
     * @param userName
     * @return
     */
    public Record findByUserName(String userName){
        return recordDao.findByUserName(userName);
    }

    /**
     *
     * @param staff
     * @param mark
     * @return
     */
    public boolean save(Staff staff, int mark, Station srcStation, Station resStation, Depart srcDepart, Depart resDepart){
        return recordDao.save(new Record(staff,mark,srcStation,resStation,srcDepart,resDepart,new Date()));
    }

    /**
     * 根据日期区间分页查找记录
     * @param pageBean
     * @param endDate
     * @param startDate
     * @return
     */
    public PageBean findPageByEndDateBeforAndStartDateAfter(PageBean pageBean,Date endDate,Date startDate){
        if(endDate.before(startDate)){
            pageBean.setTotalCount(0);
            pageBean.getPageData().clear();
            return pageBean;
        }
        return recordDao.findPageByEndDateBeforAndStartAfter(pageBean,endDate,startDate);
    }

    LinkedList findListByEndDateBeforAndStartAfterAndMark(Date endDate, Date startDate, int mark){
        return recordDao.findListByEndDateBeforAndStartAfterAndMark(endDate,startDate,mark);
    }

    public static RecordService getRecordService() {
        return RecordService;
    }
}
