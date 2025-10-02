package weather.adapter;

// Client

public class WeatherApp {
    public static void main(String[] args) {
        LegacyWeatherService legacy = new LegacyWeatherService(
                300.15,
                5.0
        );

        // Переходник
        WeatherProvider provider = new WeatherAdapter(legacy);

        // удобные строки:
        System.out.println("Temperature : " + provider.getTemperatureC());
        System.out.println("Wind        : " + provider.getWindKmh());
    }
}
