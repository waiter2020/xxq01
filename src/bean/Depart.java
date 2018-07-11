package bean;


/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:46 18-7-9
 * 部门实体类
 */
public class Depart {
    private int id;
    private String departname;

    public Depart(){}

    public Depart(int id,String departname) {
        this.id = id;
        this.departname = departname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname;
    }


    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", departname='" + departname + '\'' +
                '}';
    }
}
