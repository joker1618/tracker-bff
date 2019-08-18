package com.stats.tracker.be.datalayer.wrc6.jpa;

import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Match;
import com.stats.tracker.be.datalayer.wrc6.entities.Wrc6Rally;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Wrc6RallyRepo extends JpaRepository<Wrc6Rally, Long> {

    @Query(value = "select c from Wrc6Rally c where c.winner is null")
    Wrc6Rally getRallyInProgress();

    @Query(value = "select c from Wrc6Rally c where c.winner is not null order by c.jpaId")
    List<Wrc6Rally> getClosedRallies();


}
