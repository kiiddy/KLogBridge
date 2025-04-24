package io.klogbridge.config;

import java.lang.reflect.Field;

public class KLogConfigBinder {

    private final ConfigSourceManager configSourceManager;


    KLogConfigBinder( ConfigSourceManager configSourceManager) {
        this.configSourceManager = configSourceManager;
    }

    public KLogConfig bind() {
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
