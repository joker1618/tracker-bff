package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcWeather extends AbstractJsonEntity implements Serializable {

    private long id;
    private String weather;

    public JsonWrcWeather() {
    }

    public JsonWrcWeather(String weather) {
        this.weather = weather;
    }

    public long getId() {
        return id;
    }

    public String getWeather() {
        return weather;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
