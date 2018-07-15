package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-15
 */
public class Age {
    private int departId;//部门id
    private int avgAge;//部门平均年龄

    public Age(){}

    public Age(int departId, int avgAge) {
        this.departId = departId;
        this.avgAge = avgAge;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(int avgAge) {
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "Age{" +
                "departId=" + departId +
                ", avgAge=" + avgAge +
                '}';
    }
}
