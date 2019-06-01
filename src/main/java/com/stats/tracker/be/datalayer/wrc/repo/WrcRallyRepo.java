package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcRally;
import com.stats.tracker.be.datalayer.wrc.entities.WrcSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcRallyRepo extends JpaRepository<WrcRally, Long> {

    @Query(value = "select c from WrcRally c where c.finished <> true")
    WrcRally getOpenedRally();


}
