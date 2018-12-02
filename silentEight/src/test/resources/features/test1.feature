Feature: Test1 Feature

  Scenario: Edit assignment test
    Given Open browser and go to "http://sens.silenteight.com/"
    When Login
    And copy decision tree in use if there is none in available section
    And Open first available decision tree
    And Open edit assignments window
    And assign "IN_PERD_DENY" as Available
    And assign "BH_BTCH_PEPL" as Assigned
    And assign "SG_BTCH_AM" as Active
    Then check error message