package bean;

import utils.annotation.Column;
import utils.annotation.ManyToOne;
import utils.annotation.OneToOne;

/**
 * Created by  waiter on 18-7-9  下午9:02.
 *
 * @author waiter
 * 员工类
 */
public class Staff {
    /**
     * 员工id
     */
    private int id;
    /**
     * 员工工号
     */
    private String userName;
    /**
     * 员工名
     */
    private String staffName;
    /**
     * 所属部门
     */
    @ManyToOne(bean = Depart.class)
    @Column(name = "department")
    private Depart departMent;
    /**
     * 所属岗位
     */
    @ManyToOne(bean = Station.class)
    private Station station;
    /**
     * 联系电话
     */
    @Column(name = "phoneNum")
    private String phoneNum;
    /**
     * 年龄
     */
    private int age;
    /**
     * 身份证号
     */
    @Column(name = "idcard")
    private String idCard;
    /**
     * 工作状态
     */
    @Column(name = "iswork")
    private boolean isWork;
    /**
     * 工资
     */
    @Column(name = "wages")
    private int wAges;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 住址
     */
    private String address;

    /**
     * 性别
     */
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Depart getDepartMent() {
        return departMent;
    }

    public void setDepartMent(Depart departMent) {
        this.departMent = departMent;
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
