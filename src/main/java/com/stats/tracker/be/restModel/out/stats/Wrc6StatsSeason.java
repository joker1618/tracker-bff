package com.stats.tracker.be.restModel.out.stats;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;

import java.util.List;

public class Wrc6StatsSeason {

    private Wrc6Driver winner;
    private JsonStat rallyWin;
    private JsonStat matchWin;

    private List<JsonStat> rallyByCountry;
    private List<JsonStat> matchByCountry;
//    private List<JsonStat> rallyByCar;
//    private List<JsonStat> matchByCar;
//    private List<JsonStat> matchBySurface;
//    private List<JsonStat> matchByPrimarySurface;


    public Wrc6Driver getWinner() {
        return winner;
    }

    public void setWinner(Wrc6Driver winner) {
        this.winner = winner;
    }

    public JsonStat getRallyWin() {
        return rallyWin;
    }

    public void setRallyWin(JsonStat rallyWin) {
        this.rallyWin = rallyWin;
    }

    public JsonStat getMatchWin() {
        return matchWin;
    }

    public void setMatchWin(JsonStat matchWin) {
        this.matchWin = matchWin;
    }

    public List<JsonStat> getRallyByCountry() {
        return rallyByCountry;
    }

    public void setRallyByCountry(List<JsonStat> rallyByCountry) {
        this.rallyByCountry = rallyByCountry;
    }

    public List<JsonStat> getMatchByCountry() {
        return matchByCountry;
    }

    public void setMatchByCountry(List<JsonStat> matchByCountry) {
        this.matchByCountry = matchByCountry;
    }
}
