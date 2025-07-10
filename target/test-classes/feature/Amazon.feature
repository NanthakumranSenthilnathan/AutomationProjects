@Amazon
Feature: Amazon
  I want to launch the amazon application

  @AmazonLaunch
  Scenario: Launch the application
      Given Browser launched <name> and <url>
      Then Close Driver
       Examples:
      | name | url |
      | Amazon | https://www.amazon.in |
      
  #@testLaunch
  #Scenario: Launch the application
      #Then Browser launched successfully