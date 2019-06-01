package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcGroundMix;
import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcGroundType;
import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcSurface;
import com.stats.tracker.be.datalayer.wrc.repo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xxx.joker.libs.core.files.JkFiles;
import xxx.joker.libs.core.format.JkOutput;
import xxx.joker.libs.core.lambdas.JkStreams;
import xxx.joker.libs.core.runtimes.JkReflection;
import xxx.joker.libs.core.utils.JkStrings;

import java.time.LocalDateTime;
import java.util.*;

import static xxx.joker.libs.core.utils.JkConsole.display;

@RestController
@RequestMapping("config")
public class TrackerConfig {

    private static final String SETUP_FILES_FOLDER = "setup";
    private static final String FN_CARS = SETUP_FILES_FOLDER + "/cars.csv";
    private static final String FN_WEATHERS = SETUP_FILES_FOLDER + "/weathers.csv";
    private static final String FN_RACE_TIMES = SETUP_FILES_FOLDER + "/race_times.csv";
    private static final String FN_DRIVERS = SETUP_FILES_FOLDER + "/drivers.csv";
    private static final String FN_COUNTRIES = SETUP_FILES_FOLDER + "/countries.csv";
    private static final String FN_STAGES = SETUP_FILES_FOLDER + "/stages.csv";
    private static final String FN_GROUND_TYPES = SETUP_FILES_FOLDER + "/ground_types.csv";
    private static final String FN_MATCHES = SETUP_FILES_FOLDER + "/matches.csv";


    @Autowired
    private WrcCarRepo carRepo;
    @Autowired
    private WrcWeatherRepo weatherRepo;
    @Autowired
    private WrcRaceTimeRepo raceTimeRepo;
    @Autowired
    private WrcMatchRepo matchRepo;
    @Autowired
    private WrcRallyRepo rallyRepo;
    @Autowired
    private WrcSeasonRepo seasonRepo;
    @Autowired
    private WrcDriverRepo driverRepo;
    @Autowired
    private WrcCountryRepo countryRepo;
    @Autowired
    private WrcStageRepo stageRepo;
    @Autowired
    private WrcGroundTypeRepo groundTypeRepo;
    @Autowired
    private WrcGroundMixRepo groundMixRepo;
    @Autowired
    private WrcSurfaceRepo surfaceRepo;

    @Autowired
    private ApplicationContext context;


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/a")
    public ResponseEntity<List<WrcDriver>> a() {
        WrcCountry country = countryRepo.findByName("Italy");
        AS as1 = JkReflection.copyFields(country, AS.class);
        display(JkOutput.formatObject(as1));
        AS as2 = JkReflection.copyFields(country, AS.class, "id=pid name");
        display("\n\n\n\n\n\n");
        display(JkOutput.formatObject(as2));

//        stageRepo.findAll().forEach(JkConsole::display);
//        display(countryRepo.findByName("SPAIN"));
//        JkOutput.formatCollection(countryRepo.findAll(), "country code order").forEach(JkConsole::display);

        return ResponseEntity.ok(driverRepo.findAll());
    }
    @GetMapping("/b")
    public ResponseEntity<List<WrcCountry>> b() {
        return ResponseEntity.ok(countryRepo.findAll());
    }
    @GetMapping("/c")
    public ResponseEntity<List<WrcSurface>> c() {
        return ResponseEntity.ok(surfaceRepo.findAll());
    }
    @GetMapping("/d")
    public ResponseEntity<List<WrcGroundMix>> d() {
        return ResponseEntity.ok(groundMixRepo.findAll());
    }


    @GetMapping("/shutdown")
    public void shutdown() {

        SpringApplication.exit(context);
    }

    @GetMapping("/initModel")
    public String initModel() {
        if(!carRepo.findAll().isEmpty()) {
            return "Already initialized";
        }

        carRepo.saveAll(loadCars());
        weatherRepo.saveAll(loadWeathers());
        raceTimeRepo.saveAll(loadRaceTimes());
        driverRepo.saveAll(loadDrivers());
        countryRepo.saveAll(loadCountries());
        groundTypeRepo.saveAll(loadGroundTypes());
        stageRepo.saveAll(loadStages());

        List<WrcMatch> wrcMatches = loadMatches();

        return "Initialization donee";
    }

