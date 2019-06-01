package com.stats.tracker.be.datalayer.wrc.entities.surface;

import com.stats.tracker.be.datalayer.wrc.entities.AbstractEntity;
import xxx.joker.libs.core.lambdas.JkStreams;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WrcSurface extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long surfaceId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<WrcGroundMix> groundMixList = new ArrayList<>();


    public WrcSurface() {

    }

    public long getSurfaceId() {
        return surfaceId;
    }

    public List<WrcGroundMix> getGroundMixList() {
        return groundMixList;
    }

    public void setGroundMixList(List<WrcGroundMix> groundMixList) {
        this.groundMixList = groundMixList;
    }

    public boolean hasSameContent(WrcSurface o) {
        if(groundMixList.size() != o.getGroundMixList().size()) {
            return false;
        }
        List<WrcGroundMix> mixes = new ArrayList<>(o.getGroundMixList());
        groundMixList.forEach(m -> mixes.removeIf(m::hasEqualsContent));
        return mixes.isEmpty();
    }
}