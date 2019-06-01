package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcRally;
import com.stats.tracker.be.datalayer.wrc.entities.WrcSeason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcSeasonRepo extends JpaRepository<WrcSeason, Long> {

}
