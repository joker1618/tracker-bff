package com.stats.tracker.be.controller;

import com.stats.tracker.be.datalayer.RepoManager;
import com.stats.tracker.be.datalayer.wrc6.entities.*;
import com.stats.tracker.be.datalayer.wrc6.repo.Wrc6Repo;
import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.out.JsonStat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.util.RepoUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static xxx.joker.libs.core.utils.JkConsole.display;

@RestController
@RequestMapping("dev")
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

    @GetMapping("/genericException")
    public ResponseEntity<WrcWeather> getGenericException() {
        throw new GenericException(HttpStatus.PERMANENT_REDIRECT, "pippo {}", "pluto");
//        throw new GenericException(new Exception("exc"), HttpStatus.BAD_REQUEST, "pippo {}", "pluto");
    }

    @GetMapping("/winStats")
    public ResponseEntity<JsonStat> getWinStats() {

        WrcDriver fede = driverRepo.getFede();
        WrcDriver bomber = driverRepo.getBomber();
        int valFede = matchRepo.numMatchesWin(fede);
        int valBomber = matchRepo.numMatchesWin(bomber);
//        int valFede = matchRepo.numMatchesWin(driverRepo.getFede());
//        int valBomber = matchRepo.numMatchesWin(driverRepo.getBomber());
//        display("num matches: {}", matchRepo.numMatchesWin(fede));
//        display("num matches fede: {}", matchRepo.numMatchesWin(fede.getJpaID()));
//        display("num matches bomber: {}", matchRepo.numMatchesWin(bomber.getJpaID()));
//        display("num matches sss: {}", matchRepo.numMatchesWin(fede));
        return ResponseEntity.ok(new JsonStat("Rallt win", valFede, valBomber));
    }

    private int numMatchesWin(List<WrcMatch> matches, WrcDriver driver) {
        return JkStreams.filter(matches, m -> m.getWinner().equals(driver)).size();
    }

    @GetMapping("/null")
    public ResponseEntity<Object> getNullResponse() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/shutdown")
    public void shutdown() {
        SpringApplication.exit(context);
    }

    @GetMapping("/initJpa")
    public String initJpa() throws IOException {
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

    @GetMapping("/jpaToRepo")
    public String jpaToRepo() throws IOException {
        Wrc6Repo repoWrc6 = repoManager.getWrc6Repo();

        repoWrc6.clearAll();

        carRepo.findAll().forEach(repoWrc6::add);
        driverRepo.findAll().forEach(repoWrc6::add);
        weatherRepo.findAll().forEach(repoWrc6::add);
        raceTimeRepo.findAll().forEach(repoWrc6::add);
        countryRepo.findAll().forEach(repoWrc6::add);
        groundTypeRepo.findAll().forEach(repoWrc6::add);
        groundMixRepo.findAll().forEach(repoWrc6::add);
        surfaceRepo.findAll().forEach(repoWrc6::add);
        stageRepo.findAll().forEach(repoWrc6::add);
        matchRepo.findAll().forEach(repoWrc6::add);
        rallyRepo.findAll().forEach(repoWrc6::add);
        seasonRepo.findAll().forEach(repoWrc6::add);

        repoWrc6.commit();


        return "END";
    }

    @GetMapping("/repoToJpa")
    public String repoToJpa() throws IOException {
        Wrc6Repo repoWrc6 = repoManager.getWrc6Repo();

        carRepo.saveAll(repoWrc6.getList(WrcCar.class));
        driverRepo.saveAll(repoWrc6.getList(WrcDriver.class));
        weatherRepo.saveAll(repoWrc6.getList(WrcWeather.class));
        raceTimeRepo.saveAll(repoWrc6.getList(WrcRaceTime.class));
        countryRepo.saveAll(repoWrc6.getList(WrcCountry.class));
        groundTypeRepo.saveAll(repoWrc6.getList(WrcGroundType.class));
        groundMixRepo.saveAll(repoWrc6.getList(WrcGroundMix.class));
        surfaceRepo.saveAll(repoWrc6.getList(WrcSurface.class));
        stageRepo.saveAll(repoWrc6.getList(WrcStage.class));
        matchRepo.saveAll(repoWrc6.getList(WrcMatch.class));
        rallyRepo.saveAll(repoWrc6.getList(WrcRally.class));
        seasonRepo.saveAll(repoWrc6.getList(WrcSeason.class));

        return "END";
    }

    @GetMapping("/showRepo")
    public String showRepo() throws IOException {
        Collection<Set<RepoEntity>> values = repoManager.getWrc6Repo().getDataSets().values();
        String strJoin = JkStreams.join(values, "\n\n", RepoUtil::formatEntities);
        display(strJoin);
        return  strJoin;
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

    }

//    private List<WrcGroundType> loadGroundTypes() throws IOException {
//        List<String> lines = JkFiles.readLines(new ClassPathResource(FN_GROUND_TYPES).getInputStream());
//        List<WrcGroundType> toRet = new ArrayList<>();
//        for (String line : lines) {
//            toRet.add(new WrcGroundType(line));
//        }
//        return toRet;
//    }


}
