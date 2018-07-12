package bean;

import utils.annotation.Column;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-10
 */
public class Station {
    private int id;
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
                ", stationname='" + stationName + '\'' +
                '}';
    }
}
