package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcRaceTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcRaceTimeRepo extends JpaRepository<WrcRaceTime, Long> {

    @Query(value = "select c from WrcRaceTime c where LOWER(c.raceTime) = LOWER(:raceTime)")
    WrcRaceTime findByName(@Param("raceTime") String raceTime);

    @Query(value = "select c.raceTime from WrcRaceTime c")
    List<String> getRaceTimeNames();

}
