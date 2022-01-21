package com.weather.WeatherAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

    //serialuid number?

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    private double temp;

    @Column(nullable = false)
    private String description;
    private double longitude;
    private double latitude;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;

    @JsonProperty("name")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("main")
    public void setTempFromJson(Map<String, Object> mainEntries) {
        setTemp((double) mainEntries.get("temp"));
    }

    @JsonProperty("coord")
    public void setCoord(Map<String, Double> coord){
        setLongitude(coord.get("lon"));
        setLatitude(coord.get("lat"));
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, String>> weather){
        setDescription(weather.get(0).get("description"));
    }
}
