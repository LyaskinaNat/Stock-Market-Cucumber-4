package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataobjects.TradesDfStock;
import dataobjects.TradesSmStock;
import utils.DriverFactory;

import java.io.IOException;
import java.util.List;

import static utils.DriverFactory.tradePage;

public class SharedStepDefs {

    @Given("I am on Simple Stock page")
    public void i_am_on_Simple_Stock_page() {
        DriverFactory.goToAppHomePage();
    }

    @When("I made (.+) trades for (.+) stock with the following data")
    public void i_made_trades_for_stock_with_the_following_data(Integer numberOfTrades, String stock, List<TradesSmStock> trades) throws IOException {

        switch (stock) {
            case "TEA": tradePage.makeTrades(numberOfTrades, stock, trades);
                break;

            case "POP": tradePage.makeTrades(numberOfTrades, stock, trades);
                break;

            case "ALE": tradePage.makeTrades(numberOfTrades, stock, trades);
                break;

            case "GIN": tradePage.makeTrades(numberOfTrades, stock, trades);
                break;

            case "JOE": tradePage.makeTrades(numberOfTrades, stock, trades);
                break;
        }
    }

    @When("I made trades with the following data")
    public void i_made_trades_with_the_following_data(List<TradesDfStock> trades) throws IOException {
        tradePage.makeTradesForDfStock(trades);
    }

}
