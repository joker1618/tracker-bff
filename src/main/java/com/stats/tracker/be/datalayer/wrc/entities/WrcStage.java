package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

@Entity
public class WrcStage extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    @ManyToOne
    private WrcCountry country;
    @RepoField
    @NotNull
    private String location;
    @RepoField
    @NotNull
    private int numInRally;
    @RepoField
    @NotNull
    private int length;
    @RepoField
    @NotNull
    private boolean specialStage;
    @RepoField
    @NotNull
    @ManyToOne
    private WrcSurface surface;


    public WrcStage() {
    }

    public long getJpaID() {
        return jpaID;
    }

    public WrcCountry getCountry() {
        return country;
    }

    public void setCountry(WrcCountry country) {
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

    public WrcSurface getSurface() {
        return surface;
    }

    public void setSurface(WrcSurface surface) {
        this.surface = surface;
    }

    @Override
    public String getPrimaryKey() {
        return strf("stage-%02d-%d", country.getNumInSeason(), numInRally);
    }
}