package stepdefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.stockPage;


public class DividendYieldStepDef {

    @Then("^I see Dividend Yield for (.+) Stock in My Stock section based on stock type$")
    public void i_see_Dividend_Yield_for_Stock_in_My_Stock_section_based_on_stock_type(String stock) throws Throwable {


        switch (stock) {
            case "TEA":
                stockPage.assertDisplayedValue(stock, stockPage.dividendYieldIndex, "expectedDividendYield_TEA");
                break;

            case "POP":
                stockPage.assertDisplayedValue(stock, stockPage.dividendYieldIndex, "expectedDividendYield_POP");
                break;

            case "ALE":
                stockPage.assertDisplayedValue(stock, stockPage.dividendYieldIndex, "expectedDividendYield_ALE");
                break;

            case "GIN":
                stockPage.assertDisplayedValue(stock, stockPage.dividendYieldIndex, "expectedDividendYield_GIN");
                break;

            case "JOE":
                stockPage.assertDisplayedValue(stock, stockPage.dividendYieldIndex, "expectedDividendYield_JOE");
                break;
        }

    }

    @Then("I see Dividend Yield for a given Stock in My Stock section based on last trade price")
    public void i_see_Dividend_Yield_for_Stock_in_My_Stock_section_based_on_last_trade_price() throws Throwable {

        stockPage.assertDisplayedValue("POP", stockPage.dividendYieldIndex, "expectedDividendYield_POP_last");


    }
}

