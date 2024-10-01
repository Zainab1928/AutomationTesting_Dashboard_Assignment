package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                //"src/test/java/features/login.feature",   // Login feature
                //"src/test/java/features/dashboard.feature"  // Dashboard feature
                //"src/test/java/features"  //patient feature
                //"src/test/java/features/Patient.feature"
                "src/test/java/features/Patient-Information-Verification.feature"

        },
        glue = {"StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner {
}
