package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6MatchRepo extends JpaRepository<Wrc6Match, Long> {

    @Query(value = "select COUNT(*) from Wrc6Match m where m.winner = :driver")
    int countWins(
            @Param(value = "driver") Wrc6Driver driver
    );

    @Query(value = "select COUNT(*) from Wrc6Match m where m.winner = :driver AND m.stage.country = :country")
    int countWins(
            @Param(value = "driver") Wrc6Driver driver,
            @Param(value = "country") Wrc6Country country
    );

    @Query(value = "select m from Wrc6Match m where m in :matches")
    List<Wrc6Match> getMatches(
            @Param(value = "matches") List<Wrc6Match> matches
    );
}
