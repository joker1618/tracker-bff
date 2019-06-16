package com.stats.tracker.be.datalayer.wrc.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WrcSurface extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private WrcGroundMix primaryGround;
    @ManyToOne
    private WrcGroundMix secondaryGround;


    public WrcSurface() {

    }

    public long getId() {
        return id;
    }

    public WrcGroundMix getPrimaryGround() {
        return primaryGround;
    }

    public void setPrimaryGround(WrcGroundMix primaryGround) {
        this.primaryGround = primaryGround;
    }

    public WrcGroundMix getSecondaryGround() {
        return secondaryGround;
    }

    public void setSecondaryGround(WrcGroundMix secondaryGround) {
        this.secondaryGround = secondaryGround;
    }

    public boolean hasSameContent(WrcSurface o) {
        boolean res = primaryGround.hasEqualsContent(o.primaryGround);
        if(!res)    return false;
        if(secondaryGround == null && o.secondaryGround == null)    return true;
        if(secondaryGround == null || o.secondaryGround == null)    return false;
        return secondaryGround.hasEqualsContent(o.secondaryGround);
    }
}
