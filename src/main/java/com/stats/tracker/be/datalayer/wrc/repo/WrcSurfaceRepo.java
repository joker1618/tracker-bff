package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcSurface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcSurfaceRepo extends JpaRepository<WrcSurface, Long> {


}
