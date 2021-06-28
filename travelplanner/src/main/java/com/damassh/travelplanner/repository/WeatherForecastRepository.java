package com.damassh.travelplanner.repository;

import com.damassh.travelplanner.model.entity.WeatherForecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends CrudRepository<WeatherForecast, Long> {
}
