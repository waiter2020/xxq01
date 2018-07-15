package dao.impl;

import bean.Performance;
import dao.PerformanceDao;
import utils.DBUtils;

import java.util.Date;
import java.util.List;

public class PerformanceDaoImpl implements PerformanceDao {
    private static final PerformanceDaoImpl ChangeDaoImpl = new PerformanceDaoImpl();

    @Override
    public List<Performance> getPerformanceByIdAndBetweenStartDateAndEndDate(Date startDate, Date endDate,int staffId) {
        java.sql.Date startDates = new java.sql.Date(startDate.getTime());
        java.sql.Date endDates = new java.sql.Date(endDate.getTime());
        return DBUtils.getListByBeforSomeAndAfterSomeAndSome(Performance.class,"mouth",endDates.toString(),"mouth",startDates.toString(),"staff",staffId+"");
    }

    @Override
    public List<Performance> getPerformanceBetweenStartDateAndEndDate(Date startDate, Date endDate) {
        java.sql.Date startDates = new java.sql.Date(startDate.getTime());
        java.sql.Date endDates = new java.sql.Date(endDate.getTime());

        return DBUtils.getListByBeforSomeAndAfterSome(Performance.class,"mouth",endDates.toString(),"mouth",startDates.toString());
    }

    public static PerformanceDaoImpl getChangeDaoImpl() {
        return ChangeDaoImpl;
    }
}
