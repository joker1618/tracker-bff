package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcWeather6 extends RepoEntity implements Serializable {

    @RepoField
    private String weather;

    public WrcWeather6() {
    }

    public WrcWeather6(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    @Override
    public String getPrimaryKey() {
        return weather;
    }
}
