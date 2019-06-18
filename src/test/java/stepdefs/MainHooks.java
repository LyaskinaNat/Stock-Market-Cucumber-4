package stepdefs;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobjects.BasePage;
import utils.DriverFactory;


public class MainHooks extends DriverFactory {


    @Before

    public void setup() {
        driver = getDriver();

    }


    @After

    public void tearDownAndScreenShotOnFailure(Scenario scenario) {


        try {
            if (driver != null && scenario.isFailed()) {
                BasePage.captureScreenshot(scenario);
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }

        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenShotOnFailure, Exception:" + e.getMessage());
        }
    }

}




