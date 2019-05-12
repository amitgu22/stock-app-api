Feature: Get a stock
  In order to learn what weather conditions were like at a specific time
  I want to be able to retrieve a stock of several metrics at that time

  Background:
   
  Scenario: Get a specific stock
    # GET /stocks/2015-09-01T16:20:00.000Z
    When I get a stock for "2015-09-01T16:20:00.000Z"
    Then the response has a status code of 200
    And the response body is:
      ID | STOCK_NAME    |STOCK_PRICE |timestamp                  | 
      19 | LNT      	 |454566      |"2019-05-12T16:42:46.979+0000" |

  