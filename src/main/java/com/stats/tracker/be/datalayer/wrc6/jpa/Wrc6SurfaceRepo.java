package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Surface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6SurfaceRepo extends JpaRepository<Wrc6Surface, Long> {

    @Query(value = "select surf from Wrc6Surface surf, Wrc6GroundMix mix")
    List<Wrc6Surface> getTest();


}
