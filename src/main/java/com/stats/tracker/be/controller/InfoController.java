package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.entities.WrcDriver;
import com.stats.tracker.be.datalayer.wrc.entities.WrcMatch;
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

}
