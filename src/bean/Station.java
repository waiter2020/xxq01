package bean;

/**
 * @ Author     ：Bzy.
 * @ Date       ：Created in 下午7:40 18-7-10
 */
public class Station {
    private int id;
    private String stationname;

    public Station(){}

    public Station(int id, String stationname) {
        this.id = id;
        this.stationname = stationname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationname='" + stationname + '\'' +
                '}';
    }
}
