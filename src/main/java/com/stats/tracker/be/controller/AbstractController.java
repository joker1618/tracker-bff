package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.RepoManager;
import com.stats.tracker.be.datalayer.wrc6.jpa.*;
import com.stats.tracker.be.service.DataService;
import com.stats.tracker.be.service.JsonToModel;
import com.stats.tracker.be.service.WrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

abstract class AbstractController {

    @Autowired
    protected WrcService wrcService;
    @Autowired
    protected DataService dataService;
    @Autowired
    private RepoManager repoManager;

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
    protected JsonToModel jsonToModel;

    @Autowired
    protected ApplicationContext context;
}
