package weather.adapter;

// Client

public class WeatherApp {
    public static void main(String[] args) {
        // Сырой источник (его как будто "нельзя трогать"):
        LegacyWeatherService legacy = new LegacyWeatherService(
                300.15,
                5.0
        );

        // Переходник:
        WeatherProvider provider = new WeatherAdapter(legacy);

        // Клиент получает уже удобные строки:
        System.out.println("Temperature : " + provider.getTemperatureC());
        System.out.println("Wind        : " + provider.getWindKmh());
    }
}
