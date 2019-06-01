package com.stats.tracker.be.datalayer.wrc.entities;

import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcSurface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class WrcStage extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private WrcCountry countryObj;
    @NotNull
    private String location;
    @Column(name = "numInRally")
    private int numInRally;
    private int length;
    private boolean specialStage;
    @ManyToOne(cascade = CascadeType.ALL)
    private WrcSurface surface;


    public WrcStage() {
    }

    public long getId() {
        return id;
    }

    public WrcCountry getCountryObj() {
        return countryObj;
    }

    public void setCountryObj(WrcCountry countryObj) {
        this.countryObj = countryObj;
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