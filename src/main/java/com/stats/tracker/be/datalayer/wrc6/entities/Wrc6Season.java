package com.stats.tracker.be.datalayer.wrc6.entities;

import com.stats.tracker.be.datalayer.JpaEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wrc6Season extends JpaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jpaId;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Wrc6Rally> rallies;


    private LocalDateTime startTm;
    private LocalDateTime endTm;

    @ManyToOne
    private Wrc6Driver winner;


    public Wrc6Season() {
        rallies = new ArrayList<>();
    }

    public List<Wrc6Rally> getRallies() {
        return rallies;
    }

    public void setRallies(List<Wrc6Rally> rallies) {
        this.rallies = rallies;
    }

    public long getJpaId() {
        return jpaId;
    }

    public LocalDateTime getStartTm() {
        return startTm;
    }

    public void setStartTm(LocalDateTime startTm) {
        this.startTm = startTm;
    }

    public LocalDateTime getEndTm() {
        return endTm;
    }

    public void setEndTm(LocalDateTime endTm) {
        this.endTm = endTm;
    }

    public Wrc6Driver getWinner() {
        return winner;
    }

    public void setWinner(Wrc6Driver winner) {
        this.winner = winner;
    }

}