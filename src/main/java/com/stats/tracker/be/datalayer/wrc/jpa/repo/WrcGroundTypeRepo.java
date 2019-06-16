package com.stats.tracker.be.datalayer.wrc.jpa.repo;

import com.stats.tracker.be.datalayer.wrc.jpa.entities.WrcGroundType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrcGroundTypeRepo extends JpaRepository<WrcGroundType, Long> {

    @Query(value = "select c.groundType from WrcGroundType c order by c.groundType")
    List<String> getGroundNames();

    @Override
    @Query(value = "select c from WrcGroundType c order by c.groundType")
    List<WrcGroundType> findAll();

}
