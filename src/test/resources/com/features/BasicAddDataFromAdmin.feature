Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @SanityUser
  Scenario: Create User and verify details
    Given Login as Admin and Go to Users Module
    When Click on Add button in Users grid
    #Then Users "Add" page gets open
    #And Verify test data with proper validation message for Users
    #When I enter all mandatory fields for "add User"
    #And Click on "Save" button in Users
    #Then I should get "account created successfully" message on Users list page
    #Then Verify details in "Users grid"

  #@SanityUser
  #Scenario: Edit User and verify details
    #Given user on admin Dashboard page
    #When user navigate to "Users" page
    #Then verify the "Users" details "for update"
    #And admin user update User
      #| updatefirstName | TEST 29               |
      #| updatelastName  | qa29                  |
      #| email           | NEWuser00@yopmail.com |
    #Then verify the "Users" details "after update"
    #And verify the status detail
#
  #@SanityUser
  #Scenario: Delete User and verify details
    #Given user on admin Dashboard page
    #When user navigate to "Users" page
    #Then verify the "Users" details "for delete"
    #Then verify the "Users" details "after delete"
