package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pageobjects.BasePage;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        },
        features = "src/test/resources/features/",
        glue = {"stepdefs"},
        tags = {})

public class RunnerTest {
        @AfterClass
        public static void writeExtentRepoirt () throws IOException {
                BasePage.copyLatestExtentReport();
        }


}
