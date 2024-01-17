package by.weatherapp.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    private String location;
    private String timestap;
    private double temp_celsium;
    private double windSpeed_mps;
    private int rel_humidity;
    private String wind_direction;
    private String weather_description;
}
