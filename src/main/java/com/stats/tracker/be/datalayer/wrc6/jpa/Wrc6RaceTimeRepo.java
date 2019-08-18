package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6RaceTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6RaceTimeRepo extends JpaRepository<Wrc6RaceTime, Long> {

    @Query(value = "select c from Wrc6RaceTime c where LOWER(c.raceTime) = LOWER(:raceTime)")
    Wrc6RaceTime findByName(@Param("raceTime") String raceTime);

    @Query(value = "select c.raceTime from Wrc6RaceTime c")
    List<String> getRaceTimeNames();

}
