package bean;

import utils.annotation.Column;
import utils.annotation.Count;
import utils.annotation.ManyToOne;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-10
 * 岗位表
 */
public class Station {
    /**
     * 岗位id
     */
    private int id;
    /**
     * 岗位名
     */
    @Column(name = "stationname")
    private String stationName;
    @ManyToOne(bean = Depart.class)
    private Depart depart;
    @Count(bean = Staff.class,name = "station")
    private int count;

    public Station(){}

    public Station(int id, String stationName) {
        this.id = id;
        this.stationName = stationName;
    }

    public Depart getDepart() {
        return depart;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
