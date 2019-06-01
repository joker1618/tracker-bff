package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcGroundMix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcGroundMixRepo extends JpaRepository<WrcGroundMix, Long> {

}
