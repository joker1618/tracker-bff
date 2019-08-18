package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6WeatherRepo extends JpaRepository<Wrc6Weather, Long> {

    @Query(value = "select c from Wrc6Weather c where LOWER(c.weather) = LOWER(:weatherName)")
    Wrc6Weather findByName(@Param("weatherName") String weatherName);

    @Query(value = "select c.weather from Wrc6Weather c")
    List<String> getWeatherNames();

}
