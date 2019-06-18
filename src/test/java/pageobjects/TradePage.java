package pageobjects;


import dataobjects.TradesDfStock;
import dataobjects.TradesSmStock;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ReadConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TradePage extends BasePage {

    //Make a trade section
    @FindBy(name = "stockSymbol")
    public WebElement selectStock;

    @FindBy(name = "price")
    public WebElement price;

    @FindBy(name = "quantity")
    public WebElement quantity;

//  @FindBy(name = "buySell")
//  public WebElement buySellIndicator;

    @FindBy(name = "submit-button")
    public WebElement submit;

    //Recent Trades section

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[1]")
    public WebElement timeStampKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
    public WebElement timeStampValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[2]")
    public WebElement stockKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]")
    public WebElement stockValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[3]")
    public WebElement priceKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]")
    public WebElement priceValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[4]")
    public WebElement quantityKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]")
    public WebElement quantityValue;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/td[5]")
    public WebElement buySellKey;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[5]")
    public WebElement buySellValue;

    public String recentTradesTableRows = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/table[1]/tbody[1]/tr";



    public TradePage() throws IOException {
        super();

    }

    public TradePage makeTrades (int numberOfTrades, String stock, List<TradesSmStock> trades) throws IOException {

        try {

            Select stockSelect = new Select(tradePage.selectStock);
            List<Integer> priceArr = new ArrayList<>();
            List<Integer> quantityArr = new ArrayList<>();
            for (TradesSmStock trade : trades) {
                priceArr.add(trade.getPrice());
                quantityArr.add(trade.getQuantity());
            }
            for (int i = 1; i <= numberOfTrades; i++) {
                stockSelect.selectByVisibleText(stock);
                String priceKey = priceArr.get((i - 1)).toString();
                String quantityKey = quantityArr.get((i - 1)).toString();
                tradePage.price.sendKeys(priceKey);
                tradePage.quantity.sendKeys(quantityKey);
                tradePage.submit.click();

            }
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
        }

            return new TradePage();
    }

    public TradePage makeTradesForDfStock (List<TradesDfStock> trades) throws IOException {
        try {
            Select stockSelect = new Select(tradePage.selectStock);
            List<String> stockArr = new ArrayList<>();
            List<Integer> priceArr = new ArrayList<>();
            List<Integer> quantityArr = new ArrayList<>();
            Integer size = trades.size();

            for (TradesDfStock trade : trades) {
                stockArr.add(trade.getStock());
                priceArr.add(trade.getPrice());
                quantityArr.add(trade.getQuantity());

            }

            for (int i = 0; i < size; i++) {
                String stockKey = stockArr.get((i));
                String priceKey = priceArr.get((i)).toString();
                String quantityKey = quantityArr.get((i)).toString();
                stockSelect.selectByVisibleText(stockKey);
                tradePage.price.sendKeys(priceKey);
                tradePage.quantity.sendKeys(quantityKey);
                tradePage.submit.click();
            }

       } catch (Exception e) {
                Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());
                }
        return new TradePage();
    }

    public TradePage CustomInputsForTrade (String stock, String price, String quantity/*,String buyOrSell*/) throws IOException {

        try {
            Select oSelect = new Select(selectStock);
            oSelect.selectByVisibleText(stock);
            tradePage.price.sendKeys(price);
            tradePage.quantity.sendKeys(quantity);
//          tradePage.buySell.sendKeys(buySell);
        } catch (Exception e) {
            Assert.fail("Unable to to locate WebElement or/and send keys to it, Exception: " + e.getMessage());

        }
        return new TradePage();
    }

    public TradePage deleteTradeInput (String testCase) throws IOException {
        if (testCase.equals("Stock")) {
            Select oSelect = new Select(tradePage.selectStock);
            oSelect.selectByVisibleText("Choose Stock");
        } else if (testCase.equals("Price")) {
            tradePage.price.sendKeys("");

        } else if (testCase.equals("Quantity")) {
            tradePage.quantity.sendKeys("");
        }

        //    } else if (testCase.equals("BuyOrell")) {
        //      tradePage.buyOrSell.sendKeys("");
        //    }

        return new TradePage();
    }



    public TradePage assertDisplayedValueTrades(WebElement element, String expectedValue) throws IOException {
        if (WaitUntilWebElementIsVisible(element)) {

            String actualValue = element.getText();
            System.out.println("Expected Value: " + expectedValue + ", Actual Value: " + actualValue);
            System.out.print(System.lineSeparator());
            Assert.assertEquals("Test failed. Actual value: " + actualValue + " doesn't match the expected value: " + expectedValue, expectedValue, actualValue);

        }
        return new TradePage();

    }

    public TradePage assertValuePopulatedTrades (WebElement element) throws IOException {
        if (WaitUntilWebElementIsVisible(element)) {

            String actualValue = element.getText();
            System.out.println("Recorded trade data is successfully populated, Data value: " + actualValue);
            System.out.print(System.lineSeparator());
            Assert.assertFalse("Data for " + element + " is not populated", actualValue.isEmpty());
        }
        return new TradePage();

    }

    public TradePage assertNumberOfTradesRecorded (Integer numberOfTrades, String stock) throws IOException {
        List<WebElement> rows = driver.findElements(By.xpath(tradePage.recentTradesTableRows));
        int count = rows.size();
        System.out.println("Expected number of recorded Trades  for " + stock + " is: " + numberOfTrades + ", Actual number of recorded Trades for " + stock + " is: " + count);
        Assert.assertTrue("Number of trade recorded (" + count + ") is different from number of trades made (" + numberOfTrades + ")", numberOfTrades.equals(count));

        return new TradePage();

    }

    public TradePage tradeRecordExists (String missingInput, String testDataKey) throws IOException {
        String actualRecord = tradePage.timeStampValue.getText();
        String expectedRecord = ReadConfig.getConfigData("config/testData.properties", testDataKey);
        Assert.assertEquals("Trade with missing " + missingInput + " input was recorded without the required data", expectedRecord, actualRecord);
        return new TradePage();
    }

    public TradePage tradeRecordDoesntExists (String testDataKey) throws IOException {
        String actualRecord = tradePage.timeStampValue.getText();
        String expectedRecord = ReadConfig.getConfigData("config/testData.properties", testDataKey);
        Assert.assertFalse("Trade with all required fields filled in is not recorded", actualRecord.contentEquals(expectedRecord));

        return new TradePage();
    }

}
