package test.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import service.StationService;
import utils.DBUtils;
import utils.PageBean;

/** 
* StationService Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 14, 2018</pre> 
* @version 1.0 
*/ 
public class StationServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: listPage(PageBean pageBean) 
* 
*/ 
@Test
public void testListPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: stationInsert(Station station) 
* 
*/ 
@Test
public void testStationInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByName(String stationName) 
* 
*/ 
@Test
public void testFindByName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteByName(String stationName) 
* 
*/ 
@Test
public void testDeleteByName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findById(int id) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPageByDepart(PageBean pageBean, int depart) 
* 
*/ 
@Test
public void testGetPageByDepart() throws Exception { 
//TODO: Test goes here...
    PageBean pageBean = new PageBean();
    StationService stationService = StationService.getStationService();
    PageBean pageByDepart = stationService.getPageByDepart(pageBean, 1);
} 

/** 
* 
* Method: getStationService() 
* 
*/ 
@Test
public void testGetStationService() throws Exception { 
//TODO: Test goes here... 
} 


} 
