package com.stats.tracker.be.controller.wrc6;

import com.stats.tracker.be.datalayer.wrc6.entities.*;
import com.stats.tracker.be.exception.GenericException;
import com.stats.tracker.be.restModel.out.stats.JsonStat;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.core.AliasRegistry;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static xxx.joker.libs.core.utils.JkConsole.display;

@RestController
@RequestMapping("/wrc6/dev")
public class DevController extends AWrc6Controller {

    private static final Logger LOG = LoggerFactory.getLogger(DevController.class);

    private static final String SETUP_FILES_FOLDER = "setup/wrc6";
    private static final String FN_CARS = SETUP_FILES_FOLDER + "/cars.csv";
    private static final String FN_WEATHERS = SETUP_FILES_FOLDER + "/weathers.csv";
    private static final String FN_RACE_TIMES = SETUP_FILES_FOLDER + "/race_times.csv";
    private static final String FN_DRIVERS = SETUP_FILES_FOLDER + "/drivers.csv";
    private static final String FN_COUNTRIES = SETUP_FILES_FOLDER + "/countries.csv";
    private static final String FN_STAGES = SETUP_FILES_FOLDER + "/stages.csv";
    private static final String FN_GROUND_TYPES = SETUP_FILES_FOLDER + "/ground_types.csv";
    private static final String FN_MATCHES = SETUP_FILES_FOLDER + "/matches.csv";
    private static final String FN_FIFA19_MATCHES = SETUP_FILES_FOLDER + "/fifa19_matches.csv";


    @GetMapping("/genericException")
    public ResponseEntity<Wrc6Weather> getGenericException() {
        throw new GenericException(HttpStatus.PERMANENT_REDIRECT, "pippo {}", "pluto");
//        throw new GenericException(new Exception("exc"), HttpStatus.BAD_REQUEST, "pippo {}", "pluto");
    }

    @GetMapping("/winStats")
    public ResponseEntity<JsonStat> getWinStats() {

        Wrc6Driver fede = driverRepo.getFede();
        Wrc6Driver bomber = driverRepo.getBomber();
        Wrc6Country sweden = countryRepo.findByName("sweden");
        int valFede = matchRepo.countWins(fede, sweden);
        int valBomber = matchRepo.countWins(bomber, sweden);
        List<Wrc6Match> mlist = matchRepo.getMatches(matchRepo.findAll().subList(0, 3));
        display(mlist);
//        List<Wrc6Rally> ss = matchRepo.countWins2(seasonRepo.findAll().get(0));
//        display(ss);
//        int valFede = matchRepo.countWins(fede);
//        int valBomber = matchRepo.countWins(bomber);
        return ResponseEntity.ok(new JsonStat("Stage win", valFede, valBomber));
    }

