package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

public class WrcGroundMix6 extends RepoEntity implements Serializable {

    @RepoField
    private WrcGroundType6 groundType;
    @RepoField
    private double groundPerc;

    public WrcGroundMix6() {
    }

    public WrcGroundType6 getGroundType() {
        return groundType;
    }

    public void setGroundType(WrcGroundType6 groundType) {
        this.groundType = groundType;
    }

    public void setGroundPerc(double groundPerc) {
        this.groundPerc = groundPerc;
    }

    public double getGroundPerc() {
        return groundPerc;
    }

    public boolean hasEqualsContent(WrcGroundMix6 o) {
        return groundType.equals(o.getGroundType()) && groundPerc == o.getGroundPerc();
    }

    @Override
    public String getPrimaryKey() {
        return strf("{}-{}", getGroundType().getGroundType(), groundPerc);
    }
}
