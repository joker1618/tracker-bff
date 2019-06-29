package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcGroundMix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcGroundMixRepo extends JpaRepository<WrcGroundMix, Long> {

}
