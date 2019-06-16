package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcGroundMix extends AbstractJsonEntity implements Serializable {

    private long id;
    private JsonWrcGroundType type;
    private double percentage;

    public JsonWrcGroundMix() {
    }

    public long getId() {
        return id;
    }

    public JsonWrcGroundType getType() {
        return type;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(JsonWrcGroundType type) {
        this.type = type;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
