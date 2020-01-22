Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @SanityUser1111
  Scenario: Create User and verify details
    Given user on admin Dashboard page
    When user navigate to "Users" page
    And admin user add new User
      | firstName | vivek             |
      | lastName  | bhatt             |
      | email     | vivek@yopmail.com |
    Then verify the "Users" details "after created"

  @SanityUser
  Scenario: Edit User and verify details
    Given user on admin Dashboard page
    When user navigate to "Users" page
    Then verify the "Users" details "for update"
    And admin user update User
      | updatefirstName | xyz               |
      | updatelastName  | pqwe              |
      | email           | vivek@yopmail.com |
    Then verify the "Users" details "after update"

  @SanityUser
  Scenario: Delete User and verify details
    Given user on admin Dashboard page
    When user navigate to "Users" page
    Then verify the "Users" details "for delete"
    And admin user update User
      | updatefirstName | xyz               |
      | updatelastName  | pqwe              |
      | email           | vivek@yopmail.com |
    Then verify the "Users" details "after delete"
