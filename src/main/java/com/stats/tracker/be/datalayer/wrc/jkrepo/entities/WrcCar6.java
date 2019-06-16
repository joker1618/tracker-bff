package com.stats.tracker.be.datalayer.wrc.jkrepo.entities;

import xxx.joker.libs.repository.design.RepoEntity;
import xxx.joker.libs.repository.design.RepoField;

import java.io.Serializable;

public class WrcCar6 extends RepoEntity implements Serializable {

    @RepoField
    private String carModel;

    public WrcCar6() {
    }

    public WrcCar6(String carModel) {
        this.carModel = carModel;
    }


    public String getCarModel() {
        return carModel;
    }

    @Override
    public String getPrimaryKey() {
        return carModel;
    }
}
