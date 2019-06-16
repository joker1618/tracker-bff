package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;

public class JsonWrcSurface extends AbstractJsonEntity implements Serializable {

    private long id;
    private JsonWrcGroundMix primaryGround;
    private JsonWrcGroundMix secondaryGround;


    public JsonWrcSurface() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JsonWrcGroundMix getPrimaryGround() {
        return primaryGround;
    }

    public void setPrimaryGround(JsonWrcGroundMix primaryGround) {
        this.primaryGround = primaryGround;
    }

    public JsonWrcGroundMix getSecondaryGround() {
        return secondaryGround;
    }

    public void setSecondaryGround(JsonWrcGroundMix secondaryGround) {
        this.secondaryGround = secondaryGround;
    }
}
