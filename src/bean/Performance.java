package bean;

import utils.annotation.Column;
import utils.annotation.DateType;
import utils.annotation.ManyToOne;

import java.util.Comparator;
import java.util.Date;

/**
 * 绩效考核类
 */
public class Performance implements Comparable<Performance> {
    private int id;
    @DateType
    @Column(name = "mouth")
    private Date month;

    private float score;
    private int present;
    @ManyToOne(bean = Staff.class)
    private Staff staff;

    public Performance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMonth() {
        return new Date(month.getTime());
    }

    public void setMonth(Date month) {
        this.month = new Date(month.getTime());
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
        this.month = new Date(month.getTime());
        this.score = score;
        this.present = present;
        this.staff = staff;
    }


    @Override
    public int compareTo(Performance s) {
        //自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
        if (this.score <= s.score) {
            return 1;
        }
        return -1;
    }

//    class ComparatorPerformance implements Comparator {
//
//        @Override
//        public int compare(Object arg0, Object arg1) {
//            Performance performance = (Performance) arg0;
//            Performance performance1 = (Performance) arg1;
//            //首先比较年龄，如果年龄相同，则比较名字
//
//            int flag = performance.getScore().compareTo();
//            if (flag == 0) {
//                return user0.getName().compareTo(user1.getName());
//            } else {
//                return flag;
//            }
//        }
}