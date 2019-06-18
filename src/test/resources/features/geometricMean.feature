# Calculate the GBCE All Share Index using the geometric mean of prices for all stocks

@regression
Feature: Geometric Mean Calculation for all prices for a given stock
  Scenario Outline: Calculate Geometric Mean for all prices for a given stock
    Given   I am on Simple Stock page
    When  I made <numberOfTrades> trades for <stock> stock with the following data
      |  price   |  quantity   |  buyOrSell    |
      |   100    |     90      |     Buy       |
      |   110    |     100     |     Buy       |
      |   105    |     121     |     Sell      |
      |   60     |     201     |     Sell      |
      |   65     |     199     |     Buy       |
      |   68     |     280     |     Buy       |
      |   100    |     85      |     Sell      |
      |   107    |     80      |     Sell      |
      |   110    |     86      |     Buy       |
      |   200    |     55      |     Sell      |
    Then I see calculated Geometric Mean for all prices for <stock> Stock in My Stock section
    Examples:
      |  stock   |  numberOfTrades   |
      |   TEA    |        1          |
      |   POP    |        2          |
      |   ALE    |        3          |
      |   GIN    |        5          |
      |   JOE    |        10         |