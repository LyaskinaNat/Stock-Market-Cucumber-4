package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.StockPage;
import pageobjects.TradePage;


public class DriverFactory {
    public  static WebDriver driver;
    public  static String appUrl;
    public  static String browser;
    public  static StockPage stockPage;
    public  static TradePage tradePage;
    public  ChromeOptions options = new ChromeOptions();


    public WebDriver getDriver() {

        browser = ReadConfig.getConfigData("config/testEnv.properties", "browser");
        String exePath;
        try {

            switch (browser) {
                case "chrome_local":
                      exePath = "src/test/drivers/chromedriver";
                      System.setProperty("webdriver.chrome.driver", exePath);
                      options.addArguments("--start-maximized");
                      driver = new ChromeDriver(options);

                    break;

                case "chrome_remote":
                    WebDriverManager.chromedriver().version("75.0.3770.8").setup();
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();

                    break;

                case "firefox_local":
                    exePath = "src/test/drivers/geckodriver.exe";
                    System.setProperty("webdriver.firefox.driver", exePath);
                    driver = new FirefoxDriver();
                    break;

                case "firefox_remote":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    options.addArguments("--start-maximized");
                    options.addArguments("update --versions.chrome=75.0.3770.80");
                    driver = new ChromeDriver(options);
                    break;
            }


        } catch (Exception e) {
            System.out.println("Error when opening a browser: " + e.getMessage());

        }
        finally {
              stockPage = PageFactory.initElements(driver, StockPage.class);
              tradePage = PageFactory.initElements(driver, TradePage.class);


        }
        return driver;
    }

    public static void goToAppHomePage() {

        appUrl = ReadConfig.getConfigData("config/testEnv.properties", "appURL");

        try {
            driver.get(appUrl);

        }   catch (Exception e) {
            Assert.fail("Unable to open App Home page, Exception: " + e.getMessage());
        }



    }




}


