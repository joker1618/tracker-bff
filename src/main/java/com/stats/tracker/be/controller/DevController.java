package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.wrc.RepoManager;
import com.stats.tracker.be.datalayer.wrc.jkrepo.Wrc6Repo;
import com.stats.tracker.be.datalayer.wrc.jkrepo.entities.*;
import com.stats.tracker.be.datalayer.wrc.jpa.entities.*;
import com.stats.tracker.be.exception.GenericException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xxx.joker.libs.core.datetime.JkDateTime;
import xxx.joker.libs.core.files.JkFiles;
import xxx.joker.libs.core.lambdas.JkStreams;
import xxx.joker.libs.core.runtimes.JkReflection;
import xxx.joker.libs.core.utils.JkStrings;
import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.util.RepoUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static xxx.joker.libs.core.utils.JkConsole.display;

@RestController
@RequestMapping("config")
public class DevController extends AbstractController {

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
    private RepoManager repoManager;

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
        Wrc6Repo wrc6Repo = repoManager.getWrc6Repo();
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

    @GetMapping("/initModelJPA")
    public String initModel() throws IOException {
        if(!carRepo.findAll().isEmpty()) {
            return "JPA model already initialized";
        }

        carRepo.saveAll(loadCars());
        weatherRepo.saveAll(loadWeathers());
        raceTimeRepo.saveAll(loadRaceTimes());
        driverRepo.saveAll(loadDrivers());
        countryRepo.saveAll(loadCountries());
        groundTypeRepo.saveAll(loadGroundTypes());
        stageRepo.saveAll(loadStages());

        loadAllMatches();

        return "Initialized model JPA";
    }

