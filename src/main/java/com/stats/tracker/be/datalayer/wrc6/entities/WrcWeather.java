package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;
import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"weather"})
})
public class WrcWeather extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    private String weather;

    public WrcWeather() {
    }

    public WrcWeather(String weather) {
        this.weather = weather;
    }

    public long getJpaID() {
        return jpaID;
    }

    public String getWeather() {
        return weather;
    }

    @Override
    public String getPrimaryKey() {
        return "weather-" + weather;
    }
}
