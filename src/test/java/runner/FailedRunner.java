package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = "stepDefinitions",
        plugin = {
                "pretty"
        }
)
public class FailedRunner
        extends AbstractTestNGCucumberTests {

}