package com.stats.tracker.be.datalayer.wrc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name"}),
        @UniqueConstraint(columnNames = {"code"}),
        @UniqueConstraint(columnNames = {"index"})
})

public class WrcCountry  extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;
    @NotNull
    private String code;
    @NotNull
    private int index;

    public WrcCountry() {
    }

    public WrcCountry(String name, String code, int index) {
        this.name = name;
        this.code = code;
        this.index = index;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getIndex() {
        return index;
    }
}
