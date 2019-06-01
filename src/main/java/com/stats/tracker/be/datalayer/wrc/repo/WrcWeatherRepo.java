package com.stats.tracker.be.datalayer.wrc.repo;

import com.stats.tracker.be.datalayer.wrc.entities.WrcCar;
import com.stats.tracker.be.datalayer.wrc.entities.WrcWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcWeatherRepo extends JpaRepository<WrcWeather, Long> {

    @Query(value = "select c from WrcWeather c where LOWER(c.weather) = LOWER(:weatherName)")
    WrcWeather findByName(@Param("weatherName") String weatherName);

}
