package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcCountryRepo extends JpaRepository<WrcCountry, Long> {

    @Query(value = "select c from WrcCountry c where LOWER(c.name) = LOWER(:countryName)")
    WrcCountry findByName(@Param("countryName") String countryName);

}

