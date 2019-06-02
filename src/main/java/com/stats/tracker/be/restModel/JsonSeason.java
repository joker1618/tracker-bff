package com.stats.tracker.be.restModel;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.entities.WrcRally;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonSeason implements Serializable {

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private List<JsonStat> rallies;
    private JsonStat totStage;
    private JsonStat totRally;

    private List<WrcCountry> remainingCountries;
    private WrcRally rallyInProgress;




}
