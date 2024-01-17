package by.weatherapp.weatherapp.mapper;

import by.weatherapp.weatherapp.dto.WeatherAPIDto;
import by.weatherapp.weatherapp.dto.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public WeatherDto toWeatherDto(WeatherAPIDto weatherAPIDto) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setLocation(weatherAPIDto.getLocation().getName());
        weatherDto.setWeather_description(weatherAPIDto.getCurrent().getCondition().getText());
        weatherDto.setRel_humidity(weatherAPIDto.getCurrent().getHumidity());
        weatherDto.setTimestap(weatherAPIDto.getCurrent().getLast_updated());
        weatherDto.setTemp_celsium(weatherAPIDto.getCurrent().getTemp_c());
        weatherDto.setWind_direction(weatherAPIDto.getCurrent().getWind_dir());
        weatherDto.setWindSpeed_mps(Math.round(weatherAPIDto.getCurrent().getWind_kph()/3.6));

        return weatherDto;
    }
}
