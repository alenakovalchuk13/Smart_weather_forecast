package by.weatherapp.weatherapp.controller;

import by.weatherapp.weatherapp.dto.WeatherAPIDto;
import by.weatherapp.weatherapp.dto.WeatherDto;
import by.weatherapp.weatherapp.mapper.WeatherMapper;
import by.weatherapp.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherMapper weatherMapper;

    @GetMapping
    public ResponseEntity<WeatherDto> getWeather(@RequestParam(value = "city") String city) {
        WeatherAPIDto weatherByCityName = weatherService.getWeatherByCityName(city);

        return new ResponseEntity<>(
                weatherMapper.toWeatherDto(weatherByCityName),
                HttpStatus.OK
        );
    }
}
