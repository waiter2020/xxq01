package bean;


import utils.annotation.Column;
import utils.annotation.Count;
import utils.annotation.OneToOne;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:46 18-7-9
 * 部门实体类
 */
public class Depart {
    /**
     * 部门id
     */
    private int id;
    /**
     * 部门名
     */
    @Column(name = "departname")
    private String departName;
    /**
     * 部门描述
     */
    @Column(name = "describ")
    private String describe;

    private int staffid;
    /**
     * 部门总人数
     */
    @Count(name = "department", bean = Staff.class)
    private int count;

    public Depart() {
    }

    public Depart(String departName, String describe) {
        this.departName = departName;
        this.describe = describe;
    }

    public Depart(String departName) {
        this.departName = departName;
    }

    public Depart(int id, String departName) {
        this.id = id;
        this.departName = departName;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }


    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", departName='" + departName + '\'' +
                ", count=" + count +
                '}';
    }
}
