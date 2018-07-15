package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:38 18-7-15
 */
public class SNum {
    private int departId;//部门id
    private int sNum;//部门实习人数

    public SNum(){}

    public SNum(int departId, int sNum) {
        this.departId = departId;
        this.sNum = sNum;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    @Override
    public String toString() {
        return "SNum{" +
                "departId=" + departId +
                ", sNum=" + sNum +
                '}';
    }
}
