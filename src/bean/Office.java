package bean;

import utils.annotation.DateType;
import utils.annotation.ManyToOne;

import java.util.Date;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午4:20 18-7-11
 * 工作记录表
 */
public class Office {
    private int id;
    /**
     * 员工
     */
    @ManyToOne(bean = Staff.class)
    private Staff staff;
    /**
     * 日期
     *
     */
    @DateType
    private Date date;
    /**
     * 工作状态
     */
    private int state;

    public Office(){}

    public Office(int id,Staff staff, Date date, int state) {
        this.id = id;
        this.date = new Date(date.getTime());
        this.state = state;
        this.staff=staff;
    }

    public Office(Staff staff, Date date, int state) {
        this.staff = staff;
        this.date = new Date(date.getTime());
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
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
                ", staff=" + staff +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
