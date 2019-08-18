package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Wrc6CarRepo extends JpaRepository<Wrc6Car, Long> {

    @Query(value = "select c from Wrc6Car c where LOWER(c.carModel) = LOWER(:carModel)")
    Wrc6Car findByModel(@Param("carModel") String carModel);

}
