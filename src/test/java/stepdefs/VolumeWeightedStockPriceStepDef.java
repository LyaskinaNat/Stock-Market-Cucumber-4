package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static utils.DriverFactory.*;
import static utils.DriverFactory.stockPage;


public class VolumeWeightedStockPriceStepDef {

    @And("^I wait (\\d+) min$")
    public void i_wait_min(int min) throws Throwable {

        //Waiting 16 min

        Integer millisecs = 60000 * min;
        Thread.sleep(millisecs);

    }

    @Then("^I see calculated Volume Weighted Stock Price for (.+) stock for all trades")
    public void i_see_calculated_Volume_Weighted_Stock_Price_for_stock_for_all_trades(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                stockPage.assertDisplayedValue(stock, stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice_TEA");
                break;

            case "POP":
                stockPage.assertDisplayedValue(stock, stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice_POP");
                break;

            case "ALE":
                stockPage.assertDisplayedValue(stock, stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice_ALE");
                break;

            case "GIN":
                stockPage.assertDisplayedValue(stock, stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice_GIN");
                break;

            case "JOE":
                stockPage.assertDisplayedValue(stock, stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice_JOE");
                break;
        }

    }


    @Then("^I see calculated Volume Weighted Stock Price for a given stock for trades in past 15 min")
    public void i_see_calculated_Volume_Weighted_Stock_Price_for_a_given_stock_for_trades_in_past_15_min() throws Throwable {

        stockPage.assertDisplayedValue("TEA", stockPage.volumeWeightedStockPriceIndex, "expectedVolumeWeightedStockPrice15_TEA");

    }
}





