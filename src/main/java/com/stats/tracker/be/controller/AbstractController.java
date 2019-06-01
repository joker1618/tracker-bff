package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.repo.*;
import com.stats.tracker.be.service.WrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

abstract class AbstractController {

    @Autowired
    protected WrcService service;

    @Autowired
    protected WrcCarRepo carRepo;
    @Autowired
    protected WrcWeatherRepo weatherRepo;
    @Autowired
    protected WrcRaceTimeRepo raceTimeRepo;
    @Autowired
    protected WrcMatchRepo matchRepo;
    @Autowired
    protected WrcRallyRepo rallyRepo;
    @Autowired
    protected WrcSeasonRepo seasonRepo;
    @Autowired
    protected WrcDriverRepo driverRepo;
    @Autowired
    protected WrcCountryRepo countryRepo;
    @Autowired
    protected WrcStageRepo stageRepo;
    @Autowired
    protected WrcGroundTypeRepo groundTypeRepo;
    @Autowired
    protected WrcGroundMixRepo groundMixRepo;
    @Autowired
    protected WrcSurfaceRepo surfaceRepo;

    @Autowired
    protected ApplicationContext context;
}
