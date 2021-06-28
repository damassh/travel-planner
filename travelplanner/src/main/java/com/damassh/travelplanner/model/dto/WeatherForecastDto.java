package com.damassh.travelplanner.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecastDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("cloud")
    private int cloud;

    @JsonProperty("date")
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
