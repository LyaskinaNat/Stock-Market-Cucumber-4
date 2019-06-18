# For a given stock,  calculate Volume Weighted Stock Price based on trades in past 15 minutes

Feature: Volume Weighted Stock Price Calculation for a given stocks
  Background:
    Given   I am on Simple Stock page

  @regression
  Scenario Outline: Calculate Volume Weighted Stock Price for a given stock
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

    Then I see calculated Volume Weighted Stock Price for <stock> stock for all trades
    Examples:
      |  stock   |  numberOfTrades   |
      |   TEA    |        1          |
      |   POP    |        2          |
      |   ALE    |        3          |
      |   GIN    |        5          |
      |   JOE    |        10         |

  @longrun
  Scenario: Calculate Volume Weighted Stock Price for a given stock for trades in past 15 min
    When  I made trades with the following data
      |  stock   |  price   |  quantity   |  buyOrSell   |
      |   TEA    |   100    |     20      |     Buy      |
    And I wait 16 min
    And  I made trades with the following data
      |  stock   |  price   |  quantity   |  buyOrSell   |
      |   TEA    |   150    |     50      |     Buy      |
    Then I see calculated Volume Weighted Stock Price for a given stock for trades in past 15 min









