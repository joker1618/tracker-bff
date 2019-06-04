package com.stats.tracker.be.restModel.in;

import java.io.Serializable;

public class JsonMatchAdd implements Serializable {

    private String country;
    private String winner;
    private String carFede;
    private String carBomber;
    private String weather;
    private String raceTime;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getCarFede() {
        return carFede;
    }

    public void setCarFede(String carFede) {
        this.carFede = carFede;
    }

    public String getCarBomber() {
        return carBomber;
    }

    public void setCarBomber(String carBomber) {
        this.carBomber = carBomber;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }
}
