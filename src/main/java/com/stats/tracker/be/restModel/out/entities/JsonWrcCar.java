package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcCar extends AbstractJsonEntity implements Serializable {

    private long id;
    private String car;

    public JsonWrcCar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
