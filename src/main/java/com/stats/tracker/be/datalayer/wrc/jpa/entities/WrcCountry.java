package com.stats.tracker.be.datalayer.wrc.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"code"}),
        @UniqueConstraint(columnNames = {"numInSeason"})
})

public class WrcCountry  extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;
    @NotNull
    private String code;
    @NotNull
    private int numInSeason;

    public WrcCountry() {
    }

    public WrcCountry(String name, String code, int numInSeason) {
        this.name = name;
        this.code = code;
        this.numInSeason = numInSeason;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getNumInSeason() {
        return numInSeason;
    }
}
