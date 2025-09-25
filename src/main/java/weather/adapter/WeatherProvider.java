package weather.adapter;

// Target (то, что ждёт клиент)

public interface WeatherProvider {
    String getTemperatureC();
    String getWindKmh();
}
