package io.klogbridge.config;

import java.util.Map;

public interface ConfigSource {

    int getOrder();

    Map<String,Object> load();

    String getName();
}
