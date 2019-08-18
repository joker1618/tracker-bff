package com.stats.tracker.be.controller.wrc6;

import com.stats.tracker.be.restModel.out.stats.Wrc6StatsSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wrc6/stats")
public class StatsController extends AWrc6Controller {

    @GetMapping("/summary")
    public ResponseEntity<Wrc6StatsSummary> getSummaryStats() {
        Wrc6StatsSummary stats = statsService.computeSummaryStats();
        return ResponseEntity.ok(stats);
    }

//    @GetMapping("/cars")
//    public ResponseEntity<List<Wrc6Car>> getCars() {
//        //todo impl
//        return null;
//    }
//
//    @GetMapping("/countries")
//    public ResponseEntity<List<Wrc6Country>> getCountries() {
//        //todo impl
//        return null;
//    }

}
