Featcmure: Sauce Demo Automation using Selenium cucumber java
@MercatorTest
  Scenario: Login and add highest priced item to cart
    Given user navigates to SauceDemo login page
    When user enters username and password
    And user selects the highest priced item
    Then user adds the selected item to the cart
