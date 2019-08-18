package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"carModel"})
})
public class Wrc6Car extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String carModel;

    public Wrc6Car() {
    }

    public Wrc6Car(String carModel) {
        this.carModel = carModel;
    }

    public long getJpaId() {
        return jpaId;
    }

    public String getCarModel() {
        return carModel;
    }

}
