package com.stats.tracker.be.service.wrc6;

import com.stats.tracker.be.datalayer.wrc6.entities.*;
import com.stats.tracker.be.restModel.out.stats.JsonStat;
import com.stats.tracker.be.restModel.out.stats.Wrc6StatsSummary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import xxx.joker.libs.core.files.JkFiles;
import xxx.joker.libs.core.lambdas.JkStreams;

import java.util.*;
import java.util.function.Function;

@Service
public class Wrc6StatsService extends AWrc6Service {


    public Wrc6StatsService() {



    }

    public Wrc6StatsSummary computeSummaryStats() {
        Wrc6StatsSummary stats = computeStats(matchRepo.findAll(), rallyRepo.getClosedRallies());
        stats.setSeasonWin(countValues("", seasonRepo.getSeasonsClosed(), Wrc6Season::getWinner));
        return stats;
    }
    public Wrc6StatsSummary computeSeasonStats(Wrc6Season season) {
        List<Wrc6Match> matches = JkStreams.flatMap(season.getRallies(), Wrc6Rally::getMatches);
        Wrc6StatsSummary stats = computeStats(matches, season.getRallies());
        int vf = season.getWinner().equals(driverRepo.getFede()) ? 1 : 0;
        int vb = season.getWinner().equals(driverRepo.getBomber()) ? 1 : 0;
        stats.setSeasonWin(new JsonStat("Season win", vf, vb));
        return stats;
    }

    private Wrc6StatsSummary computeStats(List<Wrc6Match> matches, List<Wrc6Rally> rallies) {
        JsonStat stageWin = createWinsStat("Stage win", matches);

        List<JsonStat> byCountry = new ArrayList<>();
        Map<Wrc6Country, List<Wrc6Match>> byCountryMap = JkStreams.toMap(matches, m -> m.getStage().getCountry());
        List<Wrc6Country> countries = countryRepo.findAll();
        for (Wrc6Country country : countries) {
            byCountry.add(createWinsStat(country.getName(), byCountryMap.get(country)));
        }

        Wrc6StatsSummary toRet = new Wrc6StatsSummary();
        toRet.setMatchWin(stageWin);
        toRet.setMatchByCountry(byCountry);
        byCountry = new ArrayList<>();
        Map<Wrc6Country, List<Wrc6Rally>> rallyMap = JkStreams.toMap(rallies, Wrc6Rally::getCountry);
        for (Wrc6Country country : countries) {
            byCountry.add(createWinsStatRally(country.getName(), rallyMap.get(country)));
        }
        toRet.setRallyWin(createWinsStatRally("Rally win", rallies));
        toRet.setRallyByCountry(byCountry);

        return toRet;
    }

    private JsonStat createWinsStatRally(String label, List<Wrc6Rally> mlist) {
        Wrc6Driver fede = driverRepo.getFede();
        Wrc6Driver bomber = driverRepo.getBomber();

        int valFede = countValuesRally(fede, mlist);
        int valBomber = countValuesRally(bomber, mlist);

        return new JsonStat(label, valFede, valBomber);
    }
    private JsonStat createWinsStat(String label, List<Wrc6Match> mlist) {
        Wrc6Driver fede = driverRepo.getFede();
        Wrc6Driver bomber = driverRepo.getBomber();

        int valFede = countValues(fede, mlist);
        int valBomber = countValues(bomber, mlist);

        return new JsonStat(label, valFede, valBomber);
    }
    private int countValues(Wrc6Driver driver, List<Wrc6Match> matches) {
        return matches == null ? 0 : JkStreams.filter(matches, m -> m.getWinner().equals(driver)).size();
    }
    private int countValuesRally(Wrc6Driver driver, List<Wrc6Rally> rallies) {
        return rallies == null ? 0 : JkStreams.filter(rallies, m -> m.getWinner().equals(driver)).size();
    }
    private <T> JsonStat countValues(String label, List<T> list, Function<T, Wrc6Driver> mapper) {
        int valFede = JkStreams.mapFilter(list, mapper, d -> driverRepo.getFede().equals(d)).size();
        int valBomber = JkStreams.mapFilter(list, mapper, d -> driverRepo.getBomber().equals(d)).size();
        return new JsonStat(label, valFede, valBomber);
    }


}
