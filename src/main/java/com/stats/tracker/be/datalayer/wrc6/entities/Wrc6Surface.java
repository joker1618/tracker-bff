package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Wrc6Surface extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;

    @ManyToOne
    private Wrc6GroundMix primaryGround;

    @ManyToOne
    private Wrc6GroundMix secondaryGround;


    public Wrc6Surface() {

    }

    public long getJpaId() {
        return jpaId;
    }

    public Wrc6GroundMix getPrimaryGround() {
        return primaryGround;
    }

    public void setPrimaryGround(Wrc6GroundMix primaryGround) {
        this.primaryGround = primaryGround;
    }

    public Wrc6GroundMix getSecondaryGround() {
        return secondaryGround;
    }

    public void setSecondaryGround(Wrc6GroundMix secondaryGround) {
        this.secondaryGround = secondaryGround;
    }

    public boolean hasSameContent(Wrc6Surface o) {
        boolean res = primaryGround.hasEqualsContent(o.primaryGround);
        if(!res)    return false;
        if(secondaryGround == null && o.secondaryGround == null)    return true;
        if(secondaryGround == null || o.secondaryGround == null)    return false;
        return secondaryGround.hasEqualsContent(o.secondaryGround);
    }

}
