package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Wrc6Driver extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String name;

    public Wrc6Driver() {
    }

    public Wrc6Driver(String name) {
        this.name = name;
    }

    public long getJpaId() {
        return jpaId;
    }

    public String getName() {
        return name;
    }

}