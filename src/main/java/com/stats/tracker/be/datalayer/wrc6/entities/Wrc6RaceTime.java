package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"raceTime"})
})
public class Wrc6RaceTime extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String raceTime;

    public Wrc6RaceTime() {
    }

    public Wrc6RaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public long getJpaId() {
        return jpaId;
    }

    public String getRaceTime() {
        return raceTime;
    }

}
