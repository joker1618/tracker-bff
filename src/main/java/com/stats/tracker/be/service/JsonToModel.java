package com.stats.tracker.be.service;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcDriver;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcMatch;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcRally;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcSeason;
import com.stats.tracker.be.restModel.in.JsonMatchAdd;
import com.stats.tracker.be.restModel.out.JsonSeason;
import com.stats.tracker.be.restModel.out.JsonStat;
import org.springframework.stereotype.Service;

@Service
public class JsonToModel extends AbstractService {

    public JsonSeason toJsonWrcSeason(WrcSeason season) {
        if(season == null)  return null;

        WrcDriver dfede = driverRepo.getFede();
        WrcDriver dbomber = driverRepo.getBomber();

        JsonSeason js = new JsonSeason();
        js.setStartTime(season.getStartTm());
        js.setEndTime(season.getEndTm());

        js.setRallyInProgress(rallyRepo.getRallyInProgress());

        js.setRemainingCountries(countryRepo.findAll());

        int wRallyFede = 0;
        int wRallyBomber = 0;
        int wStageFede = 0;
        int wStageBomber = 0;
        for (WrcRally rally : season.getRallies()) {
            int wfede = (int) rally.getMatches().stream().filter(m -> m.getWinner().equals(dfede)).count();
            int wbomber = (int) rally.getMatches().stream().filter(m -> m.getWinner().equals(dbomber)).count();
            int comp = wfede - wbomber;
            js.getRallyResults().add(new JsonStat(rally.getCountry().getName(), wfede, wbomber));
            js.getRemainingCountries().remove(rally.getCountry());
            if(rally.getWinner() != null) {
                wRallyFede += (comp > 0 ? 1 : 0);
                wRallyBomber += (comp < 0 ? 1 : 0);
            }
            wStageFede += wfede;
            wStageBomber += wbomber;
        }
        js.setTotStage(new JsonStat("Stage win", wStageFede, wStageBomber));
        js.setTotRally(new JsonStat("Rally win", wRallyFede, wRallyBomber));

        return js;
    }

    public WrcMatch toModelJsonMatchAdd(JsonMatchAdd json) {
        // todo impl
        return null;
    }
}
