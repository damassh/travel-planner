package com.damassh.travelplanner.controller;

import com.damassh.travelplanner.model.dto.ItineraryDto;
import com.damassh.travelplanner.model.entity.Itinerary;
import com.damassh.travelplanner.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItineraryController {

    @Autowired
    ItineraryService itineraryService;

    @GetMapping("/getItineraryByName")
    @ResponseBody
    public Itinerary getItinerary(@RequestParam(name = "name", required = true) String itineraryName) {
        return itineraryService.findByItineraryName(itineraryName);
    }

    @PostMapping("/saveItinerary")
    @ResponseBody
    public Itinerary saveItinerary(@RequestBody ItineraryDto itinerary) {
        return itineraryService.saveItinerary(itinerary);
    }
}
