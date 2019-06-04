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
    private List<WrcRally> rallies;

    private LocalDateTime startTm;
    private LocalDateTime endTm;
    @ManyToOne
    private WrcDriver winner;


    public WrcSeason() {
        rallies = new ArrayList<>();
    }

    public List<WrcRally> getRallies() {
        return rallies;
    }

    public void setRallies(List<WrcRally> rallies) {
        this.rallies = rallies;
    }




    public long getId() {
        return id;
    }

    public LocalDateTime getStartTm() {
        return startTm;
    }

    public void setStartTm(LocalDateTime startTm) {
        this.startTm = startTm;
    }

    public LocalDateTime getEndTm() {
        return endTm;
    }

    public void setEndTm(LocalDateTime endTm) {
        this.endTm = endTm;
    }

    public WrcDriver getWinner() {
        return winner;
    }

    public void setWinner(WrcDriver winner) {
        this.winner = winner;
    }
}