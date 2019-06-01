package com.stats.tracker.be.datalayer.wrc.entities.surface;

import com.stats.tracker.be.datalayer.wrc.entities.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"ground_type"})})
public class WrcGroundType extends AbstractEntity implements Serializable, Comparable<WrcGroundType> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "ground_type")
    private String groundType;

    public WrcGroundType() {
    }

    public WrcGroundType(String groundType) {
        this.groundType = groundType;
    }

    public long getId() {
        return id;
    }

    public String getGroundType() {
        return groundType;
    }

    @Override
    public int compareTo(WrcGroundType o) {
        return groundType.compareTo(o.getGroundType());
    }
}
