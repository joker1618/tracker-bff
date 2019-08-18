package com.stats.tracker.be.restModel.out.stats;

import java.util.List;
import java.util.Map;

public class Wrc6StatsSummary {

    private JsonStat seasonWin;
    private JsonStat rallyWin;
    private JsonStat matchWin;

    private List<JsonStat> rallyByCountry;
    private List<JsonStat> matchByCountry;
//    private List<JsonStat> rallyByCar;
//    private List<JsonStat> matchByCar;
//    private List<JsonStat> matchBySurface;
//    private List<JsonStat> matchByPrimarySurface;


    public JsonStat getSeasonWin() {
        return seasonWin;
    }

    public void setSeasonWin(JsonStat seasonWin) {
        this.seasonWin = seasonWin;
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
