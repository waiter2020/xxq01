package dao;

import bean.Record;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by  waiter on 18-7-11  下午12:45.
 *
 * @author waiter
 */
public interface RecordDao {
    /**
     * 通过用户名查找变更
     * @param userName
     * @return
     */
    Record findByUserName(String userName);

    /**
     * 保存变动信息
     * @param record
     * @return
     */
    boolean save(Record record);

    /**
     * 通过起始时间和结束时间获取一个分页列表
     * @param pageBean
     * @param endDate
     * @param startDate
     * @return
     */
    PageBean findPageByEndDateBeforAndStartAfter(PageBean pageBean,Date endDate,Date startDate);

    LinkedList findListByEndDateBeforAndStartAfterAndMark(Date endDate, Date startDate,int mark);
}