    private List<WrcCar> loadCars() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_CARS));
        List<WrcCar> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcCar(line));
        }
        return toRet;
    }

    private List<WrcWeather> loadWeathers() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_WEATHERS));
        List<WrcWeather> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcWeather(line));
        }
        return toRet;
    }

    private List<WrcRaceTime> loadRaceTimes() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_RACE_TIMES));
        List<WrcRaceTime> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcRaceTime(line));
        }
        return toRet;
    }

    private List<WrcDriver> loadDrivers() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_DRIVERS));
        List<WrcDriver> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcDriver(line));
        }
        return toRet;
    }

    private List<WrcCountry> loadCountries() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_COUNTRIES));
        List<WrcCountry> toRet = new ArrayList<>();
        for (String line : lines) {
            String[] split = JkStrings.splitArr(line, "|");
            toRet.add(new WrcCountry(split[1], split[2], Integer.parseInt(split[0])));
        }
        return toRet;
    }

    private List<WrcStage> loadStages() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_STAGES));
        lines.removeIf(StringUtils::isBlank);
        List<WrcStage> toRet = new ArrayList<>();

        Map<String, WrcGroundType> gtMap = JkStreams.toMapSingle(groundTypeRepo.findAll(), gt -> gt.getGroundType().toLowerCase());
        List<WrcGroundMix> allMixesDistinct = new ArrayList<>();

        for (String line : lines) {
            String[] split = JkStrings.splitArr(line, "|");
            WrcStage stage = new WrcStage();
            stage.setCountry(countryRepo.findByName(split[0]));
            stage.setLocation(split[1]);
            stage.setNumInRally(Integer.parseInt(split[2]));
            stage.setLength(Integer.parseInt(split[3]));
            stage.setSpecialStage(Boolean.valueOf(split[5]));

            WrcSurface surface = new WrcSurface();

            for (String comp : JkStrings.splitArr(split[4], "--")) {
                String[] el = JkStrings.splitArr(comp, ":");
                WrcGroundMix gcomp = new WrcGroundMix(gtMap.get(el[0].toLowerCase()), Double.parseDouble(el[1]));
                WrcGroundMix found = JkStreams.findUnique(allMixesDistinct, gcomp::hasEqualsContent);
                if(found == null) {
                    found = groundMixRepo.save(gcomp);
                    allMixesDistinct.add(found);
                }
                surface.getGroundMixList().add(found);
            }

            WrcSurface found = JkStreams.findUnique(surfaceRepo.findAll(), surface::hasSameContent);
            if(found == null) {
                found = surfaceRepo.save(surface);
            }
            stage.setSurface(found);

            toRet.add(stage);
        }

        return toRet;
    }

    private List<WrcGroundType> loadGroundTypes() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_GROUND_TYPES));
        List<WrcGroundType> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcGroundType(line));
        }
        return toRet;
    }

    private List<WrcMatch> loadMatches() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_MATCHES));
        lines.remove(0);
        WrcSeason season = null;
        long prevSeason = -1;
        long prevRally = -1;
        WrcRally rally = null;
        boolean openedSeason = false;

        List<WrcMatch> toRet = new ArrayList<>();
        for (String line : lines) {
            String[] row = JkStrings.splitArr(line, "|");
            WrcMatch match = new WrcMatch();
            WrcCountry country = countryRepo.findByName(row[0]);
            long seasonId = Long.parseLong(row[1]);
            long rallyId = Long.parseLong(row[2]);

            if(!openedSeason && Boolean.valueOf(row[11])) {
                openedSeason = true;
            }

            if(prevRally != rallyId) {
                if(rally != null) {
                    rallyRepo.save(rally);
                    season.getRallies().add(rally);
                }
                rally = new WrcRally();
                rally.setCountry(country);
                prevRally = rallyId;
            }

            if(prevSeason != seasonId) {
                if(season != null) {
                    seasonRepo.save(season);
                }
                season = new WrcSeason();
                season.setStartTime(LocalDateTime.parse(row[12]));
                prevSeason = seasonId;
            }

            List<WrcStage> stages = stageRepo.getStages(country.getName().trim());
            match.setStage(stages.get(Integer.parseInt(row[3]) % stages.size()));
            match.setWinner(driverRepo.findByName(row[4]));
            if(StringUtils.isNotBlank(row[5])) {
                match.setCarFede(carRepo.findByModel(row[5]));
                match.setCarBomber(carRepo.findByModel(row[6]));
            }
            match.setWeather(weatherRepo.findByName(row[7].replace("_", " ")));
            match.setRaceTime(raceTimeRepo.findByName(row[8]));
            match.setMatchTime(LocalDateTime.parse(row[9]));
            matchRepo.save(match);

            rally.getMatches().add(match);
        }

        if(rally != null) {
            rallyRepo.save(rally);
            season.getRallies().add(rally);
            seasonRepo.save(season);
        }

        WrcSeason last = null;
        for (WrcSeason s : seasonRepo.findAll()) {
            Optional<WrcMatch> max = s.getRallies().stream().flatMap(r -> r.getMatches().stream()).max(Comparator.comparing(WrcMatch::getMatchTime));
            s.setEndTime(max.get().getMatchTime());
            last = seasonRepo.save(s);
        }

        if(openedSeason)    {
            last.setEndTime(null);
            seasonRepo.save(last);
        }

        return toRet;
    }


}
