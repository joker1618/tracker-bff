package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcRaceTime6 extends RepoEntity implements Serializable {

    @RepoField
    private String raceTime;

    public WrcRaceTime6() {
    }

    public WrcRaceTime6(String raceTime) {
        this.raceTime = raceTime;
    }

    public String getRaceTime() {
        return raceTime;
    }

    @Override
    public String getPrimaryKey() {
        return raceTime;
    }
}
