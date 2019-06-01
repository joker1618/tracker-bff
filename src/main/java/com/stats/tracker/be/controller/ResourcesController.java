package com.stats.tracker.be.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @GetMapping("/countryFlag")
    public void getCountryFlag() {
        //todo impl
    }

    @GetMapping("/stageMap")
    public void getStageMap() {
        //todo impl
    }



}
