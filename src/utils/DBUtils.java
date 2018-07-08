package utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by  waiter on 18-7-6  14.
 *
 * @author waiter
 */
public class DBUtils {
    private static final Logger loger = Logger.getLogger(JDBCPool.class.getName());

    /**
     * 私有构造，禁止实例化
     */
    private DBUtils(){}
    /**
     * 执行sql，成功返回true，失败返回false
     *
     * @param sql
     * @param params 可选的可变参数，可以省略，若有则按顺序加入到sql中的？占位符
     * @return
     */
    public static boolean executeSQL(String sql, String... params) {
        boolean flag = false;
        Connection connection = JDBCPool.getConnection();
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement(sql);
            for (int i = 0, n = params.length; i < n; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.execute();
            flag = true;
        } catch (Exception e) {
            loger.log(Level.ALL,"sql出错");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                DBUtils.close(connection,statement,null);
            }
        }
        return flag;
    }

    public ResultSet executeQuerySQL(String sql, String... params){
        Connection connection =  JDBCPool.getConnection();
        PreparedStatement statement = null;
        ResultSet set=null;
        try {
            statement = connection.prepareStatement(sql);
            for (int i = 0, n = params.length; i < n; i++) {
                statement.setString(i + 1, params[i]);
            }
            set=statement.executeQuery(sql);

        } catch (Exception e) {
            loger.log(Level.ALL,"sql出错");
            e.printStackTrace();
        } finally {


                DBUtils.close(connection,statement,null);


        }
        return set;
    }

    public static LinkedList getList(Class cls)
    {
        LinkedList list=new LinkedList();
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

//要求:数据表中的字段必须与类中的属性一一对应
        //获取类中的所有的属性
        Field[] fi=cls.getDeclaredFields();
        //获取类名(类名必须与数据表一致)
        String sql="select * from "+cls.getSimpleName();
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next())
            {
                //创建指定类的实例化对象
                Object obj=cls.newInstance();
                for(Field f:fi)
                {
                    //表示可以访问类中的私有属性
                    f.setAccessible(true);
                    //调用类中指定属性的set方法赋值
                    f.set(obj, rs.getObject(f.getName()));
                }
                list.add(obj);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,rs);
        }
        return list;
    }

    /**
     * 根据数据表中的主键获取到指定数据表对应的一条记录(对应一个对象)
     */

    public static Object getObjectById(Class cl,int id)
    {
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Object obj=null;
        //获取类中的所有的属性
        Field[] fi=cl.getDeclaredFields();
        //fi[0].getName()获取数据表中第一列字段
        String sql="select * from "+cl.getSimpleName()+" where "+fi[0].getName()+" = "+id;
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                //创建指定类的实例化对象
                obj=cl.newInstance();
                for(Field f:fi)
                {
                    //表示可以访问类中的私有属性
                    f.setAccessible(true);
                    //调用类中指定属性的set方法赋值
                    f.set(obj, rs.getObject(f.getName()));
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,rs);
        }
        return obj;
    }

    /**
     * 根据数据表中的一个字段和对应的值查询
     */
    public static LinkedList getListBySome(Class cl,String name,Object value)
    {


        LinkedList list=new LinkedList();
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //获取类中的所有的属性
        Field[] fi=cl.getDeclaredFields();
        String sql="select * from "+cl.getSimpleName()+" where "+name+" = '"+value+"'";
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Object obj=cl.newInstance();
                for(Field f:fi)
                {
                    //表示可以访问类中的私有属性
                    f.setAccessible(true);
                    //调用类中指定属性的set方法赋值
                    f.set(obj, rs.getObject(f.getName()));
                }
                list.add(obj);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,rs);
        }
        return list;
    }
    /**
     * 编写万能的DAO添加方法
     */

    public static boolean insert(Object obj)
    {
        boolean flag=false;
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        Class clz=obj.getClass();
        //获取类中的所有的属性
        Field[] fi=clz.getDeclaredFields();
        StringBuilder sb=new StringBuilder();
        sb.append("insert into ");
        sb.append(clz.getSimpleName());
        sb.append("(");
//主键为第一列，是自增的，有默认值，不需要添加
        for(int i=1;i<fi.length;i++)
        {
            //获取列名
            sb.append(fi[i].getName());
            //最后一列不用加逗号
            if(i!=fi.length-1) {
                sb.append(",");
            }
        }
        sb.append(") values(");
        for(int i=1;i<fi.length;i++)
        {
            sb.append("?");
            //最后一列不用加逗号
            if(i!=fi.length-1) {
                sb.append(",");
            }
        }
        sb.append(")");
        String sql=sb.toString();
        System.out.println(sql);
        try {
            pstmt=conn.prepareStatement(sql);
            for(int i=1;i<fi.length;i++)
            {
                fi[i].setAccessible(true);
                //第一列为主键，不用添加(对应数组下标是0)
                pstmt.setObject(i,fi[i].get(obj));
            }
            int row=pstmt.executeUpdate();
            if(row>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,null);
        }
        return flag;
    }
    /**
     * 万能的更新方法
     */

    public static boolean update(Object obj){
        boolean flag=false;
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        Class clz=obj.getClass();
        //获取类中的所有的属性
        Field[] fi=clz.getDeclaredFields();
        StringBuilder sb=new StringBuilder();
        sb.append("update ");
        sb.append(clz.getSimpleName());
        sb.append(" set ");
        for(int i=1;i<fi.length;i++)
        {
            //获取列名
            sb.append(fi[i].getName());
            sb.append(" =? ");
            //最后一列不用加逗号
            if(i!=fi.length-1) {
                sb.append(",");
            }
        }
        sb.append(" where ");
        sb.append(fi[0].getName());
        sb.append(" =? ");
        try{
            pstmt=conn.prepareStatement(sb.toString());
            for(int i=1;i<fi.length;i++)
            {
                fi[i].setAccessible(true);
                pstmt.setObject(i,fi[i].get(obj));
            }
            fi[0].setAccessible(true);
            //主键是第一列
            pstmt.setObject(fi.length, fi[0].get(obj));
            int row=pstmt.executeUpdate();
            if(row>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,null);
        }
        return flag;
    }
    /**
     * 万能的删除方法
     */
    public static boolean  delete(Class clz,int id)
    {
        boolean flag=false;
        Connection conn=JDBCPool.getConnection();
        PreparedStatement pstmt=null;
        //获取类中的所有的属性
        Field[] fi=clz.getDeclaredFields();
        String sql="delete from "+clz.getSimpleName()+ " where "+fi[0].getName()+"=?";
        System.out.println(sql);
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1, id);
            int row=pstmt.executeUpdate();
            if(row>0){
                flag=true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.close(conn, pstmt,null);
        }
        return flag;
    }

    private static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try {

            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }catch (Exception e){
            loger.warning("关闭连接异常");
            e.printStackTrace();
        }


        if(connection!=null) {
            JDBCPool.close(connection);
        }
    }
}























