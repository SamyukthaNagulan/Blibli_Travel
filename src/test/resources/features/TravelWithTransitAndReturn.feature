@TravelWithReturnAndTransit
Feature: FLight Ticket Booking

  @Test1
  Scenario: User books the flight ticket with return
    Given The user should go to home page of blibli travel website
    Then User enters the details to book a flight
    And User clicks book a flight
    And User scrolls the page until the flights are visible
    And User clicks on the detail link and store details in map
    And User clicks on the select go button
    And User clicks on the detail section for return and verify the values
    And User clicks on the select go button for return
    And User clicks on the detail section and verify
    And User clicks on the detail section for return
    And User enters the details to proceed
    And User clicks on continue ordering
    And User clicks on the detail section and verify the values
    And User clicks on the detail section and verify the values for return



