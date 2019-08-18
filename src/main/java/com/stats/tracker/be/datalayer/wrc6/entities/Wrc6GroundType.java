package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"groundType"})})
public class Wrc6GroundType extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String groundType;

    public Wrc6GroundType() {
    }

    public Wrc6GroundType(String groundType) {
        this.groundType = groundType;
    }

    public long getJpaId() {
        return jpaId;
    }

    public String getGroundType() {
        return groundType;
    }

}
