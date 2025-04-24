package io.klogbridge.config;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigSourceManager {

    private final List<ConfigSource> configSources = Arrays.asList(
            new YamlConfigSource(),
            new PropertiesConfigSource(),
            new EnvConfigSource()
    );

    private final Map<String, Object> configs = new ConcurrentHashMap<>();

    public void loadConfigs(){
        configSources.sort(Comparator.comparing(ConfigSource::getOrder));

        configSources.forEach(configSource -> {
            try{
                configs.putAll(configSource.load());
            }catch (Exception e){
                System.out.printf("Error loading config source: %s\n", configSource);
            }
        });
    }

    public Object get(String key) {
        return configs.get(key);
    }
}
