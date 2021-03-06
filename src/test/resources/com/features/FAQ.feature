Feature: FAQ module scenario

  @FAQAdd
  Scenario: Create FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Verify table column in each grid "FAQs" page
    When Click on "Add" button in "FAQs"
    Then "FAQ" "Add" page gets open
    #And Verify test data with proper validation message for "FAQs"
    When I enter all mandatory fields for "add" FAQ
    And Click on "Save" button in "FAQ"
    #Then I should get "added successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQEdit
  Scenario: Edit FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Edit" button in "FAQs"
    Then "FAQ" "Edit" page gets open
    #And Verify test data with proper validation message for "FAQs"
    When I enter all mandatory fields for "edit" FAQ
    And Click on "Save" button in "FAQ"
    #Then I should get "updated successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQActiveInactive
  Scenario: FAQ Active Inactive
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And "FAQs" is "Active"
    Then Make "FAQs" "Inactive" and verify "success message"
    When Verify details in "FAQs"
    And "FAQs" is "Inactive"
    Then Make "FAQs" "Active" and verify "success message"
    Then Verify details in "FAQs"

  @FAQDelete
  Scenario: Delete FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Delete" button in "FAQs"
    Then I should get "Selected FAQ(s) have been deleted successfully." message on "FAQs"
    Then Verify details in "FAQs"

  @FAQAddSaveContinue
  Scenario: Create FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Click on "Add" button in "FAQs"
    Then "FAQ" "Add" page gets open
    When I enter all mandatory fields for "add" FAQ
    And Click on "Save and Continue" button in "FAQ"
    Then I should get "added successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQEditSaveContinue
  Scenario: FAQ Edit and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Edit" button in "FAQs"
    Then "FAQ" "Edit" page gets open
    When I enter all mandatory fields for "edit" FAQ
    And Click on "Save and Continue" button in "FAQ"
    Then I should get "updated successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQ
  Scenario: FAQ verification on Front side
    Given Open Front site and Go to "FAQ" Module
    Then Verify FAQ in front side

  @multipleteFAQAdd
  Scenario: Add multiple FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    When Click on "Add" button in "FAQs"
    Then "FAQ" "Add" page gets open
    When I enter all fields for "add" "FAQs"

  @multipleFAQDelete
  Scenario: Delete multiple FAQ and verify details
    Given Login as Admin and Go to "FAQs" Module
    And Select all record and Click on "Delete" button in "FAQs"
    Then I should get "Selected FAQ(s) have been deleted successfully." message on "FAQs"

  @FAQPagination
  Scenario: FAQ Pagination record verification
    Given Login as Admin and Go to "Settings" Module
    And value get in Settings Module
    And Verify Pagination count in "FAQs"

  @FAQsorting
  Scenario: Events Sorting record verification
    Given Login as Admin and Go to "FAQs" Module
    And Verify Sorting record in "FAQs"
