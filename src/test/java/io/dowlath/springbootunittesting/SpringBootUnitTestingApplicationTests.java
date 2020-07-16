package io.dowlath.springbootunittesting;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/* src/test/resources -> folder create the file called test-configuration.properties and
 define the corresponding properties. */
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class SpringBootUnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

}
