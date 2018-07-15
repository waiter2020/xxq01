package test.utils; 

import bean.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import utils.BCrypt;
import utils.DBUtils;

import java.util.LinkedList;

/** 
* BCrypt Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 8, 2018</pre> 
* @version 1.0 
*/ 
public class BCryptTest { 

@Before
public void before() throws Exception {

}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: crypt_raw(byte password[], byte salt[], int log_rounds, int cdata[]) 
* 
*/ 
@Test
public void testCrypt_raw() throws Exception { 
//TODO: Test goes here...
    LinkedList list = DBUtils.getList(User.class);
    for (Object l:list){
        User user= (User) l;
        user.setPassWd(BCrypt.hashpw(user.getPassWd(),BCrypt.gensalt(10)));
        DBUtils.update(user);
    }
} 

/** 
* 
* Method: hashpw(String password, String salt) 
* 
*/ 
@Test
public void testHashpw() throws Exception { 
//TODO: Test goes here...
    String s="abcde";
    s=BCrypt.hashpw(s,BCrypt.gensalt(10));
    System.out.println(s);
} 

/** 
* 
* Method: gensalt(int log_rounds, SecureRandom random) 
* 
*/ 
@Test
public void testGensaltForLog_roundsRandom() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: gensalt(int log_rounds) 
* 
*/ 
@Test
public void testGensaltLog_rounds() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: gensalt() 
* 
*/ 
@Test
public void testGensalt() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: checkpw(String plaintext, String hashed) 
* 
*/ 
@Test
public void testCheckpw() throws Exception { 
//TODO: Test goes here...
    Boolean b=BCrypt.checkpw("abcde","$2a$10$7Nd5fHDE2RA1ouoAkvzcue4H6dGikJMX1ATU7KZBK4xK8xtsJYhGq");
    System.out.println(b);
}


/** 
* 
* Method: encode_base64(byte d[], int len) 
* 
*/ 
@Test
public void testEncode_base64() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("encode_base64", byte.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: char64(char x) 
* 
*/ 
@Test
public void testChar64() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("char64", char.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: decode_base64(String s, int maxolen) 
* 
*/ 
@Test
public void testDecode_base64() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("decode_base64", String.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: encipher(int lr[], int off) 
* 
*/ 
@Test
public void testEncipher() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("encipher", int.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: streamtoword(byte data[], int offp[]) 
* 
*/ 
@Test
public void testStreamtoword() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("streamtoword", byte.class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: init_key() 
* 
*/ 
@Test
public void testInit_key() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("init_key"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: key(byte key[]) 
* 
*/ 
@Test
public void testKey() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("key", byte.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: ekskey(byte data[], byte key[]) 
* 
*/ 
@Test
public void testEkskey() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BCrypt.getClass().getMethod("ekskey", byte.class, byte.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
