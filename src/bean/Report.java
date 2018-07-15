package bean;

import java.math.BigDecimal;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午5:19 18-7-15
 */
public class Report {
    private int departId;//部门id
    private double avgScore;//部门平均绩效
    private double avgPresent;//部门平均考勤
    private int zNum;//部门在职人数
    private int lNum;//部门离职人数
    private int sNum;//部门实习人数
    private int yNum;//部门正式员工数
    private double avgAge;//部门平均年龄
    private int man;//部门男人个数
    private int woman;//部门女人个数

    public Report(){}

    public Report(int departId, double avgScore, double avgPresent, int zNum, int lNum, int sNum, int yNum, int avgAge, int man, int woman) {
        this.departId = departId;
        this.avgScore = avgScore;
        this.avgPresent = avgPresent;
        this.zNum = zNum;
        this.lNum = lNum;
        this.sNum = sNum;
        this.yNum = yNum;
        this.avgAge = avgAge;
        this.man = man;
        this.woman = woman;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getAvgPresent() {
        return avgPresent;
    }

    public void setAvgPresent(double avgPresent) {
        this.avgPresent = avgPresent;
    }

    public int getzNum() {
        return zNum;
    }

    public void setzNum(int zNum) {
        this.zNum = zNum;
    }

    public int getlNum() {
        return lNum;
    }

    public void setlNum(int lNum) {
        this.lNum = lNum;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    public int getyNum() {
        return yNum;
    }

    public void setyNum(int yNum) {
        this.yNum = yNum;
    }

    public double getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(double avgAge) {
        this.avgAge = avgAge;
    }

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Report{" +
                "departId=" + departId +
                ", avgScore=" + avgScore +
                ", avgPresent=" + avgPresent +
                ", zNum=" + zNum +
                ", lNum=" + lNum +
                ", sNum=" + sNum +
                ", yNum=" + yNum +
                ", avgAge=" + avgAge +
                ", man=" + man +
                ", woman=" + woman +
                '}';
    }
}
