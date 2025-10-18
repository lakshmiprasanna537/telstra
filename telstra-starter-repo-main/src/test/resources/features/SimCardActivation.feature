Feature: SIM Card Activation
  As a user of the SIM card activation microservice
  I want to activate SIM cards successfully
  So that I can use the service without errors

  Scenario: Successful SIM card activation
    Given the actuator service is running
    When I submit an activation request with ICCID "1255789453849037777"
    Then the activation should be successful
    And the activation record with ID 1 should exist in the database

  Scenario: Failed SIM card activation
    Given the actuator service is running
    When I submit an activation request with ICCID "8944500102198304826"
    Then the activation should fail
    And the activation record with ID 2 should exist in the database
