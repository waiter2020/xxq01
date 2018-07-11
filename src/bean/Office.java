package bean;

import utils.annotation.Column;
import utils.annotation.DateType;

import java.util.Date;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午4:20 18-7-11
 */
public class Office {
    private int id;
    private String userName;
    private String staffname;
    @DateType
    private Date date;
    private int state;

    public Office(){}

    public Office(int id, String usernName, String staffname, Date date, int state) {
        this.id = id;
        this.userName = usernName;
        this.staffname = staffname;
        this.date = date;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernName() {
        return userName;
    }

    public void setUsernName(String usernName) {
        this.userName = usernName;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", usernName='" + userName + '\'' +
                ", staffname='" + staffname + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
