package com.damassh.travelplanner.controller;

import java.time.LocalDate;

import com.damassh.travelplanner.model.entity.City;
import com.damassh.travelplanner.service.WeatherForecastService;
import com.damassh.travelplanner.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherForecastController {

    @Autowired
    WeatherForecastService weatherForecastService;

    @GetMapping("/getWeatherForecastByCity")
    @ResponseBody
    public City getWeatherForecastByCityName(@RequestParam(name = "cityName", required = true) String cityName,
                                             @RequestParam(name = "startDate", required = true) String startDate,
                                             @RequestParam(name = "endDate", required = true) String endDate) {
        LocalDate start = LocalDate.parse(startDate, CommonUtil.DATE_FORMATTER);
        LocalDate end = LocalDate.parse(endDate, CommonUtil.DATE_FORMATTER);
        return weatherForecastService.getWeatherForecastByCityName(cityName, start, end);
    }

}
