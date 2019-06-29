package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcCountryRepo extends JpaRepository<WrcCountry, Long> {

    @Query(value = "select c from WrcCountry c where LOWER(c.name) = LOWER(:countryName)")
    WrcCountry findByName(@Param("countryName") String countryName);

    @Override
    @Query(value = "select c from WrcCountry c order by c.numInSeason")
//    @Query(value = "select c from WrcCountry c order by c.index")
    List<WrcCountry> findAll();

}

