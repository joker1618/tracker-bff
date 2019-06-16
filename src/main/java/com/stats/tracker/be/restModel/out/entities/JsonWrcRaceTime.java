package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcRaceTime extends AbstractJsonEntity implements Serializable {

    private long id;
    private String raceTime;

    public JsonWrcRaceTime() {
    }

    public JsonWrcRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public long getId() {
        return id;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }
}
