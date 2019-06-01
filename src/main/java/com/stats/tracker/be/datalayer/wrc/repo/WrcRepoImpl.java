package com.stats.tracker.be.datalayer.wrc.repo;

public class WrcRepoImpl implements WrcRepo {

    private static WrcRepoImpl instance;

    private WrcRepoImpl() {}

    public static synchronized WrcRepo getInstance() {
        if(instance == null)    instance = new WrcRepoImpl();
        return instance;
    }
}
