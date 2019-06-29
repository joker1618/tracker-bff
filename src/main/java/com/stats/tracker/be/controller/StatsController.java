package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc6.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc6.entities.WrcDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @GetMapping("/drivers")
    public ResponseEntity<List<WrcDriver>> getDrivers() {
        //todo impl
        return null;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<WrcCar>> getCars() {
        //todo impl
        return null;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<WrcCountry>> getCountries() {
        //todo impl
        return null;
    }

}
