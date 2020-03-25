Feature: Our Team module scenario

  @ourteam
  Scenario: Create Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    When Verify table column in each grid "Our Team" page
    When Click on "Add" button in "Our Team"
    Then "Team Member" "Add" page gets open
    And Verify test data with proper validation message for "Our Team"
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamEdit
  Scenario: Edit Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    And Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Team Member" "Edit" page gets open
    And Verify test data with proper validation message for "Our Team"
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamStatus
  Scenario: Our Team Active InActive 
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And "Our Team" is "Active"
    Then Make "Our Team" "Inactive" and verify "success message"
    When Verify details in "Our Team"
    And "Our Team" is "Inactive"
    Then Make "Our Team" "Active" and verify "success message"

  @ourteamDelete
  Scenario: Delete Our Team and verify details
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Delete" button in "Our Team"
    Then I should get "Selected team member(s) have been deleted successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamAddSaveandContinue
  Scenario: Create Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "Team Member" "Add" page gets open
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamEditSaveandContinue
  Scenario: Edit Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Team Member" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"
    
  @ourteamFront
  Scenario: Our team verification on Front side
    Given Open Front site and Go to "TEAM" Module
    Then Verify Our team in front side
    
    
 @multiplepageAdd
  Scenario: Add multiple page and verify details
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "Team Member" "Add" page gets open
    When I enter all fields for "add" "Our Team"