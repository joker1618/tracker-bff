package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static xxx.joker.libs.core.utils.JkStrings.strf;

public class WrcRally6 extends RepoEntity implements Serializable {

    @RepoField
    private WrcCountry6 country;
    @RepoField
    private List<WrcMatch6> matches;
    @RepoField
    private long seasonId;
    @RepoField
    private WrcDriver6 winner;




    public WrcRally6() {
        matches = new ArrayList<>();
    }


    public List<WrcMatch6> getMatches() {
        return matches;
    }

    public void setMatches(List<WrcMatch6> matches) {
        this.matches = matches;
    }

    public WrcCountry6 getCountry() {
        return country;
    }

    public void setCountry(WrcCountry6 country) {
        this.country = country;
    }

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public WrcDriver6 getWinner() {
        return winner;
    }
    public boolean hasWinner() {
        return winner != null;
    }

    public void setWinner(WrcDriver6 winner) {
        this.winner = winner;
    }

    @Override
    public String getPrimaryKey() {
        return strf("rally-%02d-%s", seasonId, country.getName());
    }
}