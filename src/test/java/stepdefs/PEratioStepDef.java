package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataobjects.TradesDfStock;
import dataobjects.TradesSmStock;
import utils.DriverFactory;
import java.util.List;

import static utils.DriverFactory.*;



public class PEratioStepDef {


    @Given("I am on Simple Stock page")
    public void i_am_on_Simple_Stock_page() {
        DriverFactory.goToAppHomePage();
    }

        @When("I made (.+) trades for (.+) stock with the following data")
    public void i_made_trades_for_stock_with_the_following_data(Integer numberOfTrades, String stock, List<TradesSmStock> trades) {

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
    public void i_made_trades_with_the_following_data(List<TradesDfStock> trades) {
        tradePage.makeTradesForDfStock(trades);
    }

    @Then("^I see the P/E Ratio for (.+) Stock in My Stock section calculated$")
    public void i_see_the_P_E_Ratio_for_Stock_in_My_Stock_section_calculated(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                stockPage.assertDisplayedValue(stock, stockPage.PERatiodIndex, "expectedPERatio_TEA");
                break;

            case "POP":
                stockPage.assertDisplayedValue(stock, stockPage.PERatiodIndex, "expectedPERatio_POP");
                break;

            case "ALE":
                stockPage.assertDisplayedValue(stock, stockPage.PERatiodIndex, "expectedPERatio_ALE");
                break;

            case "GIN":
                stockPage.assertDisplayedValue(stock, stockPage.PERatiodIndex, "expectedPERatio_GIN");
                break;

            case "JOE":
                stockPage.assertDisplayedValue(stock, stockPage.PERatiodIndex, "expectedPERatio_JOE");
                break;
        }
    }

    @Then("^I see the P/E Ratio for a given Stock in My Stock section based on last trade price$")
    public void i_see_the_P_E_Ratio_for_a_given_Stock_in_My_Stock_section_based_on_last_trade_price() throws Throwable {

        stockPage.assertDisplayedValue("POP", stockPage.PERatiodIndex, "expectedPERatio_POP_last");


    }
}
