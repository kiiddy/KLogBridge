package io.klogbridge.config;

import java.beans.Encoder;
import java.util.HashMap;
import java.util.Map;

public class KLogConfig {

    private String bootstrapServers;
    private String topic;
    private String logPattern = "%d{ISO8601} [%thread] %-5level %logger{36} - %msg%n";
    private boolean asyncEnabled = true;
    private int asyncQueueSize = 2048;
    private boolean neverBlock = false;
    private int discardingThreshold = 20;
    private String fallbackPath = "logs/klog_fallback.log";
    private Map<String, String> kafkaProducerProps = new HashMap<>();
    private int drainTimeout = 10;

    public static KLogConfig instance = new KLogConfig();

    public static KLogConfig getInstance() {
        return instance;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLogPattern() {
        return logPattern;
    }

    public void setLogPattern(String logPattern) {
        this.logPattern = logPattern;
    }

    public boolean isAsyncEnabled() {
        return asyncEnabled;
    }

    public void setAsyncEnabled(boolean asyncEnabled) {
        this.asyncEnabled = asyncEnabled;
    }

    public int getAsyncQueueSize() {
        return asyncQueueSize;
    }

    public void setAsyncQueueSize(int asyncQueueSize) {
        this.asyncQueueSize = asyncQueueSize;
    }

    public boolean isNeverBlock() {
        return neverBlock;
    }

    public void setNeverBlock(boolean neverBlock) {
        this.neverBlock = neverBlock;
    }

    public int getDiscardingThreshold() {
        return discardingThreshold;
    }

    public void setDiscardingThreshold(int discardingThreshold) {
        this.discardingThreshold = discardingThreshold;
    }

    public String getFallbackPath() {
        return fallbackPath;
    }

    public void setFallbackPath(String fallbackPath) {
        this.fallbackPath = fallbackPath;
    }

    public Map<String, String> getKafkaProducerProps() {
        return kafkaProducerProps;
    }

    public void setKafkaProducerProps(Map<String, String> kafkaProducerProps) {
        this.kafkaProducerProps = kafkaProducerProps;
    }

    public int getDrainTimeout() {
        return drainTimeout;
    }

    public void setDrainTimeout(int drainTimeout) {
        this.drainTimeout = drainTimeout;
    }
}
