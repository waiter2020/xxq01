package utils;

import bean.Report;
import utils.annotation.Column;
import utils.annotation.Count;
import utils.annotation.ManyToOne;
import utils.annotation.OneToOne;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by  waiter on 18-7-6  14.
 *
 * @author waiter
 * JDBC底层封装方法大全
 */
public class DBUtils {
    private static final Logger loger = Logger.getLogger(JDBCPool.class.getName());

    /**
     * 私有构造，禁止实例化
     */
    private DBUtils() {
    }

    /**
     * 执行sql，
     *
     * @param sql
     * @param params 可选的可变参数，可以省略，若有则按顺序加入到sql中的？占位符
     * @return 成功返回true，失败返回false
     */
    public static boolean executeSQL(String sql, String... params) {
        boolean flag = false;
        //获取连接
        Connection connection = JDBCPool.getConnection();
        PreparedStatement statement = null;
        try {
            //预编译
            statement = connection.prepareStatement(sql);
            for (int i = 0, n = params.length; i < n; i++) {
                //添加参数
                statement.setString(i + 1, params[i]);
            }
            //执行
            statement.execute();
            flag = true;
        } catch (Exception e) {
            loger.log(Level.ALL, "sql出错");
            e.printStackTrace();
        } finally {
            //放回连接
            DBUtils.close(connection, statement, null);
        }
        return flag;
    }

