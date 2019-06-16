package com.stats.tracker.be.datalayer.wrc.jpa.repo;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcStageRepo extends JpaRepository<WrcStage, Long> {

    @Query(value = "select c from WrcStage c where LOWER(c.country.name) = LOWER(:country) and  c.numInRally = :numInRally")
    WrcStage getStage(@Param("country") String country, @Param("numInRally") int numInRally);

    @Query(value = "select c from WrcStage c where LOWER(c.country.name) = LOWER(:country)")
    List<WrcStage> getStages(@Param("country") String country);

    @Override
    @Query(value = "select c from WrcStage c order by c.id")
    List<WrcStage> findAll();

}
