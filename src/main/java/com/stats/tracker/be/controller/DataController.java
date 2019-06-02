package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import com.stats.tracker.be.restModel.JsonMatch;
import com.stats.tracker.be.restModel.JsonSeason;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
public class DataController extends AbstractController {

    @GetMapping("/season/getInProgress")
    public ResponseEntity<JsonSeason> getSeasonInProgress() {
        JsonSeason os = dataService.getSeasonInProgress();
        return os == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(os);
    }

    @GetMapping("/season/create")
    public ResponseEntity<JsonSeason> createSeason() {
        return ResponseEntity.ok(dataService.createNewSeason());
    }

    @GetMapping("/season/closeInProgress")
    public ResponseEntity<Void> closeSeasonInProgress() {
        dataService.closeSeasonInProgress();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rally/closeInProgress")
    public ResponseEntity<Void> closeRallyInProgress() {
        dataService.closeRallyInProgress();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/match/add")
    public ResponseEntity<Void> addMatch(@RequestBody JsonMatch match) {
        dataService.addMatch(match);
        return ResponseEntity.ok().build();
    }

}
