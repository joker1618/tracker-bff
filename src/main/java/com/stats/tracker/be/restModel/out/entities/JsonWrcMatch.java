package com.stats.tracker.be.restModel.out.entities;

import com.stats.tracker.be.restModel.AbstractJsonEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class JsonWrcMatch extends AbstractJsonEntity implements Serializable {

    private long id;
    private JsonWrcWeather weather;
    private JsonWrcRaceTime raceTime;
    private JsonWrcCar carFede;
    private JsonWrcCar carBomber;
    private JsonWrcDriver winner;
    private LocalDateTime matchTime;
    private JsonWrcStage stage;
    private long rallyId;



    public JsonWrcMatch() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JsonWrcWeather getWeather() {
        return weather;
    }

    public void setWeather(JsonWrcWeather weather) {
        this.weather = weather;
    }

    public JsonWrcRaceTime getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(JsonWrcRaceTime raceTime) {
        this.raceTime = raceTime;
    }

    public JsonWrcCar getCarFede() {
        return carFede;
    }

    public void setCarFede(JsonWrcCar carFede) {
        this.carFede = carFede;
    }

    public JsonWrcCar getCarBomber() {
        return carBomber;
    }

    public void setCarBomber(JsonWrcCar carBomber) {
        this.carBomber = carBomber;
    }

    public JsonWrcDriver getWinner() {
        return winner;
    }

    public void setWinner(JsonWrcDriver winner) {
        this.winner = winner;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

    public JsonWrcStage getStage() {
        return stage;
    }

    public void setStage(JsonWrcStage stage) {
        this.stage = stage;
    }

    public long getRallyId() {
        return rallyId;
    }

    public void setRallyId(long rallyId) {
        this.rallyId = rallyId;
    }
}