package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features/Registration.feature",
	    glue = {"stepDefinitions"},
	    plugin = {"pretty", "html:target/cucumber-reports.html"},
	    monochrome = true
)
public class RegistrationTestRunner extends AbstractTestNGCucumberTests {
}

