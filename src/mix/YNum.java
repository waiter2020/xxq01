package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-15
 */
public class YNum {
    private int departId;//部门id
    private int yNum;//部门正式员工数

    public YNum(){}

    public YNum(int departId, int yNum) {
        this.departId = departId;
        this.yNum = yNum;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getyNum() {
        return yNum;
    }

    public void setyNum(int yNum) {
        this.yNum = yNum;
    }

    @Override
    public String toString() {
        return "YNum{" +
                "departId=" + departId +
                ", yNum=" + yNum +
                '}';
    }
}
