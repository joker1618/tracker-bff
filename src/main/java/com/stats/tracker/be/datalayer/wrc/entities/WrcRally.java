package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcRally extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    private WrcCountry country;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WrcMatch> matches = new ArrayList<>();
    @NotNull
    private boolean inProgress;
//    @ManyToOne
//    private WrcSeason season;


    public WrcRally() {

    }


    public long getId() {
        return id;
    }

    public List<WrcMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<WrcMatch> matches) {
        this.matches = matches;
    }

    public WrcCountry getCountry() {
        return country;
    }

    public void setCountry(WrcCountry country) {
        this.country = country;
    }

    public boolean isInProgress() {
        return inProgress;
    }

//    public WrcSeason getSeason() {
//        return season;
//    }
//
//    public void setSeason(WrcSeason season) {
//        this.season = season;
//    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}