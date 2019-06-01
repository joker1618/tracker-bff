package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcRally extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rallyId;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private WrcCountry country;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WrcMatch> matches = new ArrayList<>();

    public WrcRally() {

    }


    public long getRallyId() {
        return rallyId;
    }

    public List<WrcMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<WrcMatch> matches) {
        this.matches = matches;
    }

    public WrcCountry getCountry() {
        return country;
    }

    public void setCountry(WrcCountry country) {
        this.country = country;
    }
}