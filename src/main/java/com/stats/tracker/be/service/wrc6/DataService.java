package com.stats.tracker.be.service.wrc6;

import com.stats.tracker.be.datalayer.JpaEntity;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Match;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Rally;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Season;
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
public class DataService extends AWrc6Service {

    @Autowired
    private JsonToModel jsonToModel;

    public JsonSeason getSeasonInProgress() {
        Wrc6Season season = seasonRepo.getSeasonInProgress();
        return jsonToModel.toJsonWrcSeason(season);
    }

    public JsonSeason createNewSeason() {
        Wrc6Season sp = seasonRepo.getSeasonInProgress();
        if(sp != null) {
            throw new GenericException("Unable to create new season: season in progress found!\n{}", sp);
        }
        Wrc6Season s = new Wrc6Season();
        s.setStartTm(LocalDateTime.now());
        seasonRepo.save(s);

        return getSeasonInProgress();
    }

    public void closeSeasonInProgress() {
        Wrc6Season sp = seasonRepo.getSeasonInProgress();
        if(sp == null) {
            throw new GenericException("Unable to close season: season in progress not found!");
        }
        Wrc6Rally rp = rallyRepo.getRallyInProgress();
        if(rp != null) {
            throw new GenericException("Unable to close season: rally in progress found!\n{}", rp);
        }

        Wrc6Driver winner = computeWinner(sp);
        if(winner == null) {
            throw new GenericException("Unable to close season: winner not defined!");
        }

        sp.setWinner(winner);
        sp.setEndTm(LocalDateTime.now());
        seasonRepo.save(sp);
    }

    public JsonSeason closeRallyInProgress() {
        Wrc6Rally rp = rallyRepo.getRallyInProgress();
        if(rp == null) {
            throw new GenericException("Unable to close rally: rally in progress not found!");
        }

        Wrc6Driver winner = computeWinner(rp);
        if(winner == null) {
            throw new GenericException("Unable to close rally: winner not defined!");
        }

        rp.setWinner(winner);
        rallyRepo.save(rp);

        return getSeasonInProgress();
    }

    public void addMatch(JsonMatchAdd match) {
        Wrc6Rally rp = rallyRepo.getRallyInProgress();
        if(rp == null) {
            throw new GenericException("Unable to add match: rally in progress not found! {}", match);
        }

//        throw new GenericException("Season already created!");

    }

    private Wrc6Driver computeWinner(Wrc6Rally rally) {
        Map<Wrc6Driver, List<Wrc6Match>> map = JkStreams.toMap(rally.getMatches(), Wrc6Match::getWinner);
        return getWinner(map);
    }

    private <T extends JpaEntity> Wrc6Driver getWinner(Map<Wrc6Driver, List<T>> map) {
        Wrc6Driver fede = driverRepo.getFede();
        Wrc6Driver bomber = driverRepo.getBomber();
        int wf = collSize(map.get(fede));
        int wb = collSize(map.get(bomber));
        return wf > wb ? fede : wf < wb ? bomber : null;
    }

    private Wrc6Driver computeWinner(Wrc6Season season) {
        // Compare rally win
        Map<Wrc6Driver, List<Wrc6Rally>> map = JkStreams.toMap(season.getRallies(), Wrc6Rally::getWinner, r -> r, Wrc6Rally::hasWinner);
        Wrc6Driver winner = getWinner(map);

        // Compare stage win
        if(winner == null) {
            List<Wrc6Match> matches = JkStreams.flatMap(season.getRallies(), Wrc6Rally::getMatches);
            Map<Wrc6Driver, List<Wrc6Match>> matchMap = JkStreams.toMap(matches, Wrc6Match::getWinner);
            winner = getWinner(matchMap);
        }

        if(winner == null && season.getRallies().size() == countryRepo.count()) {
            Wrc6Rally lastRally = JkStruct.getLastElem(season.getRallies());
            Wrc6Driver fede = driverRepo.getFede();
            Wrc6Driver bomber = driverRepo.getBomber();
            winner = lastRally.getWinner().equals(fede) ? bomber : fede;
        }

        return winner;
    }

    private int collSize(Collection coll) {
        return coll == null ? 0 : coll.size();
    }
}
