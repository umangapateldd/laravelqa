Feature: Admin User Profile Scenarios

  @myProfile
  Scenario: Change My Profile details and verify in users module
    Given Login as Admin and Go to "My Profile" Module
    When Change First Name and Last Name
    And Verify in "Users" Module

  @changePassword
  Scenario: Change Password and verify login with new password
    Given Login as Admin and Go to "Change Password" Module
    When Set new password
    Then Login with new password and verify logged in profile details
