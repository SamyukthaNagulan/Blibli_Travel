@Travel_With_Transit
  Feature: User books a flight with transit

    @Test1
    Scenario: User books a flight with transit
      Given User should go to the home page of the blibli travel website
      Then Enter the details to book
      And Click book a flight to book
      And Scroll the page until the required flight is seen
      And Click on the detail section and store details in map
      And Click on select go button
      And Click on the detail section and verify details
      And Enter the details to proceed to order
      And Click on continue ordering to book
      And Click on the detail section and verify the details
