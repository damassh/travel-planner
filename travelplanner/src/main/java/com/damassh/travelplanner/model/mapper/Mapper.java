package com.damassh.travelplanner.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.damassh.travelplanner.model.dto.CityDto;
import com.damassh.travelplanner.model.dto.ItineraryDto;
import com.damassh.travelplanner.model.dto.WeatherForecastDto;
import com.damassh.travelplanner.model.entity.City;
import com.damassh.travelplanner.model.entity.Itinerary;
import com.damassh.travelplanner.model.entity.WeatherForecast;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Itinerary itineraryDtoToItinerary(ItineraryDto itineraryDto) {
        Itinerary itinerary = new Itinerary();
        itinerary.setItineraryName(itineraryDto.getItineraryName());
//        List<City> cities = new ArrayList<>();
//
//        for (CityDto cityDto: itineraryDto.getCities()) {
//            cities.add(cityDtoToCity(cityDto, itinerary));
//        }
//        itinerary.setCities(cities);
        return itinerary;
    }

    public City cityDtoToCity(CityDto cityDto, Itinerary itinerary) {
        City city = new City();
        city.setId(cityDto.getId());
        city.setCityName(city.getCityName());
        city.setCountryCode(city.getCountryCode());
        List<WeatherForecast> weatherForecasts = new ArrayList<>();

        for (WeatherForecastDto weatherForecastDto : cityDto.getWeatherForecasts()) {
            weatherForecasts.add(weatherForecastDtoToWeatherForecast(weatherForecastDto, city));
        }
        city.setWeatherForecasts(weatherForecasts);
        city.setItinerary(itinerary);
        return city;
    }

    public WeatherForecast weatherForecastDtoToWeatherForecast(WeatherForecastDto weatherForecastDto, City city) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setId(weatherForecastDto.getId());
        weatherForecast.setTemperature(weatherForecastDto.getTemperature());
        weatherForecast.setCloud(weatherForecastDto.getCloud());
        weatherForecast.setCity(city);
        return weatherForecast;
    }
}
