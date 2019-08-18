package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6StageRepo extends JpaRepository<Wrc6Stage, Long> {

    @Query(value = "select c from Wrc6Stage c where LOWER(c.country.name) = LOWER(:country) and  c.numInRally = :numInRally")
    Wrc6Stage getStage(@Param("country") String country, @Param("numInRally") int numInRally);

    @Query(value = "select c from Wrc6Stage c where LOWER(c.country.name) = LOWER(:country)")
    List<Wrc6Stage> getStages(@Param("country") String country);

    @Override
    @Query(value = "select c from Wrc6Stage c order by c.id")
    List<Wrc6Stage> findAll();

}
