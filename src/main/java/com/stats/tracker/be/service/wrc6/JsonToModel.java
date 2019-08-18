package com.stats.tracker.be.service.wrc6;

import com.stats.tracker.be.datalayer.JpaEntity;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Rally;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Season;
import com.stats.tracker.be.restModel.out.JsonSeason;
import com.stats.tracker.be.restModel.out.stats.JsonStat;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class JsonToModel extends AWrc6Service {

    public JsonSeason toJsonWrcSeason(Wrc6Season season) {
        if(season == null)  return null;

        Wrc6Driver dfede = driverRepo.getFede();
        Wrc6Driver dbomber = driverRepo.getBomber();

        JsonSeason js = new JsonSeason();
        js.setStartTime(season.getStartTm());
        js.setEndTime(season.getEndTm());

        js.setRallyInProgress(rallyRepo.getRallyInProgress());

        js.setRemainingCountries(countryRepo.findAll());

        int wRallyFede = 0;
        int wRallyBomber = 0;
        int wStageFede = 0;
        int wStageBomber = 0;
        for (Wrc6Rally rally : season.getRallies()) {
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

    public <T extends JpaEntity> JsonStat toJsonStat(String label, Map<Wrc6Driver, Collection<T>> map) {
        List<T> el = Collections.emptyList();
        int valFede = map.getOrDefault(driverRepo.getFede(), el).size();
        int valBomber = map.getOrDefault(driverRepo.getBomber(), el).size();
        return new JsonStat(label, valFede, valBomber);
    }
}
