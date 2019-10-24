package com.stats.tracker.be.service.wrc6;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;
import com.stats.tracker.be.datalayer.wrc6.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

abstract class AWrc6Service {

    @Autowired
    protected Wrc6CarRepo carRepo;
    @Autowired
    protected Wrc6WeatherRepo weatherRepo;
    @Autowired
    protected Wrc6RaceTimeRepo raceTimeRepo;
    @Autowired
    protected Wrc6MatchRepo matchRepo;
    @Autowired
    protected Wrc6RallyRepo rallyRepo;
    @Autowired
    protected Wrc6SeasonRepo seasonRepo;
    @Autowired
    protected Wrc6DriverRepo driverRepo;
    @Autowired
    protected Wrc6CountryRepo countryRepo;
    @Autowired
    protected Wrc6StageRepo stageRepo;
    @Autowired
    protected Wrc6GroundTypeRepo groundTypeRepo;
    @Autowired
    protected Wrc6GroundMixRepo groundMixRepo;
    @Autowired
    protected Wrc6SurfaceRepo surfaceRepo;

    @Autowired
    protected ApplicationContext context;


}