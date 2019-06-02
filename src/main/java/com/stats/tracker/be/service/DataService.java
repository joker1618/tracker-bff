package com.stats.tracker.be.service;

import com.stats.tracker.be.datalayer.wrc.entities.WrcSeason;
import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.JsonMatch;
import com.stats.tracker.be.restModel.JsonSeason;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DataService extends AbstractService {

    public JsonSeason getSeasonInProgress() {
        //todo impl
        return null;
    }

    public JsonSeason createNewSeason() {
        //todo impl
//        throw new GenericException(HttpStatus.BAD_REQUEST, "Season already created!");

        return null;
    }

    public void closeSeasonInProgress() {
        //todo impl
//        throw new GenericException(HttpStatus.BAD_REQUEST, "Season already created!");

    }

    public void closeRallyInProgress() {
        //todo impl
//        throw new GenericException(HttpStatus.BAD_REQUEST, "Season already created!");

    }

    public void addMatch(JsonMatch match) {
        //todo impl
//        throw new GenericException(HttpStatus.BAD_REQUEST, "Season already created!");

    }
}
