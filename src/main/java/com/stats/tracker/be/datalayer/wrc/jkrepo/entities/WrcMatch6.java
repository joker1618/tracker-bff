package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;
import java.time.LocalDateTime;

import static xxx.joker.libs.core.utils.JkStrings.strf;

public class WrcMatch6 extends RepoEntity implements Serializable {

    @RepoField
    private WrcWeather6 weather;
    @RepoField
    private WrcRaceTime6 raceTime;
    @RepoField
    private WrcCar6 carFede;
    @RepoField
    private WrcCar6 carBomber;
    @RepoField
    private WrcDriver6 winner;
    @RepoField
    private LocalDateTime matchTime;
    @RepoField
    private WrcStage6 stage;
    @RepoField
    private long rallyId;



    public WrcMatch6() {

    }

    public WrcStage6 getStage() {
        return stage;
    }

    public void setStage(WrcStage6 stage) {
        this.stage = stage;
    }

    public WrcWeather6 getWeather() {
        return weather;
    }

    public void setWeather(WrcWeather6 weather) {
        this.weather = weather;
    }

    public WrcRaceTime6 getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(WrcRaceTime6 raceTime) {
        this.raceTime = raceTime;
    }

    public WrcCar6 getCarFede() {
        return carFede;
    }

    public void setCarFede(WrcCar6 carFede) {
        this.carFede = carFede;
    }

    public WrcCar6 getCarBomber() {
        return carBomber;
    }

    public void setCarBomber(WrcCar6 carBomber) {
        this.carBomber = carBomber;
    }

    public WrcDriver6 getWinner() {
        return winner;
    }

    public void setWinner(WrcDriver6 winner) {
        this.winner = winner;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public long getRallyId() {
        return rallyId;
    }

    public void setRallyId(long rallyId) {
        this.rallyId = rallyId;
    }

    @Override
    public String getPrimaryKey() {
        return strf("match-{}", getEntityID());
    }
}