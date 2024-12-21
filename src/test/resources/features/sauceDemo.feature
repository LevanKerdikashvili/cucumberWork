Feature: SauceDemo website functionality testing with valid and invalid login flow


  Background:
    Given the browser is launched and "https://saucedemo.com" login page is opened


    #ავტორიზაცია
  Scenario: Successful login and adding a product to the cart
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on login button
    Then the user should be redirected to the Products page "https://www.saucedemo.com/inventory.html"


  Scenario Outline: Successful login and verifying cart functionality for different user
    When the user enters valid username "<username>" and password "<password>"
    And clicks on login button
    Then the user should be redirected to the Products page "https://www.saucedemo.com/inventory.html"
    And the user adds "<product>" to the cart
    And navigate to the cart page
    And the cart should contains "<product>"

    Examples:
      | username                | password     | product                 |
      | standard_user           | secret_sauce | Sauce Labs Backpack     |
      | problem_user            | secret_sauce | Sauce Labs Bike Light   |
      | performance_glitch_user | secret_sauce | Sauce Labs Bolt T-Shirt |


  Scenario: Successful login and sorting products by price
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks on login button
    And the user should be redirected to the Products page "https://www.saucedemo.com/inventory.html"
    And the user sorts the products by "Price (low to high)"
    Then the first product should be "Sauce Labs Onesie"