    /**
     * 执行查询sql
     *
     * @param sql
     * @param params 可选的可变参数，可以省略，若有则按顺序加入到sql中的？占位符
     * @return 返回结果集
     */
    public static ResultSet executeQuerySQL(String sql, String... params) {
        //获取连接
        Connection connection = JDBCPool.getConnection();
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            //预编译
            statement = connection.prepareStatement(sql);
            for (int i = 0, n = params.length; i < n; i++) {
                //设置参数
                statement.setString(i + 1, params[i]);
            }
            //执行查询
            set = statement.executeQuery();

        } catch (Exception e) {
            loger.log(Level.ALL, "sql出错");
            e.printStackTrace();
        } finally {
            //放回连接
            DBUtils.close(connection, null, null);
        }
        return set;
    }

    /**
     * 通过实体类的字节码文件获取对应的数据库表中的数据
     *
     * @param cls 字节码文件，例如User.class
     * @return 对应的实体类的 LinkList
     */
    public static LinkedList getList(Class cls) {
        LinkedList list = null;
        ResultSet rs = null;
        //要求:数据表中的字段必须与类中的属性一一对应，或者在属性上添加@Column注解，指定字段
        //获取类名(类名必须与数据表一致)
        String sql = "select * from " + cls.getSimpleName();
        try {
            //执行查询
            rs = executeQuerySQL(sql);
            //反射注入封装
            list = BeanUtils.rsToBeanList(cls, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭结果集
            DBUtils.close(null, null, rs);
        }
        return list;
    }


    /**
     * 根据数据表中的主键获取到指定数据表对应的一条记录(对应一个对象)
     *
     * @param cl 实体类字节码文件
     * @param id id主键值
     * @return 返回实体类对象
     */

    public static Object getObjectById(Class cl, int id) {
        ResultSet rs = null;
        Object obj = null;
        //获取类中的所有的属性
        Field[] fi = cl.getDeclaredFields();
        //获取第一个属性，默认认为此属性为主键
        String name = fi[0].getName();
        //获取注解
        Column annotation = fi[0].getAnnotation(Column.class);
        //判断此属性上是否有该注解
        if (annotation != null) {
            //更改字段名
            name = annotation.name();
        }
        //fi[0].getName()获取数据表中第一列字段
        String sql = "select * from " + cl.getSimpleName() + " where " + name + " = ?";
        try {
            //执行查询
            rs = executeQuerySQL(sql, String.valueOf(id));
            //封装数据
            obj = BeanUtils.rsToBean(cl, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭结果集
            DBUtils.close(null, null, rs);
        }
        return obj;
    }

    /**
     * 根据数据表中的一个字段和对应的值查询
     *
     * @param cl    实体类字节码文件
     * @param name  字段名
     * @param value 字段值
     * @return 返回符合条件的实体类对象链表
     */
    public static LinkedList getListBySome(Class cl, String name, String value) {


        LinkedList list = null;
        ResultSet rs = null;

        String sql = "select * from " + cl.getSimpleName() + " where " + name + " = ?";
        try {
            //执行查询
            rs = executeQuerySQL(sql, value);
            //封装数据
            list = BeanUtils.rsToBeanList(cl, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭结果集
            DBUtils.close(null, null, rs);
        }
        return list;
    }


    /**
     * 插入一行数据
     *
     * @param obj 对应的实体类对象 该实体类主键id应为自增，并且定义为第一个属性
     * @return true或者false，对应成功或失败
     */
    public static boolean insert(Object obj) {
        int k = 0;
        boolean flag = false;
        //获取连接
        Connection conn = JDBCPool.getConnection();
        PreparedStatement pstmt = null;
        //获取字节码
        Class clz = obj.getClass();
        //获取类中的所有的属性
        Field[] fi = clz.getDeclaredFields();
        String sb;
        sb = "insert into " + clz.getSimpleName() + "(";
        //主键为第一列，是自增的，有默认值，不需要添加
        for (int i = 1; i < fi.length; i++) {
            //获取列名
            String name = fi[i].getName();
            //获取注解
            Column annotation = fi[i].getAnnotation(Column.class);
            Count annotation2 = fi[i].getAnnotation(Count.class);
            if (annotation2 != null) {
                k++;
                continue;
            }
            //判断
            if (annotation != null) {
                //更改列名
                name = annotation.name();
            }
            sb += name + ",";

        }
        sb = sb.substring(0, sb.length() - 1);
        sb += ") values(";
        for (int i = 1; i < fi.length - k; i++) {
            sb += "?";
            //最后一列不用加逗号
            if (i != fi.length - 1 - k) {
                sb += ",";
            }
        }
        //sb = sb.substring(0, sb.length() - 2);
        sb += ")";

        System.out.println(sb);
        try {
            //预编译
            pstmt = conn.prepareStatement(sb);
            for (int i = 1; i < fi.length; i++) {
                //设置属性可读写
                fi[i].setAccessible(true);
                //获取注解
                OneToOne annotation1 = fi[i].getAnnotation(OneToOne.class);
                ManyToOne annotation = fi[i].getAnnotation(ManyToOne.class);
                Count annotation2 = fi[i].getAnnotation(Count.class);
                if (annotation2 != null) {
                    continue;
                }
                //第一列为主键，不用添加(对应数组下标是0)
                if (annotation != null) {
                    //获取此属性值
                    Object o = fi[i].get(obj);
                    if (o != null) {
                        //获取属性列表
                        Field[] declaredFields = o.getClass().getDeclaredFields();
                        //设置第一个属性可访问
                        declaredFields[0].setAccessible(true);
                        //获取主键
                        int anInt = declaredFields[0].getInt(o);
                        //update(o);
                        pstmt.setObject(i, anInt);
                    }
                } else if (annotation1 != null) {
                    //获取此属性值
                    Object o = fi[i].get(obj);
                    if (o != null) {
                        //获取属性列表
                        Field[] declaredFields = o.getClass().getDeclaredFields();
                        //设置第一个属性可访问
                        declaredFields[0].setAccessible(true);
                        //获取主键
                        int anInt = declaredFields[0].getInt(o);
                        insert(o);
                        pstmt.setObject(i, anInt);
                    }
                } else {
                    pstmt.setObject(i, fi[i].get(obj));
                }
            }
            int row = pstmt.executeUpdate();
            if (row > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pstmt, null);
        }
        return flag;
    }

    /**
     * 万能的更新方法
     *
     * @param obj 对应的实体类对象
     */
    public static boolean update(Object obj) {
        int k = 0;
        boolean flag = false;
        Connection conn = JDBCPool.getConnection();
        PreparedStatement pstmt = null;
        Class clz = obj.getClass();
        //获取类中的所有的属性
        Field[] fi = clz.getDeclaredFields();
        String sb;
        sb = "update " + clz.getSimpleName() + " set ";
        for (int i = 1; i < fi.length; i++) {
            //获取列名
            String name = fi[i].getName();
            Column annotation = fi[i].getAnnotation(Column.class);
            Count annotation2 = fi[i].getAnnotation(Count.class);
            if (annotation2 != null) {
                k++;
                continue;
            }
            if (annotation != null) {
                name = annotation.name();
            }
            sb += name + " = ?  ,";
        }
        sb = sb.substring(0, sb.length() - 2);
        sb += " where " + fi[0].getName() + " =? ";
        try {
            pstmt = conn.prepareStatement(sb.toString());
            for (int i = 1; i < fi.length; i++) {
                fi[i].setAccessible(true);
                OneToOne annotation1 = fi[i].getAnnotation(OneToOne.class);
                ManyToOne annotation = fi[i].getAnnotation(ManyToOne.class);
                Count annotation2 = fi[i].getAnnotation(Count.class);
                if (annotation2 != null) {
                    continue;
                }
                //第一列为主键，不用添加(对应数组下标是0)
                if (annotation != null) {
                    Object o = fi[i].get(obj);
                    if (o != null) {
                        Field[] declaredFields = o.getClass().getDeclaredFields();
                        declaredFields[0].setAccessible(true);
                        int anInt = declaredFields[0].getInt(o);
                        //update(o);
                        pstmt.setObject(i, anInt);
                    }
                } else if (annotation1 != null) {
                    Object o = fi[i].get(obj);
                    if (o != null) {
                        Field[] declaredFields = o.getClass().getDeclaredFields();
                        declaredFields[0].setAccessible(true);
                        int anInt = declaredFields[0].getInt(o);
                        update(o);
                        pstmt.setObject(i, anInt);
                    }
                } else {
                    pstmt.setObject(i, fi[i].get(obj));
                }
            }
            fi[0].setAccessible(true);
            //主键是第一列

            pstmt.setObject(fi.length - k, fi[0].get(obj));
            int row = pstmt.executeUpdate();
            if (row > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pstmt, null);
        }
        return flag;
    }

    /**
     * 万能的删除方法，通过id删除数据
     *
     * @param clz 实体类字节码文件
     * @param id  id
     * @return
     */
    public static boolean delete(Class clz, int id) {
        boolean flag = false;
        Connection conn = JDBCPool.getConnection();
        PreparedStatement pstmt = null;
        //获取类中的所有的属性
        Field[] fi = clz.getDeclaredFields();

        for (Field f : fi) {
            OneToOne annotation = f.getAnnotation(OneToOne.class);
            if (annotation != null) {
                f.setAccessible(true);
                Object objectById = getObjectById(clz, id);
                if (objectById != null) {
                    try {
                        Object o = f.get(objectById);
                        if (o != null) {
                            Field[] declaredFields = o.getClass().getDeclaredFields();
                            declaredFields[0].setAccessible(true);
                            int anInt = declaredFields[0].getInt(o);
                            delete(o.getClass(), anInt);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        String sql = "delete from " + clz.getSimpleName() + " where " + fi[0].getName() + "=?";
        System.out.println(sql);
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, id);
            int row = pstmt.executeUpdate();
            if (row > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pstmt, null);
        }
        return flag;
    }

    private static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {

            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            loger.warning("关闭连接异常");
            e.printStackTrace();
        }


        if (connection != null) {
            JDBCPool.close(connection);
        }
    }

    /**
     * 统计总行数
     *
     * @param cls 实体类字节码文件
     * @return 总数
     */
    public static int getObjectCount(Class cls) {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCPool.getConnection();
        ResultSet rs = null;
        String sql = "select count(*) from " + cls.getSimpleName();
        try {
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            rs.next();
            int i = rs.getInt(1);
            return i;
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            close(connection, preparedStatement, rs);

        }
    }

    /**
     * 分页查询功能
     *
     * @param pageBean 工具类中的PageBean对象
     * @param cls      实体类字节码文件
     * @return PageBean对象
     */
    public static PageBean getPage(PageBean pageBean, Class cls) {
        pageBean.setTotalCount(getObjectCount(cls));
        pageBean.getPageData().clear();
        ResultSet rs = null;
        String sql = "select * from " + cls.getSimpleName() + " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();
        try {
            rs = executeQuerySQL(sql);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, rs));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, rs);

        }

        return pageBean;
    }

    /**
     * 分页查询功能，通过某一字段的值筛选分页
     *
     * @param pageBean 工具类中的PageBean对象
     * @param cls      实体类字节码文件
     * @param name
     * @param value
     * @return
     */
    public static PageBean getPageBySome(PageBean pageBean, Class cls, String name, String value) {
        Map<String, String> map = new TreeMap<>();
        map.put(name, value);
        pageBean.setTotalCount(getObjectCount(cls, map));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " = ?" + " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();
        ;
        try {
            set = executeQuerySQL(sql, value);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;
    }

    /**
     * 分页查询功能加强版，实现多条件筛选
     *
     * @param pageBean
     * @param cls
     * @param map      map参数中key对应字段名，value对应字段值
     * @return
     */
    public static PageBean getPageBySome(PageBean pageBean, Class cls, Map<String, String> map) {
        pageBean.setTotalCount(getObjectCount(cls, map));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where ";

        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql += entry.getKey() + " = " + entry.getValue() + " AND ";
        }
        String substring = sql.substring(0, sql.length() - 4);
        substring += " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();

        try {
            set = executeQuerySQL(substring);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;
    }

    /**
     * getList加强版，可实现多个查询条件
     *
     * @param cl
     * @param map map参数中key对应字段名，value对应字段值
     * @return
     */
    public static LinkedList getListBySome(Class cl, Map<String, String> map) {
        LinkedList list = null;
        ResultSet rs = null;


        String sql = "select * from " + cl.getSimpleName() + " where ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql += entry.getKey() + " = " + entry.getValue() + " AND ";
        }
        String substring = sql.substring(0, sql.length() - 4);
        try {
            rs = executeQuerySQL(substring);
            list = BeanUtils.rsToBeanList(cl, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null, null, rs);
        }
        return list;
    }

    /**
     * 限定条件统计总数
     *
     * @param cls
     * @param map
     * @return
     */
    public static int getObjectCount(Class cls, Map<String, String> map) {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCPool.getConnection();
        ResultSet rs = null;
        String sql = "select count(*) from " + cls.getSimpleName() + " WHERE ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql += entry.getKey() + " = " + entry.getValue() + " AND ";
        }
        String substring = sql.substring(0, sql.length() - 4);
        try {
            preparedStatement = connection.prepareStatement(substring);
            rs = preparedStatement.executeQuery();
            rs.next();
            int i = rs.getInt(1);
            return i;
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            close(connection, preparedStatement, rs);

        }
    }

    /**
     * 分页查询功能，通过查询某一字段的值比value大筛选分页
     *
     * @param pageBean 工具类中的PageBean对象
     * @param cls      实体类字节码文件
     * @param name
     * @param value
     * @return
     */
    public static PageBean getPageByAfterSome(PageBean pageBean, Class cls, String name, String value) {
        Map<String, String> map = new TreeMap<>();
        map.put(value, name);
        pageBean.setTotalCount(getObjectCount(cls, map, ">"));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " > ?" + " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();
        ;
        try {
            set = executeQuerySQL(sql, value);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;
    }

    /**
     * 分页查询功能，通过查询某一字段的值比value小筛选分页
     *
     * @param pageBean 工具类中的PageBean对象
     * @param cls      实体类字节码文件
     * @param name
     * @param value
     * @return
     */
    public static PageBean getPageByBeforSome(PageBean pageBean, Class cls, String name, String value) {
        Map<String, String> map = new TreeMap<>();
        map.put(value, name);
        pageBean.setTotalCount(getObjectCount(cls, map, "<"));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " < ?" + " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();
        ;
        try {
            set = executeQuerySQL(sql, value);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;
    }

    /**
     * 分页查询功能，通过查询某一字段的值比value小且比value大筛选分页
     *
     * @param pageBean 工具类中的PageBean对象
     * @param cls      实体类字节码文件
     * @param name
     * @param value
     * @return
     */
    public static PageBean getPageByBeforSomeAndAfterSome(PageBean pageBean, Class cls, String name, String value, String name1, String value1) {
        Map<String, String> map = new TreeMap<>();
        map.put(value, name);
        map.put(value1, name1);
        pageBean.setTotalCount(getObjectCount(cls, map, ">", "<"));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " < ? " + " AND " + name1 + " >? " + " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();
        ;
        try {
            set = executeQuerySQL(sql, value, value1);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;
    }


    /**
     * 限定条件统计总数
     *
     * @param cls
     * @param map key和value值调换了
     * @return
     */
    public static int getObjectCount(Class cls, Map<String, String> map, String... op) {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCPool.getConnection();
        ResultSet rs = null;
        int i = 0;
        String sql = "select count(*) from " + cls.getSimpleName() + " WHERE ";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql += entry.getValue() + " " + op[i++] + " " + "'" + entry.getKey() + "'" + " AND ";
        }
        String substring = sql.substring(0, sql.length() - 4);
        try {
            preparedStatement = connection.prepareStatement(substring);
            rs = preparedStatement.executeQuery();
            rs.next();
            i = rs.getInt(1);
            return i;
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
            return 0;
        } finally {
            close(connection, preparedStatement, rs);

        }
    }

    public static LinkedList getListByBeforSomeAndAfterSomeAndSome(Class cls, String name, String value, String name1, String value1, String name2, String value2) {
        ResultSet rs = null;
        LinkedList list = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " < ? " + " AND " + name1 + " >? " + " AND " + name2 + " = ? ";
        try {
            rs = executeQuerySQL(sql, value, value1, value2);
            list = BeanUtils.rsToBeanList(cls, rs);
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, rs);

        }
        return list;
    }

    public static LinkedList getListByBeforSomeAndAfterSome(Class cls, String name, String value, String name1, String value1) {
        ResultSet rs = null;
        LinkedList list = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " < ? " + " AND " + name1 + " >? ";
        try {
            rs = executeQuerySQL(sql, value, value1);
            list = BeanUtils.rsToBeanList(cls, rs);
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, rs);

        }
        return list;
    }

    public static LinkedList getListByAfterSomeAndSome(Class cls, String name, String value, String name1, String value1) {
        ResultSet rs = null;
        LinkedList list = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " > ? " + " AND " + name1 + " = ? ";
        try {
            rs = executeQuerySQL(sql, value, value1);
            list = BeanUtils.rsToBeanList(cls, rs);
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, rs);

        }
        return list;
    }


    /**
     * --------------------------------------------------------------------------------------------------
     * 以下为非通用方法
     */
    /**
     * @param pageBean
     * @param cls
     * @param name
     * @param value
     * @param name1
     * @param value1
     * @param map      map为三个键值对
     * @return
     */
    public static PageBean getPageByBeforSomeAndAfterSomeAndSome(PageBean pageBean, Class cls, String name, String value, String name1, String value1, Map<String, String> map) {
        Map<String, String> map1 = new TreeMap<>();
        map1.put(value, name);
        map1.put(value1, name1);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            map1.put(entry.getValue(), entry.getKey());
        }

        pageBean.setTotalCount(getObjectCount(cls, map1, ">", "<", "=", "=", "="));
        pageBean.getPageData().clear();
        ResultSet set = null;
        String sql = "select * from " + cls.getSimpleName() + " where " + name + " < ? " + " AND " + name1 + " >? ";

        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql += " AND " + entry.getKey() + " = " + "'" + entry.getValue() + "'";
        }
        //sql = sql.substring(0, sql.length() - 4);
        sql += " LIMIT " + (pageBean.getCurrentPage() - 1) * pageBean.getPageCount() + "," + pageBean.getPageCount();

        try {
            set = executeQuerySQL(sql, value, value1);
            pageBean.getPageData().addAll(BeanUtils.rsToBeanList(cls, set));
        } catch (Exception e) {
            loger.info(e.getMessage());
            e.printStackTrace();
        } finally {
            close(null, null, set);

        }

        return pageBean;


    }


}

























