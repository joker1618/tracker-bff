package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"})
})
public class WrcDriver extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String name;

    public WrcDriver() {
    }

    public WrcDriver(String name) {
        this.name = name;
    }

    public long getJpaID() {
        return jpaID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPrimaryKey() {
        return "driver-" + name;
    }
}