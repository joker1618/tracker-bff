package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;


public class WrcCountry6 extends RepoEntity implements Serializable {

    @RepoField
    private String name;
    @RepoField
    private String code;
    @RepoField
    private int numInSeason;

    public WrcCountry6() {
    }

    public WrcCountry6(String name, String code, int numInSeason) {
        this.name = name;
        this.code = code;
        this.numInSeason = numInSeason;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getNumInSeason() {
        return numInSeason;
    }

    @Override
    public String getPrimaryKey() {
        return name;
    }
}
