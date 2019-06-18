package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.BasePage;

import java.io.IOException;

import static utils.DriverFactory.*;

public class RecordTradeStepDef {

    @Then("The trade record has (.+) header")
    public void the_trade_record_has_the_following_headers(String header) throws IOException {
        String expectedKey = header;
        switch (header) {

            case "Transaction Date":
                tradePage.assertDisplayedValueTrades(tradePage.timeStampKey, expectedKey);
                break;

            case "Stock":
                tradePage.assertDisplayedValueTrades(tradePage.stockKey, expectedKey);
                break;

            case "Price":
                tradePage.assertDisplayedValueTrades(tradePage.priceKey, expectedKey);
                break;

            case "No. Shares Purchased":
                tradePage.assertDisplayedValueTrades(tradePage.quantityKey, expectedKey);
                break;

            case "Buy or Sell":
                tradePage.assertDisplayedValueTrades(tradePage.buySellKey, expectedKey);
                break;
        }

    }


    @Then("^The trade records have trade data populated in (.+) fields$")
    public void the_trade_records_has_trade_data_populated_in_fields(String header) throws IOException {

        switch (header) {

            case "Transaction Date":
                tradePage.assertValuePopulatedTrades(tradePage.timeStampValue);
                break;

            case "Stock":
                tradePage.assertValuePopulatedTrades(tradePage.stockValue);
                break;

            case "Price":
                tradePage.assertValuePopulatedTrades(tradePage.priceValue);
                break;

            case "No. Shares Purchased":
                tradePage.assertValuePopulatedTrades(tradePage.quantityValue);
                break;

            case "Buy or Sell":
                tradePage.assertValuePopulatedTrades(tradePage.buySellValue);
                break;

        }

    }

    @And("^I attempt to made a trade with (.+) missing input$")
    public void i_attempt_to_made_a_trade_with_Stock_missing_input(String missingInput) throws  Throwable {
        //       Select oSelect = new Select(tradePage.selectStock);
        switch (missingInput) {

            case "Stock":
                tradePage.CustomInputsForTrade("Choose Stock", "100", "80" /*, "Buy"*/);
                break;

            case "Price":
                tradePage.CustomInputsForTrade("TEA", "", "80" /*, "Buy"*/);
                break;

            case "Quantity":
                tradePage.CustomInputsForTrade("TEA", "100", "" /*, "Buy"*/);
                break;

            //        case "BuyOrSell":
            //             tradePage.CustomInputsForTrade("TEA", "100", "80", "");
            //             break;

        }

    }

    @And("^I enter all required inputs to make a trade$")
    public void i_enter_all_required_inputs_to_make_a_trade() throws IOException {
        tradePage.CustomInputsForTrade("POP", "150", "300" /*, "Buy"*/);

    }

    @And("^I then delete (.+) input$")
    public void i_then_delete_Stock_input(String missingInput) throws IOException {
        switch (missingInput) {
            case "Stock":
                tradePage.deleteTradeInput(missingInput);
                break;

            case "Price":
                tradePage.deleteTradeInput(missingInput);
                break;

            case "Quantity":
                tradePage.deleteTradeInput(missingInput);
                break;

            //        case "BuyOrSell":
            //            tradePage.deleteTradeInput(missingInput);
            //            break;

        }
    }

    @When("^I click on Submit button$")
    public void i_click_on_Submit_button() {
        tradePage.submit.click();

    }

    @Then("(.+) trades for (.+) Stock are successfully recorded in Recent Trades section$")
    public void trades_for_Stock_are_successfully_recorded_in_Recent_Trades_section(Integer numberOfTrades, String stock) throws IOException {

        tradePage.assertNumberOfTradesRecorded(numberOfTrades, stock);

    }

    @Then("^Trade with missing (.+) input is not recorded$")
    public void trade_is_not_recorded(String missingInput) throws IOException {

        switch (missingInput) {
            case "Stock":
                tradePage.tradeRecordExists(missingInput, "tradeRecordExpected");
                break;

            case "Price":
                tradePage.tradeRecordExists(missingInput, "tradeRecordExpected");
                break;

            case "Quantity":
                tradePage.tradeRecordExists(missingInput, "tradeRecordExpected");
                break;

            //          case "BuyOrSell":
            //            tradePage.tradeRecordExists(missingInput, "tradeRecordExpected");
            //            break;

        }

    }

    @Then("^The trade is recorded in Recent Trades section$")
    public void trade_is_recorded_in_recent_trades_section() throws IOException {
        tradePage.tradeRecordDoesntExists("tradeRecordExpected");

    }

}






