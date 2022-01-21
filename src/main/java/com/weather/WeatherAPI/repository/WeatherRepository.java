package com.weather.WeatherAPI.repository;

import com.weather.WeatherAPI.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
