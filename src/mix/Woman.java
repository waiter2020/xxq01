package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-15
 */
public class Woman {
    private int departId;//部门id
    private int woman;//部门女人个数

    public Woman(){}

    public Woman(int departId, int woman) {
        this.departId = departId;
        this.woman = woman;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Woman{" +
                "departId=" + departId +
                ", woman=" + woman +
                '}';
    }
}
