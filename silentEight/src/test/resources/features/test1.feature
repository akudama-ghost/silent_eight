Feature: Test1 Feature

  Scenario: Open browser and go to test start page
    Given Open browser and go to "http://sens.silenteight.com/"
    When Login
    And Open first available decision tree for 5 times
    And edit assignments
    Then count deactivate buttons