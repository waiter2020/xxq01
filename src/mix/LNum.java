package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:38 18-7-15
 */
public class LNum {
    private int departId;//部门id
    private int lNum;//部门离职人数

    public LNum(){}

    public LNum(int departId, int lNum) {
        this.departId = departId;
        this.lNum = lNum;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getlNum() {
        return lNum;
    }

    public void setlNum(int lNum) {
        this.lNum = lNum;
    }

    @Override
    public String toString() {
        return "LNum{" +
                "departId=" + departId +
                ", lNum=" + lNum +
                '}';
    }
}