    private int numMatchesWin(List<Wrc6Match> matches, Wrc6Driver driver) {
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

//    @GetMapping("/jpaToRepo")
//    public String jpaToRepo() throws IOException {
//        Wrc6Repo repoWrc6 = repoManager.getWrc6Repo();
//
//        repoWrc6.clearAll();
//
//        carRepo.findAll().forEach(repoWrc6::add);
//        driverRepo.findAll().forEach(repoWrc6::add);
//        weatherRepo.findAll().forEach(repoWrc6::add);
//        raceTimeRepo.findAll().forEach(repoWrc6::add);
//        countryRepo.findAll().forEach(repoWrc6::add);
//        groundTypeRepo.findAll().forEach(repoWrc6::add);
//        groundMixRepo.findAll().forEach(repoWrc6::add);
//        surfaceRepo.findAll().forEach(repoWrc6::add);
//        stageRepo.findAll().forEach(repoWrc6::add);
//        matchRepo.findAll().forEach(repoWrc6::add);
//        rallyRepo.findAll().forEach(repoWrc6::add);
//        seasonRepo.findAll().forEach(repoWrc6::add);
//
//        repoWrc6.commit();
//
//
//        return "END";
//    }
//
//    @GetMapping("/repoToJpa")
//    public String repoToJpa() throws IOException {
//        Wrc6Repo repoWrc6 = repoManager.getWrc6Repo();
//
//        carRepo.saveAll(repoWrc6.getList(Wrc6Car.class));
//        driverRepo.saveAll(repoWrc6.getList(Wrc6Driver.class));
//        weatherRepo.saveAll(repoWrc6.getList(Wrc6Weather.class));
//        raceTimeRepo.saveAll(repoWrc6.getList(Wrc6RaceTime.class));
//        countryRepo.saveAll(repoWrc6.getList(Wrc6Country.class));
//        groundTypeRepo.saveAll(repoWrc6.getList(Wrc6GroundType.class));
//        groundMixRepo.saveAll(repoWrc6.getList(Wrc6GroundMix.class));
//        surfaceRepo.saveAll(repoWrc6.getList(Wrc6Surface.class));
//        stageRepo.saveAll(repoWrc6.getList(Wrc6Stage.class));
//        matchRepo.saveAll(repoWrc6.getList(Wrc6Match.class));
//        rallyRepo.saveAll(repoWrc6.getList(Wrc6Rally.class));
//        seasonRepo.saveAll(repoWrc6.getList(Wrc6Season.class));
//
//        return "END";
//    }

//    @GetMapping("/showRepo")
//    public String showRepo() throws IOException {
//        Collection<Set<RepoEntity>> values = repoManager.getWrc6Repo().getDataSets().values();
//        String strJoin = JkStreams.join(values, "\n\n", RepoUtil::formatEntities);
//        display(strJoin);
//        return  strJoin;
//    }

    private List<Wrc6Car> loadCars() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_CARS));
        List<Wrc6Car> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6Car(line));
        }
        return toRet;
    }

    private List<Wrc6Weather> loadWeathers() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_WEATHERS));
        List<Wrc6Weather> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6Weather(line));
        }
        return toRet;
    }

    private List<Wrc6RaceTime> loadRaceTimes() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_RACE_TIMES));
        List<Wrc6RaceTime> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6RaceTime(line));
        }
        return toRet;
    }

    private List<Wrc6Driver> loadDrivers() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_DRIVERS));
        List<Wrc6Driver> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6Driver(line));
        }
        return toRet;
    }

    private List<Wrc6Country> loadCountries() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_COUNTRIES));
        List<Wrc6Country> toRet = new ArrayList<>();
        for (String line : lines) {
            String[] split = JkStrings.splitArr(line, "|");
            toRet.add(new Wrc6Country(split[1], split[2], Integer.parseInt(split[0])));
        }
        return toRet;
    }

    private List<Wrc6Stage> loadStages() {
        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_STAGES));
        lines.removeIf(StringUtils::isBlank);
        List<Wrc6Stage> toRet = new ArrayList<>();

        Map<String, Wrc6GroundType> gtMap = JkStreams.toMapSingle(groundTypeRepo.findAll(), gt -> gt.getGroundType().toLowerCase());
        List<Wrc6GroundMix> allMixesDistinct = new ArrayList<>();

        for (String line : lines) {
            String[] split = JkStrings.splitArr(line, "|");
            Wrc6Stage stage = new Wrc6Stage();
            stage.setCountry(countryRepo.findByName(split[0]));
            stage.setLocation(split[1]);
            stage.setNumInRally(Integer.parseInt(split[2].trim()));
            stage.setLength(Integer.parseInt(split[3]));
            stage.setSpecialStage(Boolean.valueOf(split[5]));

            Wrc6Surface surface = new Wrc6Surface();

            for (String comp : JkStrings.splitArr(split[4], "--")) {
                String[] el = JkStrings.splitArr(comp, ":");
                Wrc6GroundMix gcomp = new Wrc6GroundMix(gtMap.get(el[0].toLowerCase()), Double.parseDouble(el[1]));
                Wrc6GroundMix found = JkStreams.findUnique(allMixesDistinct, gcomp::hasEqualsContent);
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

            Wrc6Surface found = JkStreams.findUnique(surfaceRepo.findAll(), surface::hasSameContent);
            if(found == null) {
                found = surfaceRepo.save(surface);
            }
            stage.setSurface(found);

            toRet.add(stage);
        }

        return toRet;
    }

    private List<Wrc6GroundType> loadGroundTypes() throws IOException {
        List<String> lines = JkFiles.readLines(new ClassPathResource(FN_GROUND_TYPES).getInputStream());
        List<Wrc6GroundType> toRet = new ArrayList<>();
        for (String line : lines) {
            toRet.add(new Wrc6GroundType(line));
        }
        return toRet;
    }

    private void loadAllMatches() {
        try {
            List<String> lines = JkFiles.readLines(new ClassPathResource(FN_MATCHES).getInputStream());
//        List<String> lines = JkFiles.readLines(getClass().getClassLoader().getResourceAsStream(FN_MATCHES));
            if (!lines.isEmpty()) lines.remove(0);
            Wrc6Season season = null;
            long prevSeason = -1;
            long prevRally = -1;
            Wrc6Rally rally = null;

            for (String line : lines) {
                String[] row = JkStrings.splitArr(line, "|");
                Wrc6Match match = new Wrc6Match();
                match.setMatchTime(LocalDateTime.now());
                Wrc6Country country = countryRepo.findByName(row[0]);
                long seasonId = Long.parseLong(row[1]);
                long rallyId = Long.parseLong(row[2]);

                if (prevRally != rallyId) {
                    if (rally != null) {
                        rallyRepo.save(rally);
                        season.getRallies().add(rally);
                    }
                    rally = new Wrc6Rally();
                    rally.setWinner(driverRepo.findByName(row[14]));
                    rally.setCountry(country);
                    prevRally = rallyId;
                }

                if (prevSeason != seasonId) {
                    if (season != null) {
                        seasonRepo.save(season);
                    }
                    season = seasonRepo.save(new Wrc6Season());
                    season.setStartTm(LocalDateTime.parse(row[12]));
                    if (StringUtils.isNotBlank(row[13])) {
                        season.setEndTm(LocalDateTime.parse(row[13]));
                        season.setWinner(driverRepo.findByName(row[15]));
                    }
                    prevSeason = seasonId;
                }

                List<Wrc6Stage> stages = stageRepo.getStages(country.getName().trim());
                match.setStage(stages.get(Integer.parseInt(row[3]) % stages.size()));
                match.setWinner(driverRepo.findByName(row[4]));
                if (StringUtils.isNotBlank(row[5])) {
                    match.setCarFede(carRepo.findByModel(row[5]));
                    match.setCarBomber(carRepo.findByModel(row[6]));
                }
                match.setWeather(weatherRepo.findByName(row[7].replace("_", " ")));
                match.setRaceTime(raceTimeRepo.findByName(row[8]));
                match.setMatchTime(LocalDateTime.parse(row[9]));
                matchRepo.save(match);

                rally.getMatches().add(match);
            }

            if (rally != null) {
                season.getRallies().add(rally);
                seasonRepo.save(season);
            }

        } catch (IOException ex) {
            LOG.error("Caught error", ex);
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
