package service;

import bean.Performance;
import dao.PerformanceDao;
import dao.impl.PerformanceDaoImpl;

import java.util.Date;
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

    public static PerformanceService getPerformanceService() {
        return performanceService;
    }
}
