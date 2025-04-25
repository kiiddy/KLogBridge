package io.klogbridge.config;

import java.lang.reflect.Field;

public class ConfigSourceLoader {

    private final ConfigSourceManager configSourceManager;


    ConfigSourceLoader(ConfigSourceManager configSourceManager) {
        this.configSourceManager = configSourceManager;
    }

    public KLogConfig load() {
        KLogConfig config = KLogConfig.getInstance();
        for (Field field : KLogConfig.class.getDeclaredFields()) {
            ConfigItem annotation = field.getAnnotation(ConfigItem.class);
            if (annotation == null) {
                continue;
            }

            Object value = getConfigValue(annotation, field.getType());
            setField(config, field, value);
        }
        return config;
    }

    private void setField(KLogConfig config, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(config,value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getConfigValue(ConfigItem annotation, Class<?> type) {
        String name = annotation.name();
        Object obj = configSourceManager.get(name);
        if(obj == null) {
            return annotation.defaultValue();
        }
        return obj;
    }


}
