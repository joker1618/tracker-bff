package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"code"}),
        @UniqueConstraint(columnNames = {"numInSeason"})
})

public class Wrc6Country extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String name;

    @NotNull
    private String code;

    @NotNull
    private int numInSeason;

    public Wrc6Country() {
    }

    public Wrc6Country(String name, String code, int numInSeason) {
        this.name = name;
        this.code = code;
        this.numInSeason = numInSeason;
    }

    public long getJpaId() {
        return jpaId;
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
