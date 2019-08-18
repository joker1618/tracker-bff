package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Driver;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6SeasonRepo extends JpaRepository<Wrc6Season, Long> {

    @Query(value = "select c from Wrc6Season c where c.endTm is null")
    Wrc6Season getSeasonInProgress();

    @Query(value = "select c from Wrc6Season c where c.endTm is not null")
    List<Wrc6Season> getSeasonsClosed();

    @Query(value = "select c from Wrc6Season c where c.winner = :driver")
    int countWins(@Param(value = "driver") Wrc6Driver driver);

}
