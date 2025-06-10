package com.codingnomads.spring.management_microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"eureka.client.enabled=false",
		"eureka.client.register-with-eureka=false",
		"eureka.client.fetch-registry=false"
})
class ManagementMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
