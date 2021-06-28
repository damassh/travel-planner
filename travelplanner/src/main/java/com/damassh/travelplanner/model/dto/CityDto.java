package com.damassh.travelplanner.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CityDto {

    @JsonProperty("weatherForecasts")
    private final List<WeatherForecastDto> weatherForecasts = new ArrayList<>();
    @JsonProperty("id")
    private Long id;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("countryCode")
    private String countryCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<WeatherForecastDto> getWeatherForecasts() {
        return weatherForecasts;
    }
}
