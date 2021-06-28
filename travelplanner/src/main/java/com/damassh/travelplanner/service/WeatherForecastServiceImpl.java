package com.damassh.travelplanner.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.damassh.travelplanner.model.List;
import com.damassh.travelplanner.model.WeatherForecast;
import com.damassh.travelplanner.repository.CityRepository;
import com.damassh.travelplanner.repository.WeatherForecastRepository;
import com.damassh.travelplanner.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService, Serializable {

    final String cityParameterName = "q";
    RestTemplate restTemplate;
    @Value("${weather.forecast.url}")
    private String weatherForecastUrl;
    @Value("${api.key.name}")
    private String apiKeyName;
    @Value("${api.key.value}")
    private String apiKeyValue;
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;

    public WeatherForecastServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public WeatherForecast getWeatherForecastByCity(String cityName) {

        WeatherForecast weatherForecast = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity requestEntity = new HttpEntity<>(headers);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(weatherForecastUrl)
                .queryParam(cityParameterName, cityName)
                .queryParam(apiKeyName, apiKeyValue)
                .queryParam(CommonUtil.UNIT, CommonUtil.METRICS);

        ResponseEntity<WeatherForecast> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET, requestEntity, WeatherForecast.class);

        weatherForecast = responseEntity.getBody();
        return weatherForecast;
    }

    @Override
    public com.damassh.travelplanner.model.entity.City findByCityName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }

    public com.damassh.travelplanner.model.entity.City getWeatherForecastByCityName(
            String cityName, LocalDate startDate, LocalDate endDate) {
        com.damassh.travelplanner.model.entity.City city = findByCityName(cityName);
        if (city != null) {
            return city;
        }

        WeatherForecast cityWeatherForecast = getWeatherForecastByCity(cityName);
        city = mapToCityEntity(cityWeatherForecast);
        city.setWeatherForecasts(mapToWeatherForecastEntity(cityWeatherForecast, city, startDate, endDate));
        return cityRepository.save(city);
    }

    private com.damassh.travelplanner.model.entity.City mapToCityEntity(WeatherForecast weatherForecast) {
        com.damassh.travelplanner.model.entity.City city = new
                com.damassh.travelplanner.model.entity.City(weatherForecast.getCity().getName(),
                weatherForecast.getCity().getCountry());
        return city;
    }

    private java.util.List<com.damassh.travelplanner.model.entity.WeatherForecast> mapToWeatherForecastEntity(
            WeatherForecast weatherForecast, com.damassh.travelplanner.model.entity.City city, LocalDate startDate, LocalDate endDate) {
        java.util.List<com.damassh.travelplanner.model.entity.WeatherForecast> entity = new ArrayList<>();

        // map forecast details
        java.util.List<List> forecastList = weatherForecast.getList();

        for (List forecast : forecastList) {
            LocalDateTime dateTime = LocalDateTime.parse(forecast.getDtTxt(), CommonUtil.DATE_TIME_FORMATTER);
            // include forecast within date range and between 12pm to 6pm
            if (CommonUtil.validateDateInterval(dateTime.toLocalDate(), startDate, endDate)) {
                if (CommonUtil.validateTimeInterval(dateTime)) {
                    com.damassh.travelplanner.model.entity.WeatherForecast wf =
                            new com.damassh.travelplanner.model.entity.WeatherForecast(
                                    forecast.getMain().getTemp(),
                                    forecast.getClouds().getAll(),
                                    dateTime, city
                            );
                    entity.add(wf);
                }
            }
        }

        return entity;
    }
}
