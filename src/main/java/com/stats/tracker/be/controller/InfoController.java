package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.*;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController extends AbstractController {

    @GetMapping("/drivers")
    public ResponseEntity<List<WrcDriver>> getDrivers() {
        return ResponseEntity.ok(driverRepo.findAll());
    }

    @GetMapping("/cars")
    public ResponseEntity<List<WrcCar>> getCars() {
        return ResponseEntity.ok(carRepo.findAll());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<WrcCountry>> getCountries() {
        return ResponseEntity.ok(countryRepo.findAll());
    }

    @GetMapping("/surfaces")
    public ResponseEntity<List<WrcSurface>> getSurface() {
        return ResponseEntity.ok(surfaceRepo.findAll());
    }

    @GetMapping("/surfaces/groundTypes")
    public ResponseEntity<List<WrcGroundType>> getGroundTypes() {
        return ResponseEntity.ok(groundTypeRepo.findAll());
    }

    @GetMapping("/raceTimes")
    public ResponseEntity<List<WrcRaceTime>> getRaceTimes() {
        return ResponseEntity.ok(raceTimeRepo.findAll());
    }

    @GetMapping("/weathers")
    public ResponseEntity<List<WrcWeather>> getWeathers() {
        return ResponseEntity.ok(weatherRepo.findAll());
    }

    @GetMapping("/stages")
    public ResponseEntity<List<WrcStage>> getStages() {
        return ResponseEntity.ok(stageRepo.findAll());
    }

    @GetMapping("/seasons")
    public ResponseEntity<List<WrcSeason>> getSeasons() {
        return ResponseEntity.ok(seasonRepo.findAll());
    }

    @GetMapping("/rallies")
    public ResponseEntity<List<WrcRally>> getRallies() {
        return ResponseEntity.ok(rallyRepo.findAll());
    }

    @GetMapping("/matches")
    public ResponseEntity<List<WrcMatch>> getMatches() {
        return ResponseEntity.ok(matchRepo.findAll());
    }


}
