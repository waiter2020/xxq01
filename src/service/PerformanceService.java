package service;

import bean.Performance;
import dao.PerformanceDao;
import dao.impl.PerformanceDaoImpl;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PerformanceService {
    private static final PerformanceService performanceService = new PerformanceService();
    private PerformanceDao performanceDao = PerformanceDaoImpl.getChangeDaoImpl();
    private PerformanceService(){}
    public List<Performance> getPerformanceByIdAndBetweenStartDateAndEndDate(Date startDate, Date endDate, int staffId){
        return performanceDao.getPerformanceByIdAndBetweenStartDateAndEndDate(startDate,endDate,staffId);
    }


    public List<Performance> getPerformanceBetweenStartDateAndEndDate(Date startDate, Date endDate) {
        return performanceDao.getPerformanceBetweenStartDateAndEndDate(startDate,endDate);
    }

    public LinkedList<Performance> findByStaff(int staff){
        return performanceDao.findByStaff(staff);
    }

    public LinkedList<Performance> findByStaffAndAfterDate(int staff, Date date){
        return performanceDao.findByStaffAndAfterDate(staff,date);
    }

    public PageBean getPageByDateAfter(PageBean pageBean, Date date) {
        return performanceDao.getPageByDateAfter(pageBean,date);
    }

    public static PerformanceService getPerformanceService() {
        return performanceService;
    }
}
