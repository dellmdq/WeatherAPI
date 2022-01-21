package com.weather.WeatherAPI.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.WeatherAPI.model.WeatherUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherAPIConfig {

    @Value("${weather.url}")
    private String url;

    @Value("${weather.apikey}")
    private String apiKey;

    @Value("${weather.units}")
    private String units;

    @Bean
    public WeatherUrl weatherUrl() {
        WeatherUrl weatherUrl = new WeatherUrl();
        weatherUrl.setUrl(url);
        weatherUrl.setApiKey(apiKey);
        weatherUrl.setUnits(units);
        return weatherUrl;
    }

    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }
}
