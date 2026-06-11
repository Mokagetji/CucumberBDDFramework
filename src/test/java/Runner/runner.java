package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Steps"},
        tags = "@createGroup", //tags help you choose which tests to run or group together
        plugin = {"html:target/cucumber-report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true, //Optional - it's purpose is to make the report look nicer
        publish = true //Optional - it's purpose is to publish the report
)

public class runner extends AbstractTestNGCucumberTests {
}
