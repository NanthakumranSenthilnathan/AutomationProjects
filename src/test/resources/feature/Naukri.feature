@Naukri
Feature: Naukri
  I want to launch the naukri application, update a section to keep my profile active.

  @Naukri
  Scenario: Launch the application
      Given Browser launched <name> and <url>
      When Login in to the Naukri application
      Then Update the Resume Headline
      And Close Driver
       Examples:
      | name | url |
      | naukri | https://www.naukri.com|
      
