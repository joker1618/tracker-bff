package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"weather"})
})
public class Wrc6Weather extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    private String weather;

    public Wrc6Weather() {
    }

    public Wrc6Weather(String weather) {
        this.weather = weather;
    }

    public long getJpaId() {
        return jpaId;
    }

    public String getWeather() {
        return weather;
    }

}
