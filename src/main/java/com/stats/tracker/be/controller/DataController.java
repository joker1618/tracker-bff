package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.JsonSeason;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController extends AbstractController {

    @GetMapping("/season/getOpened")
    public ResponseEntity<WrcSeason> getOpenedSeason() {
        WrcSeason os = seasonRepo.getOpenedSeason();
        return os == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(os);
    }

    @GetMapping("/season/getOpened2")
    public ResponseEntity<JsonSeason> getOpenedSeason2() {
        WrcSeason os = seasonRepo.getOpenedSeason();
        JsonSeason json = new JsonSeason();
        json.setStr("klklLLLL");
        json.getRallies().add(new JsonSeason.JsonRally("ita", 2, 3));
        json.getRallies().add(new JsonSeason.JsonRally("fra", 12, 3));
        json.getRallies().add(new JsonSeason.JsonRally("rte", null, null));
        return os == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(json);
    }

    @GetMapping("/season/create")
    public ResponseEntity<WrcSeason> createSeason() {
        if(getOpenedSeason().getStatusCode() == HttpStatus.NOT_FOUND) {
            WrcSeason season = new WrcSeason();
            WrcSeason saved = seasonRepo.save(season);
            return ResponseEntity.ok(saved);
        }

        throw new GenericException("Season already created!");
    }

    @GetMapping("/season/close")
    public ResponseEntity<WrcSeason> closeSeason(@RequestParam("seasonID") long seasonID) {
        WrcSeason s = seasonRepo.getOne(seasonID);
        s.setFinished(true);
        s.getRallies().forEach(r -> r.setFinished(true));
        seasonRepo.save(s);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/rally/create")
//    public ResponseEntity<WrcRally> createRally(@RequestParam("seasonID") long seasonID, @RequestParam("country") String country) {
//        WrcRally rally = new WrcRally();
//        rally.setCountry(countryRepo.findByName(country));
//        seasonRepo.getOne(seasonID).getRallies().ad
//
//        return ResponseEntity.ok(rally);
//    }

    @GetMapping("/rally/close")
    public void closeRally(@RequestParam long rallyID) {
        //todo impl
    }

    @GetMapping("/match/add")
    public void addMatch() {
        //todo impl
    }

}
