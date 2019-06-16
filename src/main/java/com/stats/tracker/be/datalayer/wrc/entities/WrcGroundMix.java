package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

@Entity
public class WrcGroundMix extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @RepoField
    @NotNull
    @ManyToOne
    private WrcGroundType groundType;

    @RepoField
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

    @Override
    public String getPrimaryKey() {
        return strf("groundMix-%s-%.2f", groundType.getGroundType(), groundPerc);
    }
}
