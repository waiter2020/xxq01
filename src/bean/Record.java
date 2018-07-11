package bean;

import utils.annotation.Column;
import utils.annotation.DateType;

import java.util.Date;

/**
 * Created by  waiter on 18-7-11  上午11:22.
 *
 * @author waiter
 */
public class Record {
    private int id;
    private String userName;
    @Column(name = "staffname")
    private String staffName;
    private int mark;
    private String source;
    private String result;
    @DateType
    private Date date;

    public Record(){}

    public Record(String userName, String staffName, int mark, String source, String result, Date date) {
        this.userName = userName;
        this.staffName = staffName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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
                ", userName='" + userName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", mark=" + mark +
                ", source='" + source + '\'' +
                ", result='" + result + '\'' +
                ", date=" + date +
                '}';
    }
}
