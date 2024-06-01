#Author: QA Team
#Language: en

Feature: Find out the U de A official page across the Google search Eng.

  Scenario: Search the udea official page across the Google search Eng.
    Given I am in the google page
    When I search U de A word in the Google search eng
    Then I can see the official udea link
