package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcSeasonRepo extends JpaRepository<WrcSeason, Long> {

    @Query(value = "select c from WrcSeason c where c.endTm is null")
    WrcSeason getSeasonInProgress();

}
