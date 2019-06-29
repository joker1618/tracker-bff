package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class WrcMatch extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    @ManyToOne
    private WrcWeather weather;
    @RepoField
    @NotNull
    @ManyToOne
    private WrcRaceTime raceTime;
    @RepoField
    @ManyToOne
    private WrcCar carFede;
    @RepoField
    @ManyToOne
    private WrcCar carBomber;
    @RepoField
    @NotNull
    @ManyToOne
    private WrcDriver winner;
    @RepoField
    @NotNull
    private LocalDateTime matchTime;
    @RepoField
    @NotNull
    @ManyToOne
    private WrcStage stage;



    public WrcMatch() {

    }

    public WrcStage getStage() {
        return stage;
    }

    public void setStage(WrcStage stage) {
        this.stage = stage;
    }

    public long getJpaID() {
        return jpaID;
    }

    public WrcWeather getWeather() {
        return weather;
    }

    public void setWeather(WrcWeather weather) {
        this.weather = weather;
    }

    public WrcRaceTime getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(WrcRaceTime raceTime) {
        this.raceTime = raceTime;
    }

    public WrcCar getCarFede() {
        return carFede;
    }

    public void setCarFede(WrcCar carFede) {
        this.carFede = carFede;
    }

    public WrcCar getCarBomber() {
        return carBomber;
    }

    public void setCarBomber(WrcCar carBomber) {
        this.carBomber = carBomber;
    }

    public WrcDriver getWinner() {
        return winner;
    }

    public void setWinner(WrcDriver winner) {
        this.winner = winner;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    @Override
    public String getPrimaryKey() {
        return "match-" + entityID;
    }
}