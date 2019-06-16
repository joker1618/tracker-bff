package com.stats.tracker.be.datalayer.wrc.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import xxx.joker.libs.repository.design.RepoEntity;

public abstract class JpaEntity extends RepoEntity {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
