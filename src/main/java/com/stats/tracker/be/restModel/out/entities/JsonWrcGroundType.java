package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcGroundType extends AbstractJsonEntity implements Serializable, Comparable<JsonWrcGroundType> {

    private long id;
    private String ground;

    public JsonWrcGroundType() {
    }

    public JsonWrcGroundType(String ground) {
        this.ground = ground;
    }

    public long getId() {
        return id;
    }

    public String getGround() {
        return ground;
    }

    @Override
    public int compareTo(JsonWrcGroundType o) {
        return ground.compareTo(o.getGround());
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }
}
