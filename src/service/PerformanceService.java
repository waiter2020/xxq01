package service;

import bean.Performance;
import dao.PerformanceDao;
import dao.impl.PerformanceDaoImpl;

import java.util.Date;
import java.util.List;

public class PerformanceService {
    private static final PerformanceService performanceService = new PerformanceService();
    private PerformanceDao performanceDao = PerformanceDaoImpl.getChangeDaoImpl();
    public List<Performance> getPerformanceByIdAndBetweenStartDateAndEndDate(Date startDate, Date endDate, int staffId){
        return performanceDao.getPerformanceByIdAndBetweenStartDateAndEndDate(startDate,endDate,staffId);
    }
    public PerformanceService getPerformanceService(){return performanceService;}
}
