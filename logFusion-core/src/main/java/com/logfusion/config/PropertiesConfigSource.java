package com.logfusion.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertiesConfigSource implements ConfigSource {

    private static final String JVM = "jvm";

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Map<String, Object> load() {
        Map<String,Object> config = new HashMap<>();
        Properties systemProperties = System.getProperties();
        for (String key : systemProperties.stringPropertyNames()) {
            config.put(key, systemProperties.getProperty(key));
        }
        return config;
    }

    @Override
    public String getName() {
        return JVM;
    }
}
