package com.damassh.travelplanner.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import com.damassh.travelplanner.model.dto.CityDto;
import com.damassh.travelplanner.model.dto.ItineraryDto;
import com.damassh.travelplanner.model.entity.City;
import com.damassh.travelplanner.model.entity.Itinerary;
import com.damassh.travelplanner.model.mapper.Mapper;
import com.damassh.travelplanner.repository.CityRepository;
import com.damassh.travelplanner.repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements ItineraryService, Serializable {

    @Autowired
    ItineraryRepository itineraryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    Mapper mapper;

    @Override
    @Transactional
    public Itinerary findByItineraryName(String itineraryName) {
        return itineraryRepository.findByItineraryName(itineraryName);
    }

    @Override
    @Transactional
    public Itinerary saveItinerary(ItineraryDto itineraryDto) {
        Itinerary itinerary = mapper.itineraryDtoToItinerary(itineraryDto);
        itinerary = itineraryRepository.save(itinerary);

        for (CityDto cityDto : itineraryDto.getCities()) {
            City city = cityRepository.findById(cityDto.getId()).orElse(null);
            if (city != null) {
                city.setItinerary(itinerary);
                itinerary.getCities().add(cityRepository.save(city));
            }
        }
        return itinerary;
    }

}
