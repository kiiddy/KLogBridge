package com.logfusion.config;

import java.util.HashMap;
import java.util.Map;

public class EnvConfigSource implements ConfigSource {

    private static final String ENV = "env";

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Map<String, Object> load() {
        return new HashMap<>(System.getenv());
    }

    @Override
    public String getName() {
        return ENV;
    }
}
