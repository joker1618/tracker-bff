package com.stats.tracker.be.datalayer.wrc.entities.surface;

import com.stats.tracker.be.datalayer.wrc.entities.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"groundType"})})
public class WrcGroundType extends AbstractEntity implements Serializable, Comparable<WrcGroundType> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
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
