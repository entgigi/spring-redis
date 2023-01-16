package com.gigiozzz.redis;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

public class RedisTestcontainersConfig {
    private static GenericContainer<?> redisStandalone = null;
    public static void setupStandalone() {
        redisStandalone = new GenericContainer<>(DockerImageName.parse("redis:5.0.3-alpine")).withExposedPorts(6379);
        redisStandalone.start();
        System.setProperty("spring.redis.standalone.host", redisStandalone.getHost());
        System.setProperty("spring.redis.standalone.port", redisStandalone.getMappedPort(6379).toString());

        // spring session ???
        System.setProperty("spring.redis.host", redisStandalone.getHost());
        System.setProperty("spring.redis.port", redisStandalone.getMappedPort(6379).toString());

    }

    public static void shutdownStandalone() {
        redisStandalone.stop();
    }
}
