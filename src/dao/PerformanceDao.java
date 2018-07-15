package dao;

import bean.Performance;

import java.util.Date;
import java.util.List;

public interface PerformanceDao {
    List<Performance> getPerformanceByIdAndBetweenStartDateAndEndDate(Date startDate,Date endDate,int staffId);


    List<Performance> getPerformanceBetweenStartDateAndEndDate(Date startDate,Date endDate);
}
