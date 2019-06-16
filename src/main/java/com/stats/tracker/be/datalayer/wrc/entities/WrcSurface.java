package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import java.io.Serializable;

import static xxx.joker.libs.core.utils.JkStrings.strf;

@Entity
public class WrcSurface extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @RepoField
    @ManyToOne
    private WrcGroundMix primaryGround;
    @RepoField
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

    @Override
    public String getPrimaryKey() {
        String str = strf("surface-{}", primaryGround.getPrimaryKey());
        if(secondaryGround != null) {
            str += "-" + secondaryGround.getPrimaryKey();
        }
        return str;
    }
}
