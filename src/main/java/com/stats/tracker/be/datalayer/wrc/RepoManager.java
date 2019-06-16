package com.stats.tracker.be.datalayer.wrc;

import com.stats.tracker.be.config.AppConfig;
import com.stats.tracker.be.datalayer.wrc.repo.Wrc6Repo;
import com.stats.tracker.be.datalayer.wrc.repo.Wrc6RepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xxx.joker.libs.core.cache.JkCache;
import xxx.joker.libs.repository.JkRepo;

@Repository
public class RepoManager {

    @Autowired
    private AppConfig config;

    private JkCache<Class, JkRepo> cacheRepos = new JkCache<>();

    public synchronized Wrc6Repo getWrc6Repo() {
        return (Wrc6Repo) cacheRepos.get(Wrc6Repo.class, () -> new Wrc6RepoImpl(config.getDbFolder()));
    }

}
