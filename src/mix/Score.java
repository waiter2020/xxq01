package mix;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:35 18-7-15
 */
public class Score {
    private int departId;//部门id
    private double avgScore;//部门平均绩效
    private double avgPresent;//部门平均考勤

    public Score(){}

    public Score(int departId, double avgScore, double avgPresent) {
        this.departId = departId;
        this.avgScore = avgScore;
        this.avgPresent = avgPresent;
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

    @Override
    public String toString() {
        return "Score{" +
                "departId=" + departId +
                ", avgScore=" + avgScore +
                ", avgPresent=" + avgPresent +
                '}';
    }
}
