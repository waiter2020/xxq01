package test.service; 

import bean.Depart;
import bean.Staff;
import bean.Station;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import service.StaffService;
import utils.DBUtils;

import java.util.Calendar;
import java.util.Date;

/** 
* StaffService Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 11, 2018</pre>
* @version 1.0 
*/ 
public class StaffServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findByPageAndDepartment(PageBean pageBean, int department)
* 
*/ 
@Test
public void testFindByPageAndDepartment() throws Exception {
//TODO: Test goes here...
    Date parse = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parse);
    int m = calendar.get(Calendar.MONTH);
    if(m<6){
        calendar.set(Calendar.YEAR-1,m-6+12,1);
    }else {
        calendar.set(Calendar.MONTH,m-6);
    }
    Date time = calendar.getTime();
    calendar.setTime(parse);
    m = calendar.get(Calendar.MONTH);
    if (m==0){
        calendar.set(Calendar.YEAR-1,11,Calendar.DATE);
    }else {
        calendar.set(Calendar.MONTH,m-1);
    }

    Date time1 = calendar.getTime();
} 

/** 
* 
* Method: getStaffService() 
* 
*/ 
@Test
public void testGetStaffService() throws Exception { 
//TODO: Test goes here...
}

/**
*
* Method: findByUserName(String userName)
*
*/
@Test
public void testFindByUserName() throws Exception {
//TODO: Test goes here...
    StaffService staffService = StaffService.getStaffService();
    Staff byUserName = staffService.findByUserName("1502010400");
    System.out.println(byUserName);
    //byUserName.setAge(20);
    Depart department = byUserName.getDepartment();
    department.setDepartName("jdsbvhjbf");
    byUserName.setDepartment(department);
    Station station = byUserName.getStation();
    station.setStationName("vfvjfnjkdv");
    byUserName.setStation(station);
    DBUtils.update(byUserName);
}

/**
*
* Method: findByPageAndDepartmentAndIsWork(PageBean pageBean, int department, boolean iswork)
*
*/
@Test
public void testFindByPageAndDepartmentAndIsWork() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: dismissStaff(int id)
*
*/
@Test
public void testDismissStaff() throws Exception {
//TODO: Test goes here...
} 


} 
