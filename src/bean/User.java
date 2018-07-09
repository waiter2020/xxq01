package bean;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */
public class User {
    private int id;
    private String userName;
    private String passWd;


    public User() {
    }

    public User(int id, String userName, String passWd) {
        this.id = id;
        this.userName = userName;
        this.passWd = passWd;
    }

    public User(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWd='" + passWd + '\'' +
                '}';
    }
}
