package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"weather"})
})
public class WrcWeather extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String weather;

    public WrcWeather() {
    }

    public WrcWeather(String weather) {
        this.weather = weather;
    }

    public long getId() {
        return id;
    }

    public String getWeather() {
        return weather;
    }
}
