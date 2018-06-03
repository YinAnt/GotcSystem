package test.com.ant.DAOImpl; 

import com.ant.DAOImpl.ContentDAOImpl;
import junit.framework.Test;
import junit.framework.TestSuite; 
import junit.framework.TestCase; 

/** 
* ContentDAOImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>06/03/2018</pre> 
* @version 1.0 
*/ 
public class ContentDAOImplTest extends TestCase { 
public ContentDAOImplTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: doFindAllByOrdNo(Long contOrdNo) 
* 
*/ 
public void testDoFindAllByOrdNo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doFindAllWaitByOrdNo(Long contOrdNo) 
* 
*/ 
public void testDoFindAllWaitByOrdNo() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doFindAllWait() 
* 
*/ 
public void testDoFindAllWait() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doFindAllWaitForScn() 
* 
*/ 
public void testDoFindAllWaitForScn() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doFindAllWaitForHtl() 
* 
*/ 
public void testDoFindAllWaitForHtl() throws Exception { 
//TODO: Test goes here...
    ContentDAOImpl contentDAO = new ContentDAOImpl();
    contentDAO.doFindAllWaitForHtl();
} 

/** 
* 
* Method: doFindAllWaitForVhc() 
* 
*/ 
public void testDoFindAllWaitForVhc() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doChangeStateForScn(String contScnName, Long contScnDate) 
* 
*/ 
public void testDoChangeStateForScn() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doChangeStateForHtl(Content content) 
* 
*/ 
public void testDoChangeStateForHtl() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: doChangeStateForVhc(Content content) 
* 
*/ 
public void testDoChangeStateForVhc() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: showAllFinishContent() 
* 
*/ 
public void testShowAllFinishContent() throws Exception { 
//TODO: Test goes here... 
} 



public static Test suite() { 
return new TestSuite(ContentDAOImplTest.class); 
} 
} 
