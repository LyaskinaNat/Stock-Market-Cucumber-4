package pageobjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ReadConfig;

import java.util.List;
public class StockPage extends BasePage {

    public Integer dividendYieldIndex = 1;
    public Integer PERatiodIndex = 2;
    public Integer geometricMeandIndex = 3;
    public Integer volumeWeightedStockPriceIndex = 4;


    public String stockTableRows = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[2]/table[1]/tbody[1]/tr";
    public List<WebElement> rows = driver.findElements(By.xpath(stockTableRows));

    public StockPage() {
        super();
    }

    public StockPage assertDisplayedValue (String stock, int index, String testDataKey) {
        List<WebElement> rows = driver.findElements(By.xpath(stockTableRows));
        rows.forEach((row) -> {
            String rowText = row.getText();
            String expectedValue = ReadConfig.getConfigData("config/testData.properties", testDataKey);
            if (rowText.contains(stock)) {
                String strArray[] = rowText.split(" ");
                String actualValue = strArray[index];
                System.out.println("Expected Value: " + expectedValue + ", Actual Value: " + actualValue);
                System.out.print(System.lineSeparator());
                Assert.assertEquals("Test failed. Actual value: " + actualValue + " doesn't match the expected value: " + expectedValue, expectedValue, actualValue);
            }

        });

        return new StockPage();
    }
}
