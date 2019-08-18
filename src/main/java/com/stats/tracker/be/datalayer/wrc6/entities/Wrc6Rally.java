package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wrc6Rally extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @NotNull
    @ManyToOne
    private Wrc6Country country;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Wrc6Match> matches;

    @ManyToOne
    private Wrc6Driver winner;




    public Wrc6Rally() {
        matches = new ArrayList<>();
    }


    public long getJpaId() {
        return jpaId;
    }

    public List<Wrc6Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Wrc6Match> matches) {
        this.matches = matches;
    }

    public Wrc6Country getCountry() {
        return country;
    }

    public void setCountry(Wrc6Country country) {
        this.country = country;
    }

    public Wrc6Driver getWinner() {
        return winner;
    }
    public boolean hasWinner() {
        return winner != null;
    }

    public void setWinner(Wrc6Driver winner) {
        this.winner = winner;
    }

}