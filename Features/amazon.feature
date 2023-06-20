

Feature: Testing the amazon application

  Background: 
    Given Launching the browser
    And Launch the application
    When enter the  valid data
    And clcik on sign in button

  Scenario: login and logout the amazon application
    And click on the hamburger icon
    Then click on signout

  Scenario: Add the Product to cart
    Then Select the product
    Then click on the product
    Then click on the Buynow Button
    Then Add the address details
