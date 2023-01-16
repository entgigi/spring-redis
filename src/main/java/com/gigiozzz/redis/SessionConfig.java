package com.gigiozzz.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Slf4j
@Configuration
@ConditionalOnProperty(value = "spring.session.enabled", havingValue = "true", matchIfMissing = false)
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {


    @Autowired
    private RedisConfig config;

    @Bean
    @ConditionalOnProperty(value = "spring.redis.sentinel.enabled", havingValue = "false", matchIfMissing = true)
    LettuceConnectionFactory connectionFactoryStandalone(){
        log.info("init connection for standalone");
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(config.getStandaloneHost(), config.getStandalonePort()));
    }

    @Bean
    @ConditionalOnProperty(value = "spring.redis.sentinel.enabled", havingValue = "true", matchIfMissing = false)
    LettuceConnectionFactory connectionFactorySentinel(){
        log.info("init connection for sentinel");
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();

        return new LettuceConnectionFactory(sentinelConfig);
    }

}
