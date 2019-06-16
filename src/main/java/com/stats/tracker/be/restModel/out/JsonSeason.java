package com.stats.tracker.be.restModel.out;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcRally;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonSeason implements Serializable {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private List<JsonStat> rallyResults = new ArrayList<>();
    private JsonStat totStage;
    private JsonStat totRally;

    private List<WrcCountry> remainingCountries = new ArrayList<>();
    private WrcRally rallyInProgress;




    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<JsonStat> getRallyResults() {
        return rallyResults;
    }

    public void setRallyResults(List<JsonStat> rallyResults) {
        this.rallyResults = rallyResults;
    }

    public JsonStat getTotStage() {
        return totStage;
    }

    public void setTotStage(JsonStat totStage) {
        this.totStage = totStage;
    }

    public JsonStat getTotRally() {
        return totRally;
    }

    public void setTotRally(JsonStat totRally) {
        this.totRally = totRally;
    }

    public List<WrcCountry> getRemainingCountries() {
        return remainingCountries;
    }

    public void setRemainingCountries(List<WrcCountry> remainingCountries) {
        this.remainingCountries = remainingCountries;
    }

    public WrcRally getRallyInProgress() {
        return rallyInProgress;
    }

    public void setRallyInProgress(WrcRally rallyInProgress) {
        this.rallyInProgress = rallyInProgress;
    }
}
