package com.damassh.travelplanner.service;

import java.time.LocalDate;

import com.damassh.travelplanner.model.WeatherForecast;
import com.damassh.travelplanner.model.entity.City;

public interface WeatherForecastService {

    WeatherForecast getWeatherForecastByCity(String cityName);

    City findByCityName(String cityName);

    City getWeatherForecastByCityName(String cityName, LocalDate startDate, LocalDate endDate);

}
