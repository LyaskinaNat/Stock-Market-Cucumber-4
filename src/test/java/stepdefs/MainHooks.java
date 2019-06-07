package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;


public class MainHooks extends DriverFactory {

        @Before

        public void setup() {
            driver = getDriver();

        }


        @After

        public void tearDown() {

            try {

                driver.manage().deleteAllCookies();
                driver.quit();

            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

}

