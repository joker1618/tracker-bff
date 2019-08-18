package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Wrc6DriverRepo extends JpaRepository<Wrc6Driver, Long> {

    @Query(value = "select c from Wrc6Driver c where LOWER(c.name) = LOWER(:driverName)")
    Wrc6Driver findByName(@Param("driverName") String driverName);

    @Query(value = "select c from Wrc6Driver c where LOWER(c.name) = 'fede'")
    Wrc6Driver getFede();
    @Query(value = "select c from Wrc6Driver c where LOWER(c.name) = 'bomber'")
    Wrc6Driver getBomber();

}
