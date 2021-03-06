package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcCarRepo extends JpaRepository<WrcCar, Long> {

    @Query(value = "select c from WrcCar c where LOWER(c.carModel) = LOWER(:carModel)")
    WrcCar findByModel(@Param("carModel") String carModel);

}
