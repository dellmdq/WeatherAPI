package com.weather.WeatherAPI.model;

import lombok.Data;

@Data
public class WeatherUrl {
    private String url;
    private String apiKey;
    private String units;
}
