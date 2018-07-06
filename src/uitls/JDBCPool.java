package uitls;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
public class JDBCPool {
    /**
     * 连接池
     */
    private static final LinkedList<Connection> connections=new LinkedList<>();
    private static final Logger loger = Logger.getLogger(JDBCPool.class.getName());
    /**
     * 获取配置信息
     */
    private static final Properties props = JDBCUtils.getProps();
    /**
     * 连接超时时间
     */
    private static long active=Long.parseLong(props.getProperty("activeTime"))+System.currentTimeMillis();
    static{
        String initialSize = props.getProperty("initialSize");
        int i=new Integer(initialSize);
        loger.info("初始化连接数"+i);
        while (i>0){
            try {
                /**
                 * 初始化连接
                 */
                connections.add(JDBCUtils.getConnection());
                i--;
            } catch (SQLException e) {
                loger.log(Level.ALL,"数据库连接异常，请检查配置文件");
                e.printStackTrace();
            }
        }
    }

    /**
     * 私有构造，禁止实例化
     */
    private JDBCPool(){}

    /**
     * 获取当前连接数
     * @return
     */
    public static int getTotalConnection(){
        return connections.size();
    }

    /**
     * 获取一个连接
     * @return
     */
    public static synchronized Connection getConnection(){
        if(System.currentTimeMillis()>active){
            reload();
        }
        if(connections.size()==0){
        addConnection();
        }
        return connections.remove(0);
    }

    /**
     * 当连接池没有连接时新建连接
     */
    private static void addConnection(){
        String minIdle = props.getProperty("minIdle");
        int i = new Integer(minIdle);
        while (i>=0){
            try {
                connections.add(JDBCUtils.getConnection());
                i--;
            } catch (SQLException e) {
                loger.log(Level.ALL,"未知错误，添加连接出错");
                e.printStackTrace();
            }
        }
    }

    /**
     * 刷新数据库连接，防止连接超时被错误获取
     */
    private static void reload(){
        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                loger.info("正常操作");
                e.printStackTrace();
            }
        }
        int i = Integer.parseInt(props.getProperty("initialSize"));
        while (i>0){
            try {
                connections.add(JDBCUtils.getConnection());
                i--;
            } catch (SQLException e) {
                loger.log(Level.ALL,"刷新数据连接池异常");
                e.printStackTrace();
            }
        }
        active=Long.parseLong(props.getProperty("activeTime"))+System.currentTimeMillis();
    }

    /**
     * 回收连接
     * @param connection
     */
    public static void close(Connection connection){
        String maxSize = props.getProperty("maxSize");
        int i = new Integer(maxSize);
        if(connections.size()>=i){
            try {
                connection.close();
            } catch (SQLException e) {
                loger.log(Level.ALL,"连接关闭异常");
                e.printStackTrace();
            }
        }else {
            connections.add(connection);
        }
    }
}
