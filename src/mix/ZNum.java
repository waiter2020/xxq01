package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:37 18-7-15
 */
public class ZNum {
    private int departId;//部门id
    private int zNum;//部门在职人数

    public ZNum(){}

    public ZNum(int departId, int zNum) {
        this.departId = departId;
        this.zNum = zNum;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getzNum() {
        return zNum;
    }

    public void setzNum(int zNum) {
        this.zNum = zNum;
    }

    @Override
    public String toString() {
        return "ZNum{" +
                "departId=" + departId +
                ", zNum=" + zNum +
                '}';
    }
}
