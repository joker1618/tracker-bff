package com.stats.tracker.be.controller.wrc6;

import com.stats.tracker.be.restModel.in.JsonMatchAdd;
import com.stats.tracker.be.restModel.out.JsonSeason;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wrc6/data")
public class DataController extends AWrc6Controller {

//    @GetMapping("/season/getInProgress")
//    public ResponseEntity<JsonSeason> getSeasonInProgress() {
//        JsonSeason os = dataService.getSeasonInProgress();
//        return os == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(os);
//    }
//
//    @GetMapping("/season/create")
//    public ResponseEntity<JsonSeason> createSeason() {
//        return ResponseEntity.ok(dataService.createNewSeason());
//    }
//
//    @GetMapping("/season/closeInProgress")
//    public ResponseEntity<Void> closeSeasonInProgress() {
//        dataService.closeSeasonInProgress();
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/rally/closeInProgress")
//    public ResponseEntity<JsonSeason> closeRallyInProgress() {
//        dataService.closeRallyInProgress();
//        return getSeasonInProgress();
//    }
//
//    @PostMapping("/match/add")
//    public ResponseEntity<JsonSeason> addMatch(@RequestBody JsonMatchAdd match) {
//        dataService.addMatch(match);
//        return getSeasonInProgress();
//    }

}
