package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class JsonWrcCountry extends AbstractJsonEntity implements Serializable {

    private long id;
    private String name;
    private String code;
    private int seasonIndex;

    public JsonWrcCountry() {
    }

    public JsonWrcCountry(String name, String code, int seasonIndex) {
        this.name = name;
        this.code = code;
        this.seasonIndex = seasonIndex;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getSeasonIndex() {
        return seasonIndex;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSeasonIndex(int seasonIndex) {
        this.seasonIndex = seasonIndex;
    }
}
