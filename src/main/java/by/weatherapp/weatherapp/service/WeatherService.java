package by.weatherapp.weatherapp.service;

import by.weatherapp.weatherapp.config.OpenWeatherMapConfig;
import by.weatherapp.weatherapp.dto.WeatherAPIDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherMapConfig openWeatherMapConfig;

    public WeatherAPIDto getWeatherByCityName(String cityName) {
        return openWeatherMapConfig.getWeatherForCity(cityName);
    }
}
