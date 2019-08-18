package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Wrc6Match extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    @ManyToOne
    private Wrc6Weather weather;

    @NotNull
    @ManyToOne
    private Wrc6RaceTime raceTime;

    @ManyToOne
    private Wrc6Car carFede;

    @ManyToOne
    private Wrc6Car carBomber;

    @NotNull
    @ManyToOne
    private Wrc6Driver winner;

    @NotNull
    private LocalDateTime matchTime;

    @NotNull
    @ManyToOne
    private Wrc6Stage stage;



    public Wrc6Match() {

    }

    public Wrc6Stage getStage() {
        return stage;
    }

    public void setStage(Wrc6Stage stage) {
        this.stage = stage;
    }

    public long getJpaId() {
        return jpaId;
    }

    public Wrc6Weather getWeather() {
        return weather;
    }

    public void setWeather(Wrc6Weather weather) {
        this.weather = weather;
    }

    public Wrc6RaceTime getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(Wrc6RaceTime raceTime) {
        this.raceTime = raceTime;
    }

    public Wrc6Car getCarFede() {
        return carFede;
    }

    public void setCarFede(Wrc6Car carFede) {
        this.carFede = carFede;
    }

    public Wrc6Car getCarBomber() {
        return carBomber;
    }

    public void setCarBomber(Wrc6Car carBomber) {
        this.carBomber = carBomber;
    }

    public Wrc6Driver getWinner() {
        return winner;
    }

    public void setWinner(Wrc6Driver winner) {
        this.winner = winner;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(LocalDateTime matchTime) {
        this.matchTime = matchTime;
    }

}