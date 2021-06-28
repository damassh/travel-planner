package com.damassh.travelplanner.repository;

import com.damassh.travelplanner.model.entity.Itinerary;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryRepository extends CrudRepository<Itinerary, Long> {

    Itinerary findByItineraryName(String itineraryName);
}
