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
     * @param source
     * @param result
     * @return
     */
    public boolean save(Staff staff,int mark,String source, String result){
        return recordDao.save(new Record(staff,mark,source,result,new Date()));
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

    public static RecordService getRecordService() {
        return RecordService;
    }
}
