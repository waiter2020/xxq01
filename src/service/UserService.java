package service;

import bean.User;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
public class UserService {
    private static final UserService userService=new UserService();
    private UserService(){}

    public User findByUserName(String userName){
        return new User("123456","123456");
    }

    public static UserService getUserService(){
        return userService;
    }
}
