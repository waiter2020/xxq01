package bean;

import utils.annotation.Column;
import utils.annotation.DateType;
import utils.annotation.ManyToOne;

import java.util.Date;

/**
 * 绩效考核类
 */
public class Performance {
    private int id;
    @DateType
    @Column(name="mouth")
    private Date month;

    private float score;
    private int present;
    @ManyToOne(bean = Staff.class)
    private Staff staff;
    public Performance(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", month=" + month +
                ", score=" + score +
                ", present=" + present +
                ", staff=" + staff +
                '}';
    }

    public Performance(Date month, float score, int present, Staff staff) {
        this.month = month;
        this.score = score;
        this.present = present;
        this.staff = staff;
    }
}