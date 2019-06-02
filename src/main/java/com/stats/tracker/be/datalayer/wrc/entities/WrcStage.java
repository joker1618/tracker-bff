package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class WrcStage extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    private WrcCountry country;
    @NotNull
    private String location;
    @NotNull
    private int numInRally;
    @NotNull
    private int length;
    @NotNull
    private boolean specialStage;
    @NotNull
    @ManyToOne
    private WrcSurface surface;


    public WrcStage() {
    }

    public long getId() {
        return id;
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
}