package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;
import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"carModel"})
})
public class WrcCar extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String carModel;

    public WrcCar() {
    }

    public WrcCar(String carModel) {
        this.carModel = carModel;
    }

    public long getJpaID() {
        return jpaID;
    }

    public String getCarModel() {
        return carModel;
    }

    @Override
    public String getPrimaryKey() {
        return "car-"+carModel;
    }
}
