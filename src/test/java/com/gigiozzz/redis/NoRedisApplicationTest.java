package com.gigiozzz.redis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.session.store-type=none"})
class NoRedisApplicationTest {

	@Test
	void contextLoads() {
	}

}
