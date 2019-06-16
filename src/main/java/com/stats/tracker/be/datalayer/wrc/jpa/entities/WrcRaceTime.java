package com.stats.tracker.be.datalayer.wrc.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"raceTime"})
})
public class WrcRaceTime extends AbstractEntity  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String raceTime;

    public WrcRaceTime() {
    }

    public WrcRaceTime(String raceTime) {
        this.raceTime = raceTime;
    }

    public long getId() {
        return id;
    }

    public String getRaceTime() {
        return raceTime;
    }
}
