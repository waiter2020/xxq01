package bean;

import utils.annotation.Column;
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
    @ManyToOne(bean = Station.class)
    @Column(name = "src_station")
    private Station srcStation;
    /**
     * 新岗位
     */
    @ManyToOne(bean = Station.class)
    @Column(name = "res_station")
    private Station resStation;
    /**
     * 原部门
     */
    @ManyToOne(bean = Depart.class)
    @Column(name = "src_depart")
    private Depart srcDepart;
    /**
     * 新部门
     */
    @ManyToOne(bean = Depart.class)
    @Column(name = "res_depart")
    private Depart resDepart;

    /**
     * 变动日期
     */
    @DateType
    private Date date;

    public Record(){}
    public Record(Staff byId, String mark, String stationName, String result, Date date){}

    public Record(Staff staff, int mark, Station srcStation, Station resStation, Depart srcDepart, Depart resDepart, Date date) {
        this.staff = staff;
        this.mark = mark;
        this.srcStation = srcStation;
        this.resStation = resStation;
        this.srcDepart = srcDepart;
        this.resDepart = resDepart;
        this.date = date;
    }

    public Record(int mark, Date date) {
        this.mark = mark;

        this.date = date;
    }

    public Record(Staff staff, int mark, Date date) {
        this.staff=staff;
        this.mark = mark;
        this.date = date;
    }

    public Station getSrcStation() {
        return srcStation;
    }

    public void setSrcStation(Station srcStation) {
        this.srcStation = srcStation;
    }

    public Station getResStation() {
        return resStation;
    }

    public void setResStation(Station resStation) {
        this.resStation = resStation;
    }

    public Depart getSrcDepart() {
        return srcDepart;
    }

    public void setSrcDepart(Depart srcDepart) {
        this.srcDepart = srcDepart;
    }

    public Depart getResDepart() {
        return resDepart;
    }

    public void setResDepart(Depart resDepart) {
        this.resDepart = resDepart;
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

                ", date=" + date +
                '}';
    }
}
