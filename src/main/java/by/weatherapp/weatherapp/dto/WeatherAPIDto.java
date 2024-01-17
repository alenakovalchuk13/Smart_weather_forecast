package by.weatherapp.weatherapp.dto;

import by.weatherapp.weatherapp.model.Current;
import by.weatherapp.weatherapp.model.Location;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherAPIDto {
    private Location location;
    private Current current;
}
