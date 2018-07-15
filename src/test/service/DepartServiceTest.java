package test.service; 

import bean.Depart;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import service.DepartService;
import utils.DBUtils;

/** 
* DepartService Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 12, 2018</pre> 
* @version 1.0 
*/ 
public class DepartServiceTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findByName(String departname) 
* 
*/ 
@Test
public void testFindByName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: departInsert(Depart depart) 
* 
*/ 
@Test
public void testDepartInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteByName(String departname) 
* 
*/ 
@Test
public void testDeleteByName() throws Exception { 
//TODO: Test goes here...
    DBUtils.insert(new Depart("vsjvnfj"));
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
* Method: getDepartService() 
* 
*/ 
@Test
public void testGetDepartService() throws Exception { 
//TODO: Test goes here... 
} 


} 
