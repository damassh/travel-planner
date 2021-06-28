package com.damassh.travelplanner.service;

import com.damassh.travelplanner.model.dto.ItineraryDto;
import com.damassh.travelplanner.model.entity.Itinerary;

public interface ItineraryService {

    Itinerary findByItineraryName(String itineraryName);

    Itinerary saveItinerary(ItineraryDto itinerary);

}
