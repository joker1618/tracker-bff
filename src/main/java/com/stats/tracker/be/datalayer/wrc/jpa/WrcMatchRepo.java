package com.stats.tracker.be.datalayer.wrc.jpa;

import com.stats.tracker.be.datalayer.wrc.entities.WrcMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcMatchRepo extends JpaRepository<WrcMatch, Long> {

}
