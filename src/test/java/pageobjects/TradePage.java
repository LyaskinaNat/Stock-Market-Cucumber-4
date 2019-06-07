package pageobjects;


import dataobjects.TradesDfStock;
import dataobjects.TradesSmStock;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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

    public TradePage() {
        super();

    }

    public TradePage makeTrades (int numberOfTrades, String stock, List<TradesSmStock> trades) {

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

    public TradePage makeTradesForDfStock (List<TradesDfStock> trades) {
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

}
