package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.entities.WrcDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

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
