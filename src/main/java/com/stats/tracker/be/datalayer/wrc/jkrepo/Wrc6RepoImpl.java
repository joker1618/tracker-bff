package com.stats.tracker.be.datalayer.wrc.jkrepo;

import xxx.joker.libs.core.runtimes.JkEnvironment;
import xxx.joker.libs.repository.JkRepoFile;

import java.nio.file.Path;

public class Wrc6RepoImpl extends JkRepoFile implements Wrc6Repo {

    private static Wrc6Repo instance;

    public Wrc6RepoImpl(Path repoFolder) {
        super(repoFolder.resolve("wrc6"), "wrc6", "com.stats.tracker.be.datalayer.wrc.jkrepo.entities");
    }

}
