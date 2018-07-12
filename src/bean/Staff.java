package bean;

import utils.annotation.Column;
import utils.annotation.ManyToOne;
import utils.annotation.OneToOne;

/**
 * Created by  waiter on 18-7-9  下午9:02.
 *
 * @author waiter
 */
public class Staff {
    private int id;
    private String userName;
    private String staffName;
    @ManyToOne(bean = Depart.class)
    @Column(name = "department")
    private Depart departMent;
    @ManyToOne(bean = Station.class)
    private Station station;
    @Column(name = "phoneNum")
    private String phoneNum;
    private int age;
    @Column(name = "idcard")
    private String idCard;
    @Column(name = "iswork")
    private boolean isWork;
    @Column(name = "wages")
    private int wAges;


    private int sex;
    public Staff(){}

    public Staff(String userName, String staffName, Depart departMent, Station station, String phoneNum, int age, String idCard, boolean isWork, int wAges) {
        this.userName = userName;
        this.staffName = staffName;
        this.departMent = departMent;
        this.station = station;
        this.phoneNum = phoneNum;
        this.age = age;
        this.idCard = idCard;
        this.isWork = isWork;
        this.wAges = wAges;
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

    public Depart getDepartment() {
        return departMent;
    }

    public void setDepartment(Depart department) {
        this.departMent = department;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean getIsWork() {
        return isWork;
    }

    public void setIsWork(boolean isWork) {
        this.isWork = isWork;
    }

    public int getwAges() {
        return wAges;
    }

    public void setwAges(int wAges) {
        this.wAges = wAges;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", staffName='" + staffName + '\'' +
                ", departMent=" + departMent +
                ", station=" + station +
                ", phoneNum='" + phoneNum + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                ", isWork=" + isWork +
                ", wAges=" + wAges +
                ", sex=" + sex +
                '}';
    }
}
