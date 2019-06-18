  # For a given stock, record a trade with timestamp, quantity of shares, buy or sell indicator and traded price

  @regression @smoke
  Feature: Record a trade

    Background:
      Given   I am on Simple Stock page

  # User input validation - positive
    Scenario: Trade is submitted successfully if all required fields are filled in
      When  I made trades with the following data
        |  stock    |  price   |  quantity   |  buyOrSell    |
        |   TEA     |   100    |     20      |     Sell      |
      Then The trade is recorded in Recent Trades section

  # User input validation - negative
    Scenario Outline: Recorded trade cannot be submitted if some input fields are empty
      And  I attempt to made a trade with <missingInput> missing input
      When I click on Submit button
      Then Trade with missing <missingInput> input is not recorded
      Examples:
        |    missingInput   |
        |       Stock       |
        |       Price       |
        |      Quantity     |
  #     |      BuyOrSell    |

  # User input validation - negative(Edge case)
    Scenario Outline: Recorded trade cannot be submitted if some input fields are entered and then deleted
      And I enter all required inputs to make a trade
      And  I then delete <missingInput> input
      When I click on Submit button
      Then Trade with missing <missingInput> input is not recorded
      Examples:
        |    missingInput   |
        |       Stock       |
        |       Price       |
        |      Quantity     |
  #     |      BuyOrSell    |


  # Trade record validation
    Scenario Outline: Recorded trade contains required headers
      When  I made trades with the following data
        |  stock   |  price   |  quantity   |  buyOrSell    |
        |   TEA    |   100    |     20      |     Sell      |

      Then The trade record has <header> header
      Examples:
        |      header         |
        | Transaction Date    |
        |      Stock          |
        |      Price          |
        |No. Shares Purchased |
        |    Buy or Sell      |

    Scenario Outline: Recorded trades are populated with the trade data
      When  I made trades with the following data
        |  stock   |  price   |  quantity   |  buyOrSell   |
        |   TEA    |   100    |     20      |     Sell     |

      Then The trade records have trade data populated in <header> fields
      Examples:

        |      header         |
        | Transaction Date    |
        |      Stock          |
        |      Price          |
        |No. Shares Purchased |
        |    Buy or Sell      |

  # Trade record validation (boundary value analysis)

    Scenario Outline: I can record a required number of trades consequently
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
      Then  <numberOfTrades> trades for <stock> Stock are successfully recorded in Recent Trades section
      Examples:
        |  stock   |  numberOfTrades   |
        |   TEA    |        1          |
        |   POP    |        2          |
        |   ALE    |        20         |

