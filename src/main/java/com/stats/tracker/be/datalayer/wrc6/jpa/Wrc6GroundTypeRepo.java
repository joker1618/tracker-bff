package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6GroundType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6GroundTypeRepo extends JpaRepository<Wrc6GroundType, Long> {

    @Query(value = "select c.groundType from Wrc6GroundType c order by c.groundType")
    List<String> getGroundNames();

    @Override
    @Query(value = "select c from Wrc6GroundType c order by c.groundType")
    List<Wrc6GroundType> findAll();

}
