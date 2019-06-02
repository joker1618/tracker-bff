package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcSeason extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WrcRally> rallies = new ArrayList<>();

    @NotNull
    private boolean inProgress;

    public WrcSeason() {

    }

    public List<WrcRally> getRallies() {
        return rallies;
    }

    public void setRallies(List<WrcRally> rallies) {
        this.rallies = rallies;
    }


    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public long getId() {
        return id;
    }



}