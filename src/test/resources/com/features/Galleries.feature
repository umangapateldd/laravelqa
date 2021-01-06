Feature: Galleries module scenario

  @GalleriesAdd
  Scenario: Create Galleries and verify details
    Given Login as Admin and Go to "Galleries" Module
    When Click on "Add" button in "Galleries"
    Then "Gallery" "Add" page gets open
    When I enter all mandatory fields for "add" Galleries
    And Click on "Save" button in "Galleries"
    Then I should get "Gallery added successfully." message on "Galleries"
    Then Verify details in "Galleries"

  @GalleriesEdit
  Scenario: Edit Galleries and verify details
    Given Login as Admin and Go to "Galleries" Module
    And Verify details in "Galleries"
    And Click on "Edit" button in "Galleries"
    Then "Gallery" "Edit" page gets open
    When I enter all mandatory fields for "edit" Galleries
    And Click on "Save" button in "Galleries"
    Then I should get "Gallery updated successfully." message on "Galleries"
    Then Verify details in "Galleries"

  @GalleriesDelete
  Scenario: Delete Galleries and verify details
    Given Login as Admin and Go to "Galleries" Module
    When Verify details in "Galleries"
    And Click on Delete button in Galleries
    Then I should get "Gallery deleted successfully." message on "Galleries"

  @GalleriesStatus
  Scenario: Galleries Active Inactive
    Given Login as Admin and Go to "Galleries" Module
    Then Make Galleries status and verify "success message"
