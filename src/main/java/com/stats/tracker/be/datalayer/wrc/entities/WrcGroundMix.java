package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class WrcGroundMix extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    private WrcGroundType groundType;

    @NotNull
    private double groundPerc;

    public WrcGroundMix() {
    }

    public WrcGroundMix(@NotNull WrcGroundType groundType, @NotNull double groundPerc) {
        this.groundType = groundType;
        this.groundPerc = groundPerc;
    }

    public long getId() {
        return id;
    }

    public WrcGroundType getGroundType() {
        return groundType;
    }

    public double getGroundPerc() {
        return groundPerc;
    }

    public boolean hasEqualsContent(WrcGroundMix o) {
        return groundType.equals(o.getGroundType()) && groundPerc == o.getGroundPerc();
    }
}
