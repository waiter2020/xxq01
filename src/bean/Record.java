package bean;

import utils.annotation.DateType;
import utils.annotation.ManyToOne;

import java.util.Date;

/**
 * Created by  waiter on 18-7-11  上午11:22.
 *
 * @author waiter
 * 变动记录表
 */
public class Record {
    private int id;
    /**
     * 变动员工
     */
    @ManyToOne(bean = Staff.class)
    private Staff staff;
    /**
     * 变动类型
     */
    private int mark;
    /**
     * 原岗位
     */
    private String source;
    /**
     * 变动后岗位
     */
    private String result;
    /**
     * 变动日期
     */
    @DateType
    private Date date;

    public Record(Staff byId, String mark, String stationName, String result, Date date){}

    public Record( int mark, String source, String result, Date date) {
        this.mark = mark;
        this.source = source;
        this.result = result;
        this.date = date;
    }

    public Record(Staff staff, int mark, String source, String result, Date date) {
        this.staff=staff;
        this.mark = mark;
        this.source = source;
        this.result = result;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", staff=" + staff +
                ", mark=" + mark +
                ", source='" + source + '\'' +
                ", result='" + result + '\'' +
                ", date=" + date +
                '}';
    }
}
