package bean;

import utils.annotation.Column;

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

    public Station(){}

    public Station(int id, String stationName) {
        this.id = id;
        this.stationName = stationName;
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
