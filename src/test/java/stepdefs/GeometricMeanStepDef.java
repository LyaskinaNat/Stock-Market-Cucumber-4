package stepdefs;

import cucumber.api.java.en.Then;
import static utils.DriverFactory.stockPage;


public class GeometricMeanStepDef {

    @Then("I see calculated Geometric Mean for all prices for (.+) Stock in My Stock section")
    public void i_see_calculated_Geometric_Mean_for_all_prices_for_Stock_in_My_Stock_section(String stock) throws Throwable {

        switch (stock) {
            case "TEA":
                stockPage.assertDisplayedValue(stock, stockPage.geometricMeandIndex, "expectedGeoMean_TEA");
                break;

            case "POP":
                stockPage.assertDisplayedValue(stock, stockPage.geometricMeandIndex, "expectedGeoMean_POP");
                break;

            case "ALE":
                stockPage.assertDisplayedValue(stock, stockPage.geometricMeandIndex, "expectedGeoMean_ALE");
                break;

            case "GIN":
                stockPage.assertDisplayedValue(stock, stockPage.geometricMeandIndex, "expectedGeoMean_GIN");
                break;

            case "JOE":
                stockPage.assertDisplayedValue(stock, stockPage.geometricMeandIndex, "expectedGeoMean_JOE");
                break;
        }

    }


}





