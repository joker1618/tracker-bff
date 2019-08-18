package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Wrc6Stage extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    @ManyToOne
    private Wrc6Country country;

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
    private Wrc6Surface surface;


    public Wrc6Stage() {
    }

    public long getJpaId() {
        return jpaId;
    }

    public Wrc6Country getCountry() {
        return country;
    }

    public void setCountry(Wrc6Country country) {
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

    public Wrc6Surface getSurface() {
        return surface;
    }

    public void setSurface(Wrc6Surface surface) {
        this.surface = surface;
    }
}