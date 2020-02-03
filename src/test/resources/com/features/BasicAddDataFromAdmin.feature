Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @userAdd
  Scenario: Create User and verify details
    Given Login as Admin and Go to Users Module
    When Click on Add button in Users grid
    Then Users Add page gets open
    And Verify test data with proper validation message for Users
    When I enter all mandatory fields for add User
    And Click on Save button in Users
    Then I should get account created successfully message on Users list page
    Then Verify details in Users grid

  @userEdit
  Scenario: Edit User and verify details
    Given Login as Admin and Go to Users Module
    When Verify details in Users grid
    And Click on Edit button in Users grid
    Then Users Edit page gets open
    When I enter all mandatory fields for update User
    And Click on Save button in Users
    Then I should get account updated successfully message on Users list page
    Then Verify details in Users grid

  @userstatus
  Scenario: User Try Active before account verification
    Given Login as Admin and Go to Users Module
    When Verify details in Users grid
    And User is Inactive
    Then Make User Active and verify error message

#
  #@SanityUser
  #Scenario: Delete User and verify details
    #Given user on admin Dashboard page
    #When user navigate to "Users" page
    #Then verify the "Users" details "for delete"
    #Then verify the "Users" details "after delete"
