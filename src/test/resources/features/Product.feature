@debug
Feature: Product feature

  @Positive
  Scenario Outline: Search a valid product list
    Given I want to see all the available "<product>" products in my e-commerce shop
    When I search for all "<product>" products
    Then I should retrieve a list of products
    Examples:
      | product |
      | orange  |
      | apple   |
      | pasta   |
      | cola    |

  @Negative
  Scenario Outline: Search a invalid product list
    Given I attempt to see unavailable products in my e-commerce shop
    When I search for all "<product>" products
    Then I should see the correct error message "<product>" not found
    Examples:
      | product    |
      | Javelin    |
#        |            |
      | M142 HIMAR |
      | %%%        |

  @Positive
  Scenario Outline: Search a valid product with specific attribute
    Given I want to see all the available products in his shop with a specific attribute
    When I searches for all "<product>" products with "<attribute>" attribute that includes "<specification>"
    Then I should retrieve one or more product
    Examples:
      | product | attribute | specification |
      | orange  | provider  | Vomar         |