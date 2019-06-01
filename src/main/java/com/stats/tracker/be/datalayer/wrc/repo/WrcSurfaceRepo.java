package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.surface.WrcSurface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcSurfaceRepo extends JpaRepository<WrcSurface, Long> {


}
