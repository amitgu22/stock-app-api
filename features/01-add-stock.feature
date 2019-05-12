Feature: Add a stock
  In order to have source information to examine later
  I want to be able to capture a stock of several metrics at a specific time

  Scenario: Add a stock with valid (numeric) values
    # POST /stock
    When I submit a new stock as follows:
     ID | STOCK_NAME |STOCK_PRICE |timestamp                  | 
     14 | ICICI      |233333      |"2019-05-12T16:42:46.979+0000" |
	 19 | LNT      	 |454566      |"2019-05-12T16:42:46.979+0000" |
	 18 | SBI        |645456      |"2019-05-12T16:42:46.979+0000" |
    Then the response has a status code of 201
    And the Location header has the path "/stock/2015-09-01T16:00:00.000Z"

  