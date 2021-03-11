@TravelWithreturn
Feature: FLight Ticket Booking

  @Test1
  Scenario: User books the flight ticket
    Given The user should go to the home page of the travel website
    Then Enter the details to book the flight
    And Click book a plane
    And Scroll the page until the planes are visible
    And click on the details link and store details in map
    And Click on the go button
    And Click on the details section for return and verify
    And Click on the select go button for return
    And Click on the details section and verify detail
    And Click on the detail section for return
    And Enter the details to book a plane
    And Click on continue ordering to book flight
    And Click on the details section and verify the values
    And Click on the detail section and verify the values for return
