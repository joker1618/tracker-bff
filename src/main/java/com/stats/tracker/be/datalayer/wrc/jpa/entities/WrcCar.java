package com.stats.tracker.be.datalayer.wrc.jpa.entities;

import xxx.joker.libs.repository.design.RepoEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"carModel"})
})
public class WrcCar extends RepoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String carModel;

    public WrcCar() {
    }

    public WrcCar(String carModel) {
        this.carModel = carModel;
    }

    public long getId() {
        return id;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String getPrimaryKey() {
        return "car-"+carModel;
    }
}
