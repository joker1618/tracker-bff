package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcSeason extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seasonId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WrcRally> rallies = new ArrayList<>();

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public WrcSeason() {
        startTime = LocalDateTime.now();
    }

    public List<WrcRally> getRallies() {
        return rallies;
    }

    public void setRallies(List<WrcRally> rallies) {
        this.rallies = rallies;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getSeasonId() {
        return seasonId;
    }



}