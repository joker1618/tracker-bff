package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.entities.*;
import com.stats.tracker.be.datalayer.wrc.entities.WrcGroundMix;
import com.stats.tracker.be.datalayer.wrc.entities.WrcGroundType;
import com.stats.tracker.be.datalayer.wrc.entities.WrcSurface;
import com.stats.tracker.be.exception.GenericException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xxx.joker.libs.core.files.JkFiles;
import xxx.joker.libs.core.lambdas.JkStreams;
import xxx.joker.libs.core.utils.JkStrings;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static xxx.joker.libs.core.utils.JkConsole.display;

@RestController
@RequestMapping("config")
public class TrackerConfig extends AbstractController {

    private static final String SETUP_FILES_FOLDER = "setup";
    private static final String FN_CARS = SETUP_FILES_FOLDER + "/cars.csv";
    private static final String FN_WEATHERS = SETUP_FILES_FOLDER + "/weathers.csv";
    private static final String FN_RACE_TIMES = SETUP_FILES_FOLDER + "/race_times.csv";
    private static final String FN_DRIVERS = SETUP_FILES_FOLDER + "/drivers.csv";
    private static final String FN_COUNTRIES = SETUP_FILES_FOLDER + "/countries.csv";
    private static final String FN_STAGES = SETUP_FILES_FOLDER + "/stages.csv";
    private static final String FN_GROUND_TYPES = SETUP_FILES_FOLDER + "/ground_types.csv";
    private static final String FN_MATCHES = SETUP_FILES_FOLDER + "/matches.csv";


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/a")
    public ResponseEntity<List<WrcDriver>> a() {
        return ResponseEntity.ok(driverRepo.findAll());
    }
    @GetMapping("/b")
    public ResponseEntity<List<WrcCountry>> b() {
        return ResponseEntity.ok(countryRepo.findAll());
    }
    @GetMapping("/c")
    public ResponseEntity<WrcWeather> c() {
//        return ResponseEntity.ok(surfaceRepo.findAll());
        throw new GenericException(HttpStatus.PERMANENT_REDIRECT, "pippo {}", "pluto");
//        throw new GenericException(new Exception("exc"), HttpStatus.BAD_REQUEST, "pippo {}", "pluto");
    }
    @GetMapping("/d")
    public ResponseEntity<String> d() {
        return ResponseEntity.ok("<html><head></head><body><h1>fede</h1></body></html>");
    }
    @GetMapping("/e")
    public ResponseEntity<List<WrcStage>> e() {
        return ResponseEntity.ok(stageRepo.getStages("italy"));
    }
//    @GetMapping("/en")
//    public RestResponse<List> en() {
//        return RestResponse.ok(stageRepo.getStages("italy"));
//    }
    @GetMapping("/f")
    public ResponseEntity<List<WrcStage>> f() {
        return ResponseEntity.ok(stageRepo.getStages("notExists"));
    }
    @GetMapping("/null")
    public ResponseEntity<Object> mnull() {
        return ResponseEntity.ok(null);
    }


    @GetMapping("/shutdown")
    public void shutdown() {

        SpringApplication.exit(context);
    }

    @GetMapping("/initModel")
    public String initModel() throws IOException {
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

        loadAllMatches();

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
                if(found.getGroundPerc() > 0.5) {
                    surface.setPrimaryGround(found);
                } else {
                    surface.setSecondaryGround(found);
                }
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

    private List<WrcGroundType> loadGroundTypes() throws IOException {
        List<String> lines = JkFiles.readLines(new ClassPathResource(FN_GROUND_TYPES).getInputStream());
        List<WrcGroundType> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new WrcGroundType(line));
        }
        return toRet;
    }

    private void loadAllMatches() throws IOException {
        List<String> lines = JkFiles.readLines(new ClassPathResource(FN_MATCHES).getInputStream());
//        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_MATCHES));
        lines.remove(0);
        WrcSeason season = null;
        long prevSeason = -1;
        long prevRally = -1;
        WrcRally rally = null;

        for (String line : lines) {
            String[] row = JkStrings.splitArr(line, "|");
            WrcMatch match = new WrcMatch();
            match.setMatchTime(LocalDateTime.now());
            WrcCountry country = countryRepo.findByName(row[0]);
            long seasonId = Long.parseLong(row[1]);
            long rallyId = Long.parseLong(row[2]);

            if(prevRally != rallyId) {
                if(rally != null) {
                    rallyRepo.save(rally);
                    season.getRallies().add(rally);
                }
                rally = new WrcRally();
                rally.setWinner(driverRepo.findByName(row[14]));
                rally.setCountry(country);
                prevRally = rallyId;
            }

            if(prevSeason != seasonId) {
                if(season != null) {
                    seasonRepo.save(season);
                }
                season = seasonRepo.save(new WrcSeason());
                season.setStartTm(LocalDateTime.parse(row[12]));
                if(StringUtils.isNotBlank(row[13])) {
                    season.setEndTm(LocalDateTime.parse(row[13]));
                    season.setWinner(driverRepo.findByName(row[15]));
                }
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
            season.getRallies().add(rally);
            seasonRepo.save(season);
        }

        // Set rallyID and seasonID
        for (WrcSeason s : seasonRepo.findAll()) {
            for (WrcRally r : s.getRallies()) {
                r.getMatches().forEach(m -> m.setRallyId(r.getId()));
                r.setSeasonId(s.getId());
            }
            seasonRepo.save(s);
        }

    }


}
