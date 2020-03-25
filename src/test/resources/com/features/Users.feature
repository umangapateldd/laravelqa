Feature: Users module scenario

  @userAdd
  Scenario: Create user and verify details
    Given Login as Admin and Go to "Users" Module
    #When Verify table column in each grid "Users" page
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    #And Verify test data with proper validation message for "Users"
    When I enter all mandatory fields for "add" User
    And Click on "Save" button in "Users"
    Then I should get "account created successfully." message on "Users"
    Then Verify details in "Users"

  @userEdit
  Scenario: Edit user and verify details
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "User" "Edit" page gets open
    And Verify test data with proper validation message for "Users"
    When I enter all mandatory fields for "edit" User
    And Click on "Save" button in "Users"
    Then I should get "account updated successfully." message on "Users"
    Then Verify details in "Users"

  @userStatus
  Scenario: User Active Inactive
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And "User" is Inactive
    Then Make "User" "Active" and verify "error message"

  @useraddSaveandContinue
  Scenario: Create user and verify details
    Given Login as Admin and Go to "Users" Module
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    When I enter all mandatory fields for "add" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account created successfully." message on "Users"
    Then Verify details in "Users"

  @userEditSaveandContinue
  Scenario: Edit user and verify details
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "User" "Edit" page gets open
    When I enter all mandatory fields for "edit" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account updated successfully." message on "Users"
    Then Verify details in "Users"

  @userDelete
  Scenario: Delete user and verify details
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Delete" button in "Users"
    Then I should get "acccount has been deleted successfully." message on "Users"
    Then Verify details in "Users"

  @userLogin
  Scenario: Delete user and verify details
    Given Login as Admin and Go to "Users" Module
    #When Verify details in "Users"
    Then Verify checkbox for login user "Users" Module

  @multipleuserAdd
  Scenario: Add multiple user and verify details
    Given Login as Admin and Go to "Users" Module
    #When Verify table column in each grid "Users" page
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    #And Verify test data with proper validation message for "Users"
    When I enter all fields for "add" "Users"
    #And Click on "Save" button in "Users"
    #Then I should get "account created successfully." message on "Users"
    #Then Verify details in "Users"
