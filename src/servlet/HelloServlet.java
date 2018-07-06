package servlet;

import bean.User;
import uitls.DBUtils;
import uitls.JDBCPool;
import uitls.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
@WebServlet(name = "HelloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    Logger logger=Logger.getLogger(this.getClass().getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User objectById = (User) DBUtils.getObjectById(User.class, 1);
        logger.info(objectById.toString());
        PrintWriter writer = resp.getWriter();
        writer.println(objectById);
        LinkedList userName = DBUtils.getListBySome(User.class, "userName", "123456");
        writer.println(userName);
        DBUtils.executeSQL("UPDATE xxq.`User` SET userName =? WHERE id =?","scdacvdv","1");
        LinkedList list = DBUtils.getList(User.class);
        writer.println(list);
        DBUtils.insert(new User("1234567","6545465"));
        objectById.setPassWd("cdscdsvf");
        DBUtils.update(objectById);
        LinkedList list1 = DBUtils.getList(User.class);
        writer.println(list1);
        DBUtils.delete(User.class,2);
        LinkedList list2 = DBUtils.getList(User.class);
        writer.println(list2);
    }
}
