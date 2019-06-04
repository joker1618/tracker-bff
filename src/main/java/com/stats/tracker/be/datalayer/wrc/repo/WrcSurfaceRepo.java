package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcSurface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcSurfaceRepo extends JpaRepository<WrcSurface, Long> {

    @Query(value = "select surf from WrcSurface surf, WrcGroundMix mix")
    List<WrcSurface> getTest();


}
