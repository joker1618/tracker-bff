package com.stats.tracker.be.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xxx.joker.libs.core.runtimes.JkEnvironment;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class AppConfig {

    @Value("${jkrepo.db.folder.name:}")
    private String dbFolderName;
    @Value("${jkrepo.apps.folder}")
    private String appsFolderName;
    private boolean initialized = false;

    private void initConfigs() {
        if(StringUtils.isNotBlank(appsFolderName)) {
            JkEnvironment.setAppsFolder(Paths.get(appsFolderName));
        }
    }

    public Path getDbFolder() {
        if(!initialized) {
            initConfigs();
            initialized = true;
        }
        return JkEnvironment.getAppsFolder().resolve(dbFolderName);
    }

}
