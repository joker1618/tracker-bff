package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcDriver6 extends RepoEntity implements Serializable {

    @RepoField
    private String name;

    public WrcDriver6() {
    }

    public WrcDriver6(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPrimaryKey() {
        return name;
    }
}