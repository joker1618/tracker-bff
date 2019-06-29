package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;
import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"raceTime"})
})
public class WrcRaceTime extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String raceTime;

    public WrcRaceTime() {
    }

    public WrcRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public long getJpaID() {
        return jpaID;
    }

    public String getRaceTime() {
        return raceTime;
    }

    @Override
    public String getPrimaryKey() {
        return "raceTime-" + raceTime;
    }
}
