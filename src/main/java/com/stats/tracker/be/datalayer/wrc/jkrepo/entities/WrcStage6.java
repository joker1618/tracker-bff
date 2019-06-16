package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

public class WrcStage6 extends RepoEntity implements Serializable {

    @RepoField
    private WrcCountry6 country;
    @RepoField
    private String location;
    @RepoField
    private int numInRally;
    @RepoField
    private int length;
    @RepoField
    private boolean specialStage;
    @RepoField
    private WrcSurface6 surface;


    public WrcStage6() {
    }

    public WrcCountry6 getCountry() {
        return country;
    }

    public void setCountry(WrcCountry6 country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumInRally() {
        return numInRally;
    }

    public void setNumInRally(int numInRally) {
        this.numInRally = numInRally;
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

    public WrcSurface6 getSurface() {
        return surface;
    }

    public void setSurface(WrcSurface6 surface) {
        this.surface = surface;
    }

    @Override
    public String getPrimaryKey() {
        return strf("stage-{}", getEntityID());
    }
}