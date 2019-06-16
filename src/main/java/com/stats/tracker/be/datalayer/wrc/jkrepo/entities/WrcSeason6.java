package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WrcSeason6 extends RepoEntity implements Serializable {

    @RepoField
    private List<WrcRally6> rallies;
    @RepoField
    private LocalDateTime startTm;
    @RepoField
    private LocalDateTime endTm;
    @RepoField
    private WrcDriver6 winner;


    public WrcSeason6() {
        rallies = new ArrayList<>();
    }

    public List<WrcRally6> getRallies() {
        return rallies;
    }

    public void setRallies(List<WrcRally6> rallies) {
        this.rallies = rallies;
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

    public WrcDriver6 getWinner() {
        return winner;
    }

    public void setWinner(WrcDriver6 winner) {
        this.winner = winner;
    }

    @Override
    public String getPrimaryKey() {
        return "season-" + getEntityID();
    }
}