    @GetMapping("/initJkRepoFromJPA")
    public String initJkRepoFromJPA(@RequestParam(required = false, defaultValue = "false") boolean commit) throws IOException {
        Map<Long, RepoEntity> jpaToRepoMap = new HashMap<>();

        Wrc6Repo repoWrc6 = repoManager.getWrc6Repo();

        List<WrcCar> allCars = carRepo.findAll();
        for (WrcCar car : allCars) {
            WrcCar6 car6 = JkReflection.copyFields(car, WrcCar6.class);
            car6 = repoWrc6.getByPkOrAdd(car6);
            jpaToRepoMap.put(car.getId(), car6);
        }

        List<WrcCountry> allCountries = countryRepo.findAll();
        for (WrcCountry country : allCountries) {
            WrcCountry6 country6 = JkReflection.copyFields(country, WrcCountry6.class);
            country6 = repoWrc6.getByPkOrAdd(country6);
            jpaToRepoMap.put(country.getId(), country6);
        }

        List<WrcRaceTime> allRaceTimes = raceTimeRepo.findAll();
        for (WrcRaceTime raceTime : allRaceTimes) {
            WrcRaceTime6 raceTime6 = JkReflection.copyFields(raceTime, WrcRaceTime6.class);
            raceTime6 = repoWrc6.getByPkOrAdd(raceTime6);
            jpaToRepoMap.put(raceTime.getId(), raceTime6);
        }

        List<WrcWeather> allWeathers = weatherRepo.findAll();
        for (WrcWeather weather : allWeathers) {
            WrcWeather6 weather6 = JkReflection.copyFields(weather, WrcWeather6.class);
            weather6 = repoWrc6.getByPkOrAdd(weather6);
            jpaToRepoMap.put(weather.getId(), weather6);
        }

        List<WrcGroundType> allGroundTypes = groundTypeRepo.findAll();
        for (WrcGroundType groundType : allGroundTypes) {
            WrcGroundType6 groundType6 = JkReflection.copyFields(groundType, WrcGroundType6.class);
            groundType6 = repoWrc6.getByPkOrAdd(groundType6);
            jpaToRepoMap.put(groundType.getId(), groundType6);
        }

        List<WrcDriver> allDrivers = driverRepo.findAll();
        for (WrcDriver driver : allDrivers) {
            WrcDriver6 driver6 = JkReflection.copyFields(driver, WrcDriver6.class);
            driver6 = repoWrc6.getByPkOrAdd(driver6);
            jpaToRepoMap.put(driver.getId(), driver6);
        }

        List<WrcGroundMix> allGroundMixs = groundMixRepo.findAll();
        for (WrcGroundMix groundMix : allGroundMixs) {
            WrcGroundMix6 groundMix6 = JkReflection.copyFields(groundMix, WrcGroundMix6.class);
            groundMix6.setGroundType((WrcGroundType6)jpaToRepoMap.get(groundMix.getGroundType().getId()));
            groundMix6 = repoWrc6.getByPkOrAdd(groundMix6);
            jpaToRepoMap.put(groundMix.getId(), groundMix6);
        }

        List<WrcSurface> allSurfaces = surfaceRepo.findAll();
        for (WrcSurface surface : allSurfaces) {
            WrcSurface6 surface6 = JkReflection.copyFields(surface, WrcSurface6.class);
            surface6.setPrimaryGround((WrcGroundMix6)jpaToRepoMap.get(surface.getPrimaryGround().getId()));
            if(surface.getSecondaryGround() != null) {
                surface6.setSecondaryGround((WrcGroundMix6) jpaToRepoMap.get(surface.getSecondaryGround().getId()));
            }
            surface6 = repoWrc6.getByPkOrAdd(surface6);
            jpaToRepoMap.put(surface.getId(), surface6);
        }

        List<WrcStage> allStages = stageRepo.findAll();
        for (WrcStage stage : allStages) {
            WrcStage6 stage6 = JkReflection.copyFields(stage, WrcStage6.class);
            stage6.setCountry((WrcCountry6) jpaToRepoMap.get(stage.getCountry().getId()));
            stage6.setSurface((WrcSurface6) jpaToRepoMap.get(stage.getSurface().getId()));
            stage6 = repoWrc6.getByPkOrAdd(stage6);
            jpaToRepoMap.put(stage.getId(), stage6);
        }

        List<WrcMatch> allMatchs = matchRepo.findAll();
        for (WrcMatch match : allMatchs) {
            WrcMatch6 match6 = JkReflection.copyFields(match, WrcMatch6.class);
            match6.setWeather((WrcWeather6) jpaToRepoMap.get(match.getWeather().getId()));
            match6.setRaceTime((WrcRaceTime6) jpaToRepoMap.get(match.getRaceTime().getId()));
            if(match.getCarFede() != null) {
                match6.setCarFede((WrcCar6) jpaToRepoMap.get(match.getCarFede().getId()));
                match6.setCarBomber((WrcCar6) jpaToRepoMap.get(match.getCarBomber().getId()));
            }
            match6.setWinner((WrcDriver6) jpaToRepoMap.get(match.getWinner().getId()));
            match6.setStage((WrcStage6) jpaToRepoMap.get(match.getStage().getId()));
            match6.setCreationTm(JkDateTime.of(match.getMatchTime()));

            match6 = repoWrc6.getByPkOrAdd(match6);
            jpaToRepoMap.put(match.getId(), match6);
        }

        List<WrcRally> allRallys = rallyRepo.findAll();
        for (WrcRally rally : allRallys) {
            WrcRally6 rally6 = JkReflection.copyFields(rally, WrcRally6.class);
            rally6.setCountry((WrcCountry6)jpaToRepoMap.get(rally.getCountry().getId()));
            rally6.setWinner((WrcDriver6) jpaToRepoMap.get(rally.getWinner().getId()));
            List<WrcMatch6> matches6 = JkStreams.map(rally.getMatches(), m -> (WrcMatch6) jpaToRepoMap.get(m.getId()));
            rally6.setMatches(matches6);
            rally6 = repoWrc6.getByPkOrAdd(rally6);
            jpaToRepoMap.put(rally.getId(), rally6);
        }

        List<WrcSeason> allSeasons = seasonRepo.findAll();
        for (WrcSeason season : allSeasons) {
            WrcSeason6 season6 = JkReflection.copyFields(season, WrcSeason6.class);
            if(season.getWinner() != null){
                season6.setWinner((WrcDriver6) jpaToRepoMap.get(season.getWinner().getId()));
            }
            List<WrcRally6> rallies6 = JkStreams.map(season.getRallies(), r -> (WrcRally6) jpaToRepoMap.get(r.getId()));
            season6.setRallies(rallies6);
            season6 = repoWrc6.getByPkOrAdd(season6);
            jpaToRepoMap.put(season.getId(), season6);
        }

        for (Set<RepoEntity> value : repoWrc6.getDataSets().values()) {
            display(RepoUtil.formatEntities(value)+"\n\n");
        }

        if(commit) {
            repoWrc6.commit();
        }

        return "Initialized repo from JPA";
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
            stage.setNumInRally(Integer.parseInt(split[2].trim()));
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
