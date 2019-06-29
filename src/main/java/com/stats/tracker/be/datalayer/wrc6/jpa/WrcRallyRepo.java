package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcRally;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcRallyRepo extends JpaRepository<WrcRally, Long> {

    @Query(value = "select c from WrcRally c where c.winner is null")
    WrcRally getRallyInProgress();


}
