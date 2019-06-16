package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcGroundType6 extends RepoEntity implements Serializable {

    @RepoField
    private String groundType;

    public WrcGroundType6() {
    }

    public WrcGroundType6(String groundType) {
        this.groundType = groundType;
    }

    public String getGroundType() {
        return groundType;
    }

    @Override
    public String getPrimaryKey() {
        return groundType;
    }
}
