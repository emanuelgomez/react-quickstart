Feature: As a User I want to get the home page so that I can start using the site.

  Scenario: Can get home page
    Given I am a user
    When I go to the home page
    Then I should see the home page
