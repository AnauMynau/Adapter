package weather.adapter;


// Adaptee (старый сервис)


public class LegacyWeatherService {
    private final double tempKelvin;
    private final double windMetersPerSec;

    public LegacyWeatherService(double tempKelvin, double windMetersPerSec) {
        this.tempKelvin = tempKelvin;
        this.windMetersPerSec = windMetersPerSec;
    }

    public double fetchTempKelvin() {
        return tempKelvin;
    }

    public double fetchWindInMetersPerSec() {
        return windMetersPerSec;
    }
}
