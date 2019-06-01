package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"car_model"})})
public class WrcCar extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "car_model")
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

}
