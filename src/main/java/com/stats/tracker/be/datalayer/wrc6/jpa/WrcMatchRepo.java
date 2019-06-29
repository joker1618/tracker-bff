package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.WrcDriver;
import com.stats.tracker.be.datalayer.wrc6.entities.WrcMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WrcMatchRepo extends JpaRepository<WrcMatch, Long> {

    @Query(value = "select COUNT(*) from WrcMatch m")
    int numMatchesWin();
    @Query(value = "select COUNT(*) from WrcMatch m where m.winner.jpaID = :driverJpaID")
    int numMatchesWin(@Param(value = "driverJpaID") long driverJpaID);
    @Query(value = "select COUNT(*) from WrcMatch m where m.winner = :driver")
    int numMatchesWin(@Param(value = "driver") WrcDriver driver);
//
//    @Query(value = "select COUNT(m) as num from WrcMatch m where m.winner.jpaID = :driver.jpaID")
//    int numMatchesWin(@PathVariable("driver") WrcDriver driver);
//    Map<WrcDriver, Integer> getMatchesWin(@Param("driver") WrcDriver driver);

}
