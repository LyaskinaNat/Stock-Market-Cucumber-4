  # For a given stock, given any price as input, calculate the dividend yield

  @regression
  Feature: Dividend Yield Calculation
    Background:
      Given   I am on Simple Stock page
    Scenario Outline: Dividend Yield Calculation for each stock based on stock type (Common/Preferred)
      When  I made <numberOfTrades> trades for <stock> stock with the following data
        |  price    |  quantity   |  buyOrSell   |
        |   150     |     20      |     Buy      |
      Then I see Dividend Yield for <stock> Stock in My Stock section based on stock type
      Examples:
        |  stock    |  numberOfTrades   |
        |   TEA     |        1          |
        |   POP     |        1          |
        |   ALE     |        1          |
        |   GIN     |        1          |
        |   JOE     |        1          |
    Scenario: Dividend Yield Calculation for a given stock based on last trade price
      When  I made trades with the following data
        |  stock    |  price   |  quantity   |  buyOrSell   |
        |   POP     |   100    |     20      |     Buy      |
        |   POP     |   180    |     100     |     Sell     |
      Then I see Dividend Yield for a given Stock in My Stock section based on last trade price






