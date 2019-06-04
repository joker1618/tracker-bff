package com.stats.tracker.be.service;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.in.JsonMatchAdd;
import com.stats.tracker.be.restModel.out.JsonSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xxx.joker.libs.core.lambdas.JkStreams;
import xxx.joker.libs.core.utils.JkStruct;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DataService extends AbstractService {

    @Autowired
    private JsonToModel jsonToModel;

    public JsonSeason getSeasonInProgress() {
        WrcSeason season = seasonRepo.getSeasonInProgress();
        return jsonToModel.toJsonWrcSeason(season);
    }

    public JsonSeason createNewSeason() {
        WrcSeason sp = seasonRepo.getSeasonInProgress();
        if(sp != null) {
            throw new GenericException("Unable to create new season: season in progress found!\n{}", sp);
        }
        WrcSeason s = new WrcSeason();
        s.setStartTm(LocalDateTime.now());
        seasonRepo.save(s);

        return getSeasonInProgress();
    }

    public void closeSeasonInProgress() {
        WrcSeason sp = seasonRepo.getSeasonInProgress();
        if(sp == null) {
            throw new GenericException("Unable to close season: season in progress not found!");
        }
        WrcRally rp = rallyRepo.getRallyInProgress();
        if(rp != null) {
            throw new GenericException("Unable to close season: rally in progress found!\n{}", rp);
        }

        WrcDriver winner = computeWinner(sp);
        if(winner == null) {
            throw new GenericException("Unable to close season: winner not defined!");
        }

        sp.setWinner(winner);
        sp.setEndTm(LocalDateTime.now());
        seasonRepo.save(sp);
    }

    public JsonSeason closeRallyInProgress() {
        WrcRally rp = rallyRepo.getRallyInProgress();
        if(rp == null) {
            throw new GenericException("Unable to close rally: rally in progress not found!");
        }

        WrcDriver winner = computeWinner(rp);
        if(winner == null) {
            throw new GenericException("Unable to close rally: winner not defined!");
        }

        rp.setWinner(winner);
        rallyRepo.save(rp);

        return getSeasonInProgress();
    }

    public void addMatch(JsonMatchAdd match) {
        WrcRally rp = rallyRepo.getRallyInProgress();
        if(rp == null) {
            throw new GenericException("Unable to add match: rally in progress not found! {}", match);
        }
        WrcMatch wrcMatch = jsonToModel.toModelJsonMatchAdd(match);

//        throw new GenericException("Season already created!");

    }

    private WrcDriver computeWinner(WrcRally rally) {
        Map<WrcDriver, List<WrcMatch>> map = JkStreams.toMap(rally.getMatches(), WrcMatch::getWinner);
        return getWinner(map);
    }

    private <T extends AbstractEntity> WrcDriver getWinner(Map<WrcDriver, List<T>> map) {
        WrcDriver fede = driverRepo.getFede();
        WrcDriver bomber = driverRepo.getBomber();
        int wf = collSize(map.get(fede));
        int wb = collSize(map.get(bomber));
        return wf > wb ? fede : wf < wb ? bomber : null;
    }

    private WrcDriver computeWinner(WrcSeason season) {
        // Compare rally win
        Map<WrcDriver, List<WrcRally>> map = JkStreams.toMap(season.getRallies(), WrcRally::getWinner, r -> r, WrcRally::hasWinner);
        WrcDriver winner = getWinner(map);

        // Compare stage win
        if(winner == null) {
            List<WrcMatch> matches = JkStreams.flatMap(season.getRallies(), WrcRally::getMatches);
            Map<WrcDriver, List<WrcMatch>> matchMap = JkStreams.toMap(matches, WrcMatch::getWinner);
            winner = getWinner(matchMap);
        }

        if(winner == null && season.getRallies().size() == countryRepo.count()) {
            WrcRally lastRally = JkStruct.getLastElem(season.getRallies());
            WrcDriver fede = driverRepo.getFede();
            WrcDriver bomber = driverRepo.getBomber();
            winner = lastRally.getWinner().equals(fede) ? bomber : fede;
        }

        return winner;
    }

    private int collSize(Collection coll) {
        return coll == null ? 0 : coll.size();
    }
}
