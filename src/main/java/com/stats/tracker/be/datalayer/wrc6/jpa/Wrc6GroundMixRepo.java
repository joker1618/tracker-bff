package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6GroundMix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Wrc6GroundMixRepo extends JpaRepository<Wrc6GroundMix, Long> {

}
