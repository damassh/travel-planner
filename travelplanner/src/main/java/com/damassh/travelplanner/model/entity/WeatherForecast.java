package com.damassh.travelplanner.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "WEATHER_FORECAST")
public class WeatherForecast implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "WEATHER_FORECAST_ID")
    private Long id;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    @Column(name = "CLOUD")
    private Integer cloud;

    @Column(name = "DATE_TIME")
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID", nullable = false)
    private City city;

    public WeatherForecast() {
        super();
    }

    public WeatherForecast(Double temperature, Integer cloud, LocalDateTime date, City city) {
        this.temperature = temperature;
        this.cloud = cloud;
        this.date = date;
        this.city = city;
    }

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

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @JsonBackReference
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
