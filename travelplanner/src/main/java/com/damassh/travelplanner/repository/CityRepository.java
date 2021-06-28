package com.damassh.travelplanner.repository;

import com.damassh.travelplanner.model.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

    City findByCityName(String cityName);
}
