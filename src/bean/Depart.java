package bean;


import utils.annotation.Column;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:46 18-7-9
 * 部门实体类
 */
public class Depart {
    private int id;
    @Column(name = "departname")
    private String departName;

    public Depart(){}

    public Depart(int id,String departName) {
        this.id = id;
        this.departName = departName;
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
                ", departname='" + departName + '\'' +
                '}';
    }
}
