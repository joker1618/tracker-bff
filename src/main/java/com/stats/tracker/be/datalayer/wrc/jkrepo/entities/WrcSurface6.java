package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcSurface6 extends RepoEntity implements Serializable {

    @RepoField
    private WrcGroundMix6 primaryGround;
    @RepoField
    private WrcGroundMix6 secondaryGround;


    public WrcSurface6() {

    }

    public WrcGroundMix6 getPrimaryGround() {
        return primaryGround;
    }

    public void setPrimaryGround(WrcGroundMix6 primaryGround) {
        this.primaryGround = primaryGround;
    }

    public WrcGroundMix6 getSecondaryGround() {
        return secondaryGround;
    }

    public void setSecondaryGround(WrcGroundMix6 secondaryGround) {
        this.secondaryGround = secondaryGround;
    }

    public boolean hasSameContent(WrcSurface6 o) {
        boolean res = primaryGround.hasEqualsContent(o.primaryGround);
        if(!res)    return false;
        if(secondaryGround == null && o.secondaryGround == null)    return true;
        if(secondaryGround == null || o.secondaryGround == null)    return false;
        return secondaryGround.hasEqualsContent(o.secondaryGround);
    }

    @Override
    public String getPrimaryKey() {
        return "surface-"+getEntityID();
    }
}
