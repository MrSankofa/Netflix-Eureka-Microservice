1. When trying to run a ```mvn clean install``` after downloading the spring initializr project, you need do one these things first

Option 1: Disable Eureka in Test Context
If you don’t need service registration in your test (which is usually the case for unit/integration tests), you should disable Eureka during tests.

Add this to src/test/resources/application.properties:

application properties
```
eureka.client.enabled=false
```

Or if you're using @SpringBootTest, you can override properties directly:

```java
@SpringBootTest(properties = {
"eureka.client.enabled=false",
"eureka.client.register-with-eureka=false",
"eureka.client.fetch-registry=false"
})
public class ManagementMicroserviceApplicationTests {
// your tests
}
```


Option 2: Add a Test Profile
If you already use profiles, you could define a test profile that disables Eureka:

src/test/resources/application-test.properties:

properties
```
spring.profiles.active=test
eureka.client.enabled=false
```

Annotate the test class like this:

```java
@ActiveProfiles("test")
@SpringBootTest
public class ManagementMicroserviceApplicationTests {
}
```


2. add the @EnableEurekaService to your boot component

```java

@SpringBootApplication
@EnableEurekaServer
public class ManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementMicroserviceApplication.class, args);
	}

}

```


3. Navigate to ```localhost:8085``` to see the dashboard
