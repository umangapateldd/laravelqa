Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @userAdd
  Scenario: Create User and verify details
    Given Login as Admin and Go to "Users" Module
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    #And Verify test data with proper validation message for Users
    When I enter all mandatory fields for "add" User
    And Click on "Save" button in "Users"
    Then I should get "account created successfully" message on "Users"
    Then Verify details in "Users"

  @userEdit
  Scenario: Edit User and verify details
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "User" "Edit" page gets open
    When I enter all mandatory fields for "edit" User
    And Click on "Save" button in "Users"
    Then I should get "account updated successfully" message on "Users"
    Then Verify details in "Users"

  @userStatus
  Scenario: User Try Active before account verification
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And "User" is Inactive
    Then Make "User" "Active" and verify "error message"

  @userDelete
  Scenario: User Delete successfully
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Delete" button in "Users"
    Then I should get "acccount has been deleted successfully" message on "Users"
    Then Verify details in "Users"

  @useraddSaveandContinue
  Scenario: User Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Users" Module
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    When I enter all mandatory fields for "add" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account created successfully" message on "Users"
    Then Verify details in "Users"

  @userEditSaveandContinue
  Scenario: User Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "Users" "Edit" page gets open
    When I enter all mandatory fields for "edit" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account updated successfully" message on "Users"
    Then Verify details in "Users"

  @ourteam
  Scenario: Our Team Member Add successfully with click on Save button
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "Our Team" "Add" page gets open
    #And	 Verify test data with proper validation message for "Our Team"
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"
    
   @ourteamEdit
  Scenario: Edit User and verify details
    Given Login as Admin and Go to "Our Team" Module
    And Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then  "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteam
  Scenario: User Try Active before account verification
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And "Our Team" is "Active"
    Then Make "Our Team" "Inactive" and verify "success message"
    When Verify details in "Our Team"
    And "Our Team" is "Inactive"
    Then Make "Our Team" "Active" and verify "success message"

  @ourteamDelete
  Scenario: User Delete successfully
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Delete" button in "Our Team"
    Then I should get "Selected team member(s) have been deleted successfully" message on "Our Team"
    Then Verify details in "Our Team"
#
  #@ourteamaddSaveandContinue
  #Scenario: User Add successfully with click on Save & Continue button
    #Given Login as Admin and Go to "Our Team" Module
    #When Click on "Add" button in "Our Team"
    #Then "User" "Add" page gets open
    #When I enter all mandatory fields for "add" Our Team
    #And Click on "Save and Continue" button in "Our Team"
    #Then I should get "account created successfully" message on "Our Team"
    #Then Verify details in "Our Team"

  @ourteamEditSaveandContinue
  Scenario: User Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then  "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"
    

