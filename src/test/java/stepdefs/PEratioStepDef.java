package stepdefs;

import cucumber.api.java.en.*;
import dataobjects.*;
import utils.DriverFactory;

import java.io.IOException;
import java.util.List;

import static utils.DriverFactory.*;



public class PEratioStepDef {


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
