Feature: search
  
  Searching for a product should give results
    Background:
  	Given the browser has to open here
  @Smoketest	
  Scenario: Successful search results found
    Given website is open
    When I enter a search keyword 
    And press enter key "mouse"
    Then validate search results
   
#Examples:

#|key|
#|laptop|
#|mouse|
@Negative
 Scenario: Unsuccessful search
    Given website is open
    When I enter a search keyword 
    And press enter key "addass"
    Then validate search results
   
