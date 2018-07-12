package bean;

import utils.annotation.Column;
import utils.annotation.OneToOne;

/**
 * Created by  waiter on 18-7-6.
 *
 * @author waiter
 */

public class User {
    private int id;
    private String userName;
    @OneToOne(bean = Staff.class)
    private Staff staff;
    @Column(name = "passWd")
    private String pwd;
    private int grade;


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User() {
    }

    public User(int id, String userName, String passWd) {
        this.id = id;
        this.userName = userName;
        this.pwd = passWd;
    }

    public User(String userName, String passWd) {
        this.userName = userName;
        this.pwd = passWd;
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
        return pwd;
    }

    public void setPassWd(String passWd) {
        this.pwd = passWd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWd='" + pwd + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
