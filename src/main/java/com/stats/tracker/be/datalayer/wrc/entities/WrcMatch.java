package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class WrcMatch extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne(cascade= CascadeType.ALL)
    private WrcWeather weather;
    @ManyToOne(cascade= CascadeType.ALL)
    @NotNull
    private WrcRaceTime raceTime;
    @ManyToOne(cascade= CascadeType.ALL)
    private WrcCar carFede;
    @ManyToOne(cascade= CascadeType.ALL)
    private WrcCar carBomber;
    @ManyToOne(cascade= CascadeType.ALL)
    @NotNull
    private WrcDriver winner;
    @NotNull
    private LocalDateTime matchTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private WrcStage stage;



    public WrcMatch() {
        matchTime = LocalDateTime.now();
    }

    public WrcStage getStage() {
        return stage;
    }

    public void setStage(WrcStage stage) {
        this.stage = stage;
    }

    public long getId() {
        return id;
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

}