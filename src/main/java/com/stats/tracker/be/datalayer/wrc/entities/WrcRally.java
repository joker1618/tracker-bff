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
    private long id;

    @NotNull
    @ManyToOne
    private WrcCountry country;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WrcMatch> matches;
    private long seasonId;
    @ManyToOne
    private WrcDriver winner;




    public WrcRally() {
        matches = new ArrayList<>();
    }


    public long getId() {
        return id;
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

    public long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(long seasonId) {
        this.seasonId = seasonId;
    }

    public WrcDriver getWinner() {
        return winner;
    }
    public boolean hasWinner() {
        return winner != null;
    }

    public void setWinner(WrcDriver winner) {
        this.winner = winner;
    }
}