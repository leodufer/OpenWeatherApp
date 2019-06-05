package py.edu.facitec.oscar.githubsearch.modelo;

import java.util.List;

public class Clima {
    private String name;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String dt;
    private Sys sys;

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "name='" + name + '\'' +
                ", weather=" + weather +
                ", main=" + main +
                ", wind=" + wind +
                ", sys=" + sys +
                ", dt='" + dt + '\'' +
                '}';
    }
}
