package test.utils; 

import bean.Depart;
import bean.Record;
import bean.Staff;
import bean.User;
import dao.impl.ReportDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import utils.DBUtils;
import utils.PageBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/** 
* DBUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 10, 2018</pre> 
* @version 1.0 
*/ 
public class DBUtilsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: executeSQL(String sql, String... params) 
* 
*/ 
@Test
public void testExecuteSQL() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: executeQuerySQL(String sql, String... params) 
* 
*/ 
@Test
public void testExecuteQuerySQL() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getList(Class cls) 
* 
*/ 
@Test
public void testGetList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getObjectById(Class cl, int id) 
* 
*/ 
@Test
public void testGetObjectById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getListBySome(Class cl, String name, String value) 
* 
*/ 
@Test
public void testGetListBySomeForClNameValue() throws Exception { 
//TODO: Test goes here...
    PageBean pageBean = new PageBean();
    Date date = new Date();
    java.sql.Date date1 = new java.sql.Date(date.getTime());
    java.sql.Date date2 = new java.sql.Date(date.getTime()-1000000000);
    Map<String,String> map = new TreeMap<>();
    map.put("mark",3+"");
    map.put("src_station",1+"");
    map.put("res_station",3+"");

    //PageBean pageByBeforSomeAndAfterSomeAndSome = DBUtils.getPageByBeforSomeAndAfterSomeAndSome(pageBean, Record.class, "date", date1.toString(), "date", date2.toString(),map );

    //LinkedList listByBeforSomeAndAfterSome = DBUtils.getListByBeforSomeAndAfterSome(Record.class , "date", date1.toString(), "date", date2.toString());
    //System.out.println(listByBeforSomeAndAfterSome);
}

/** 
* 
* Method: insert(Object obj) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here...
    Staff staff= (Staff) DBUtils.getObjectById(Staff.class,1);
    staff.setId(66);
    staff.setUserName("cdsvcfsv");
    Depart objectById = (Depart) DBUtils.getObjectById(Depart.class, 1);
    boolean insert = DBUtils.insert(objectById);
    DBUtils.insert(new User(staff.getUserName(),staff,"cdvfsvfd",5));
} 

/** 
* 
* Method: update(Object obj) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here...
    Object objectById = DBUtils.getObjectById(Staff.class, 1);
    System.out.println(objectById);
} 

/** 
* 
* Method: delete(Class clz, int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here...
    DBUtils.delete(User.class,20);
} 

/** 
* 
* Method: getObjectCount(Class cls) 
* 
*/ 
@Test
public void testGetObjectCount() throws Exception { 
//TODO: Test goes here...
    ReportDaoImpl reportDao =ReportDaoImpl.getReportDao();
    LinkedList report = reportDao.getReport2("2018-7-1", "2018-7-25");
    System.out.println(report.toString());
} 

/** 
* 
* Method: getPage(PageBean pageBean, Class cls) 
* 
*/ 
@Test
public void testGetPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPageBySome(PageBean pageBean, Class cls, String name, String value) 
* 
*/ 
@Test
public void testGetPageBySomeForPageBeanClsNameValue() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPageBySome(PageBean pageBean, Class cls, Map<String,String> map) 
* 
*/ 
@Test
public void testGetPageBySomeForPageBeanClsMap() throws Exception { 
//TODO: Test goes here...
    Date endDate = new Date();
    java.sql.Date date = new java.sql.Date(endDate.getTime());
    PageBean pageBean = new PageBean();
    pageBean=DBUtils.getPageByBeforSome(pageBean,Record.class,"date",date.toString());
    System.out.println(pageBean.getPageData().toString());
} 

/** 
* 
* Method: getListBySome(Class cl, Map<String,String> map) 
* 
*/ 
@Test
public void testGetListBySomeForClMap() throws Exception { 
//TODO: Test goes here...

    Map<String,String> map = new TreeMap<>();

    map.put("department",1+"");
    map.put("isWork",1+"");
    LinkedList listBySome = DBUtils.getListBySome(Staff.class, map);
    System.out.println(listBySome.toString());

} 


/** 
* 
* Method: close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) 
* 
*/ 
@Test
public void testClose() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = DBUtils.getClass().getMethod("close", Connection.class, PreparedStatement.class, ResultSet.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
