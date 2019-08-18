package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Wrc6GroundMix extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    @ManyToOne
    private Wrc6GroundType groundType;


    @NotNull
    private double groundPerc;

    public Wrc6GroundMix() {
    }

    public Wrc6GroundMix(@NotNull Wrc6GroundType groundType, @NotNull double groundPerc) {
        this.groundType = groundType;
        this.groundPerc = groundPerc;
    }

    public long getJpaId() {
        return jpaId;
    }

    public Wrc6GroundType getGroundType() {
        return groundType;
    }

    public double getGroundPerc() {
        return groundPerc;
    }

    public boolean hasEqualsContent(Wrc6GroundMix o) {
        return groundType.equals(o.getGroundType()) && groundPerc == o.getGroundPerc();
    }

}
