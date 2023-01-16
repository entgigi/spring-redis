package com.gigiozzz.redis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(properties = {
		"spring.session.store-type=redis",
		"spring.redis.sentinel.enabled=false"
})
class RedisStandaloneApplicationTest {


	@BeforeAll
	static void setUp(){
		RedisTestcontainersConfig.setupStandalone();
	}

	@Test
	void contextLoads() {
	}

	@AfterAll
	static void setDown(){
		RedisTestcontainersConfig.shutdownStandalone();
	}
}
