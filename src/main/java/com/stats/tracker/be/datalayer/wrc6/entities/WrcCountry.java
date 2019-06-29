package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;
import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"code"}),
        @UniqueConstraint(columnNames = {"numInSeason"})
})

public class WrcCountry  extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String name;
    @RepoField
    @NotNull
    private String code;
    @RepoField
    @NotNull
    private int numInSeason;

    public WrcCountry() {
    }

    public WrcCountry(String name, String code, int numInSeason) {
        this.name = name;
        this.code = code;
        this.numInSeason = numInSeason;
    }

    public long getJpaID() {
        return jpaID;
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

    @Override
    public String getPrimaryKey() {
        return strf("country-%02d-%s", getNumInSeason(), getName());
    }
}
