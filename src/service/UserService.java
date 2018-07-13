package service;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
public class UserService {
    private final UserDao userDao = UserDaoImpl.getUserDaoImpl();
    private static final UserService userService=new UserService();
    private UserService(){}



    public User findByUserName(String userName){

        return userDao.findByUserName(userName);
    }

    public boolean save(User user){
        return userDao.save(user);
    }

    public static UserService getUserService(){
        return userService;
    }
}
