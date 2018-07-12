package bean;

import utils.annotation.Column;
import utils.annotation.DateType;
import utils.annotation.ManyToOne;

import java.util.Date;

/**
 * Created by  waiter on 18-7-11  上午11:22.
 *
 * @author waiter
 */
public class Record {
    private int id;
    @ManyToOne(bean = Staff.class)
    private Staff staff;
    private int mark;
    private String source;
    private String result;
    @DateType
    private Date date;

    public Record(){}

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
