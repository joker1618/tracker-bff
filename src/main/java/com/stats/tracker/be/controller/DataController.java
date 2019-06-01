package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import com.stats.tracker.be.datalayer.wrc.entities.WrcDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping("/season/getOpened")
    public void getOpenedSeason() {
        //todo impl
    }

    @GetMapping("/season/create")
    public void createSeason() {
        //todo impl
    }

    @GetMapping("/season/close")
    public void closeSeason(@RequestParam long seasonID) {
        //todo impl
    }

    @GetMapping("/rally/create")
    public void createRally(@RequestParam long seasonID) {
        //todo impl
    }
    @GetMapping("/rally/close")
    public void closeRally(@RequestParam long rallyID) {
        //todo impl
    }

    @GetMapping("/match/add")
    public void addMatch() {
        //todo impl
    }

}
