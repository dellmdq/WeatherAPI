package com.weather.WeatherAPI.service;

import com.weather.WeatherAPI.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface WeatherService {

    public Weather findByCity(String city);
}
