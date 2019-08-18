package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6CountryRepo extends JpaRepository<Wrc6Country, Long> {

    @Query(value = "select c from Wrc6Country c where LOWER(c.name) = LOWER(:countryName)")
    Wrc6Country findByName(@Param("countryName") String countryName);

    @Override
    @Query(value = "select c from Wrc6Country c order by c.numInSeason")
    List<Wrc6Country> findAll();

}

