package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-15
 */
public class Man {
    private int departId;//部门id
    private int man;//部门男人个数

    public Man(){}

    public Man(int departId, int man) {
        this.departId = departId;
        this.man = man;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    @Override
    public String toString() {
        return "Man{" +
                "departId=" + departId +
                ", man=" + man +
                '}';
    }
}
