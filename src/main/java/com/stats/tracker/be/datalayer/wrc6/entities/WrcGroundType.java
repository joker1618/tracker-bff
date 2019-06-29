package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;
import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"groundType"})})
public class WrcGroundType extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String groundType;

    public WrcGroundType() {
    }

    public WrcGroundType(String groundType) {
        this.groundType = groundType;
    }

    public long getJpaID() {
        return jpaID;
    }

    public String getGroundType() {
        return groundType;
    }

    @Override
    public String getPrimaryKey() {
        return "ground-" + groundType;
    }
}
