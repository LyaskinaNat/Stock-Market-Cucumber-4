  # For a given stock, given any price as input, calculate the P/E Ratio
  @regression
  Feature: P/E Ratio Calculation

    Background:
      Given   I am on Simple Stock page

    Scenario Outline: P/E Ratio Calculation for a given stock
      When  I made <numberOfTrades> trades for <stock> stock with the following data
        | price | quantity | buyOrSell |
        | 150   | 20       | Sell      |
        | 110   | 86       | Buy       |
        | 200   | 55       | Sell      |

      Then I see the P/E Ratio for <stock> Stock in My Stock section calculated
      Examples:

        | stock | numberOfTrades |
        | TEA   | 1              |
        | POP   | 1              |
        | ALE   | 1              |
        | GIN   | 1              |
        | JOE   | 1              |

    Scenario: P/E Ratio Calculation for a given stock based on the last trade price
      When  I made trades with the following data
        | stock | price | quantity | buyOrSell |
        | POP   | 100   | 20       | Buy       |
        | POP   | 180   | 100      | Sell      |
      Then I see the P/E Ratio for a given Stock in My Stock section based on last trade price
