package io.klogbridge.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class YamlConfigSource implements ConfigSource {

    private static final String YAML = "yaml";

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Map<String, Object> load() {
        try(InputStream inputStream = YamlConfigSource.class.getClassLoader().getResourceAsStream("klog-config.yaml")){
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        }catch (Exception e){
            System.out.printf("Error loading logFusion.yaml from yaml file");
        }
        return Collections.emptyMap();
    }

    @Override
    public String getName() {
        return YAML;
    }
}
