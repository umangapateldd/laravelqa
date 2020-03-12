Feature: Events module scenario

  @EventsAdd
  Scenario: Event Add successfully with click on Save button
    Given Login as Admin and Go to "Events" Module
    When Verify table column in each grid "Events" page
    When Click on "Add" button in "Events"
    Then "Event" "Add" page gets open
    And Verify test data with proper validation message for "Events"
    When I enter all mandatory fields for "add" Event
    And Click on "Save" button in "Event"
    Then I should get "event added successfully." message on "Events"
    Then Verify details in "Events"

  @EventsEdit
  Scenario: Category Edit successfully with click on Save button
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Edit" button in "Events"
    Then "Event" "Edit" page gets open
    And Verify test data with proper validation message for "Events"
    When I enter all mandatory fields for "edit" Event
    And Click on "Save" button in "Event"
    Then I should get "event updated successfully." message on "Events"
    Then Verify details in "Events"

  @EventsActiveInactive
  Scenario: Event Active Inactive
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And "Events" is "Active"
    Then Make "Events" "Inactive" and verify "success message"
    #Then Verify details in "Events grid with other filters"
    When Verify details in "Events"
    And "Events" is "Inactive"
    Then Make "Events" "Active" and verify "success message"
    Then Verify details in "Events"

  @EventsDelete
  Scenario: Event Delete successfully
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Delete" button in "Events"
    Then I should get "Selected event(s) have been deleted successfully." message on "Events"
    Then Verify details in "Events"

  @EventsAddSaveContinue
  Scenario: Event Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Events" Module
    When Click on "Add" button in "Events"
    Then "Event" "Add" page gets open
    When I enter all mandatory fields for "add" Event
    And Click on "Save and Continue" button in "Event"
    Then I should get "event added successfully." message on "Events"
    Then Verify details in "Events"

  @EventsEditSaveContinue
  Scenario: Event Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Edit" button in "Events"
    Then "Event" "Edit" page gets open
    When I enter all mandatory fields for "edit" Event
    And Click on "Save and Continue" button in "Event"
    Then I should get "event updated successfully." message on "Event"
    Then Verify details in "Events"