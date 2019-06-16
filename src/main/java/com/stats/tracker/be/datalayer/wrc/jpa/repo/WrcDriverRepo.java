package com.stats.tracker.be.datalayer.wrc.jpa.repo;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcDriverRepo extends JpaRepository<WrcDriver, Long> {

    @Query(value = "select c from WrcDriver c where LOWER(c.name) = LOWER(:driverName)")
    WrcDriver findByName(@Param("driverName") String driverName);

    @Query(value = "select c from WrcDriver c where LOWER(c.name) = 'fede'")
    WrcDriver getFede();
    @Query(value = "select c from WrcDriver c where LOWER(c.name) = 'bomber'")
    WrcDriver getBomber();

}
