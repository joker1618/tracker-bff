package com.stats.tracker.be.controller.wrc6;

import com.stats.tracker.be.datalayer.wrc6.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wrc6/info")
public class InfoController extends AWrc6Controller {

    @GetMapping("/drivers")
    public ResponseEntity<List<Wrc6Driver>> getDrivers() {
        return ResponseEntity.ok(driverRepo.findAll());
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Wrc6Car>> getCars() {
        return ResponseEntity.ok(carRepo.findAll());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<Wrc6Country>> getCountries() {
        return ResponseEntity.ok(countryRepo.findAll());
    }

    @GetMapping("/surfaces")
    public ResponseEntity<List<Wrc6Surface>> getSurface() {
        return ResponseEntity.ok(surfaceRepo.findAll());
    }

    @GetMapping("/surfaces/groundTypes")
    public ResponseEntity<List<Wrc6GroundType>> getGroundTypes() {
        return ResponseEntity.ok(groundTypeRepo.findAll());
    }

    @GetMapping("/raceTimes")
    public ResponseEntity<List<Wrc6RaceTime>> getRaceTimes() {
        return ResponseEntity.ok(raceTimeRepo.findAll());
    }

    @GetMapping("/weathers")
    public ResponseEntity<List<Wrc6Weather>> getWeathers() {
        return ResponseEntity.ok(weatherRepo.findAll());
    }

    @GetMapping("/stages")
    public ResponseEntity<List<Wrc6Stage>> getStages() {
        return ResponseEntity.ok(stageRepo.findAll());
    }

    @GetMapping("/seasons")
    public ResponseEntity<List<Wrc6Season>> getSeasons() {
        return ResponseEntity.ok(seasonRepo.findAll());
    }

    @GetMapping("/rallies")
    public ResponseEntity<List<Wrc6Rally>> getRallies() {
        return ResponseEntity.ok(rallyRepo.findAll());
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Wrc6Match>> getMatches() {
        return ResponseEntity.ok(matchRepo.findAll());
    }


}
