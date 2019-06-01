package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcDriver;
import com.stats.tracker.be.datalayer.wrc.entities.WrcRaceTime;
import com.stats.tracker.be.datalayer.wrc.entities.WrcWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcRaceTimeRepo extends JpaRepository<WrcRaceTime, Long> {

    @Query(value = "select c from WrcRaceTime c where LOWER(c.raceTime) = LOWER(:raceTime)")
    WrcRaceTime findByName(@Param("raceTime") String raceTime);

}
