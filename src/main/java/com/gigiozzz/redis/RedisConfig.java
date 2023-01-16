package com.gigiozzz.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.redis")
@Data
public class RedisConfig {

    @Value("${standalone.port:6379}")
    private int standalonePort;
    @Value("${standalone.host:localhost}")
    private String standaloneHost;

}