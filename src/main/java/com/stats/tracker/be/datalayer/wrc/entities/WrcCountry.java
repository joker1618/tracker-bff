package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class WrcCountry  extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryId;

    @NotNull
    @Column(name = "country")
    private String country;
    @NotNull
    private String code;
    private int index;

    public WrcCountry() {
    }

    public WrcCountry(String country, String code, int index) {
        this.country = country;
        this.code = code;
        this.index = index;
    }

    public long getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public int getIndex() {
        return index;
    }
}
