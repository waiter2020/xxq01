package service;

import bean.Record;
import bean.Staff;
import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import utils.PageBean;

import java.util.Date;

/**
 * Created by  waiter on 18-7-11  下午12:50.
 *
 * @author waiter
 */
public class RecordService {
    private static final RecordService RecordService = new RecordService();
    private RecordDao recordDao = RecordDaoImpl.getChangeDaoImpl();

    public Record findByUserName(String userName){
        return recordDao.findByUserName(userName);
    }

    public boolean save(Staff staff,int mark,String source, String result){
        return recordDao.save(new Record(staff.getUserName(),staff.getStaffName(),mark,source,result,new Date()));
    }

    public PageBean findPageByEndDateBeforAndStartDateAfter(PageBean pageBean,Date endDate,Date startDate){
        if(endDate.before(startDate)){
            pageBean.setTotalCount(0);
            pageBean.getPageData().clear();
            return pageBean;
        }
        return recordDao.findPageByEndDateBeforAndStartAfter(pageBean,endDate,startDate);
    }

    public static RecordService getRecordService() {
        return RecordService;
    }
}
