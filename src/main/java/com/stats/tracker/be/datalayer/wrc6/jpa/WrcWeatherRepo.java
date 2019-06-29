package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcWeatherRepo extends JpaRepository<WrcWeather, Long> {

    @Query(value = "select c from WrcWeather c where LOWER(c.weather) = LOWER(:weatherName)")
    WrcWeather findByName(@Param("weatherName") String weatherName);

    @Query(value = "select c.weather from WrcWeather c")
    List<String> getWeatherNames();

}
