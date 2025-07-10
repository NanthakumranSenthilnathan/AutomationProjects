@Flipkart
Feature: Flipkart
  I want to launch the Flipkart application

  @FlipkartLaunch
  Scenario: Launch the application
    Given Browser launched <name> and <url>
    Then Close Driver
       Examples:
      | name | url |
      | Flipkart |https://www.flipkart.com/ |