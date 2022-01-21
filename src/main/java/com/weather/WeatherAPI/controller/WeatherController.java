package com.weather.WeatherAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.WeatherAPI.entity.Weather;
import com.weather.WeatherAPI.model.WeatherUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.NotBlank;


@RestController
public class WeatherController {

    @Autowired
    private WeatherUrl weatherUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/cityWeather")
    @ResponseStatus(HttpStatus.OK)
    public Weather getCurrentWeatherByCityName(@RequestParam @NotBlank String city) throws JsonProcessingException {
        String response = webClientBuilder.build()
                .get()
                .uri(weatherUrl.getUrl() + "?q=" + city + "&units=" + weatherUrl.getUnits() + "&appid=" + weatherUrl.getApiKey())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return mapper.readValue(response, Weather.class);

    }


    @GetMapping("/weatherString")
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentWeatherStringByCityName(@RequestParam @NotBlank String city){
        String weather = webClientBuilder.build()
                .get()
                .uri(weatherUrl.getUrl() + "?q=" + city + "&units=" + weatherUrl.getUnits() + "&appid=" + weatherUrl.getApiKey())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return weather;
    }
}
