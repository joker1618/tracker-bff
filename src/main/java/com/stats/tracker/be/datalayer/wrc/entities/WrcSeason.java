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
    private long id;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WrcRally> rallies = new ArrayList<>();

    @NotNull
    private boolean finished;

    public WrcSeason() {
        finished = false;
    }

    public List<WrcRally> getRallies() {
        return rallies;
    }

    public void setRallies(List<WrcRally> rallies) {
        this.rallies = rallies;
    }


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public long getId() {
        return id;
    }



}