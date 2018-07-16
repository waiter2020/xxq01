package test.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import service.RecordService;
import utils.PageBean;

import java.util.Calendar;
import java.util.Date;

/** 
* RecordService Tester.
* 
* @author <Authors name> 
* @since <pre>七月 11, 2018</pre> 
* @version 1.0 
*/ 
public class RecordServiceTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findByUserName(String userName) 
* 
*/ 
@Test
public void testFindByUserName() throws Exception { 
//TODO: Test goes here...
    Date parse = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parse);
    System.out.println(calendar.get(Calendar.MONTH));
} 

/** 
* 
* Method: save(Staff staff, int mark, String source, String result) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPageByEndDateBeforAndStartDateAfter(PageBean pageBean, Date endDate, Date startDate) 
* 
*/ 
@Test
public void testFindPageByEndDateBeforAndStartDateAfter() throws Exception { 
//TODO: Test goes here...
    Date endDate = new Date();
    Date startDate = new Date(endDate.getTime()-1000000000);
    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
    System.out.println(date.toString());
    RecordService recordService = RecordService.getRecordService();
    PageBean pageBean = new PageBean();
    pageBean = recordService.findPageByEndDateBeforAndStartDateAfter(pageBean, endDate, startDate);
    System.out.println(pageBean.getPageData().toString());
} 

/** 
* 
* Method: getRecordService()
* 
*/ 
@Test
public void testGetChangService() throws Exception { 
//TODO: Test goes here... 
} 


} 
