package au.com.telstra.simcardactivator.stepDefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import au.com.telstra.simcardactivator.SimCardActivator;

@CucumberContextConfiguration
@SpringBootTest(classes = SimCardActivator.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CucumberSpringContextConfiguration {
}
