package com.stats.tracker.be.datalayer.wrc.entities;

import xxx.joker.libs.repository.design.RepoField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcRally extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaID;

    @RepoField
    @NotNull
    @ManyToOne
    private WrcCountry country;
    @RepoField
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WrcMatch> matches;
    @RepoField
    @ManyToOne
    private WrcDriver winner;




    public WrcRally() {
        matches = new ArrayList<>();
    }


    public long getJpaID() {
        return jpaID;
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

    public WrcDriver getWinner() {
        return winner;
    }
    public boolean hasWinner() {
        return winner != null;
    }

    public void setWinner(WrcDriver winner) {
        this.winner = winner;
    }

    @Override
    public String getPrimaryKey() {
        return "rally-" + entityID;
    }
}