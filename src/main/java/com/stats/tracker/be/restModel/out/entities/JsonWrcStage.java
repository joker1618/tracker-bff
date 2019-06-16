package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcStage extends AbstractJsonEntity implements Serializable {

    private long id;
    private JsonWrcCountry country;
    private String location;
    private int rallyIndex;
    private int length;
    private boolean specialStage;
    private JsonWrcSurface surface;


    public JsonWrcStage() {
    }

    public long getId() {
        return id;
    }

    public JsonWrcCountry getCountry() {
        return country;
    }

    public void setCountry(JsonWrcCountry country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRallyIndex() {
        return rallyIndex;
    }

    public void setRallyIndex(int rallyIndex) {
        this.rallyIndex = rallyIndex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isSpecialStage() {
        return specialStage;
    }

    public void setSpecialStage(boolean specialStage) {
        this.specialStage = specialStage;
    }

    public JsonWrcSurface getSurface() {
        return surface;
    }

    public void setSurface(JsonWrcSurface surface) {
        this.surface = surface;
    }
}