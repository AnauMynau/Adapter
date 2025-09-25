package weather.adapter;

import java.util.Locale;

// Adapter (переходник)

/**
 * Adapter: реализует целевой интерфейс WeatherProvider,
 * внутри обращается к LegacyWeatherService и конвертирует единицы.
 */
public class WeatherAdapter implements WeatherProvider {
    private final LegacyWeatherService legacy;

    public WeatherAdapter(LegacyWeatherService legacy) {
        if (legacy == null) throw new IllegalArgumentException("legacy service is required");
        this.legacy = legacy;
    }

    @Override
    public String getTemperatureC() {
        double kelvin = legacy.fetchTempKelvin();
        double celsius = kelvinToCelsius(kelvin);
        return format("%.1f °C", celsius);
    }

    @Override
    public String getWindKmh() {
        double ms = legacy.fetchWindInMetersPerSec();
        double kmh = msToKmh(ms);
        return format("%.1f kph", kmh);
    }

    // ==== helpers (малые методы, один уровень абстракции) ====
    private static double kelvinToCelsius(double kelvin) { return kelvin - 273.15; }
    private static double msToKmh(double ms) { return ms * 3.6; }


    private static String format(String pattern, double value) {
        // фиксируем Locale, чтобы точка была разделителем везде одинаково
        return String.format(Locale.US, pattern, value);
    }
}
