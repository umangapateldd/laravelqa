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

  @ourteamAdd
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
  Scenario: Edit Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    And Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamStatus
  Scenario: Our Team Member Try InActive account
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And "Our Team" is "Active"
    Then Make "Our Team" "Inactive" and verify "success message"
    When Verify details in "Our Team"
    And "Our Team" is "Inactive"
    Then Make "Our Team" "Active" and verify "success message"

  @ourteamDelete
  Scenario: Our Team Member Delete successfully
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Delete" button in "Our Team"
    Then I should get "Selected team member(s) have been deleted successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamSaveandContinue
  Scenario: Our Team Member Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "User" "Add" page gets open
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamSaveandContinue
  Scenario: Our Team Member Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @blog
  Scenario: Blog Add successfully with click on Save button
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blogs" "Add" page gets open
    #And Verify test data with proper validation message for Users
    When I enter all mandatory fields for "add" Blogs
    And Click on "Save" button in "Blogs"
    Then I should get "blog added successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogEdit
  Scenario: Edit Blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    And Verify details in "Blogs"
    And Click on "Edit" button in "Blogs"
    Then "Blog" "Edit" page gets open
    When I enter all mandatory fields for "edit" Blogs
    And Click on "Save" button in "Blogs"
    Then I should get " blog updated successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blog
  Scenario: Blogs Try Active before account verification
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And "Blogs" is "Active"
    Then Make "Blogs" "Inactive" and verify "success message"
    When Verify details in "Blogs"
    And "Blogs" is "Inactive"
    Then Make "Blogs" "Active" and verify "success message"

  @blogDelete
  Scenario: Blogs Delete successfully
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Delete" button in "Blogs"
    Then I should get "Selected team member(s) have been deleted successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogSaveandContinue
  Scenario: Blogs Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blogs" "Add" page gets open
    When I enter all mandatory fields for "add" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "member added successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogSaveandContinue
  Scenario: Blogs Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Edit" button in "Blogs"
    Then "Blogs" "Edit" page gets open
    When I enter all mandatory fields for "edit" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "member updated successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @BlogSettings
  Scenario: Blogs Settings field
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Blogs Settings" menu
    Then  "Blogs" "Settings" page gets open
    When I enter all mandatory fields for "Blogs" Settings
    And Click on "Save" button in "Blogs Settings"
    Then I should get "Settings have been saved successfully" message on "Blogs" Settings 


  #@BlogFrontVerification
  #Scenario: Blog verification on Front side
    #Given	Login as Admin and Go to "Blogs" Module
    #When	Get Blog name from Admin panel
    #Then	Verify Blog name in front side


  @TestimonialAdd
  Scenario: Testimonial Add successfully with click on Save button
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    #And Verify test data with proper validation message for "Testimonials"
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEdit
  Scenario: Testimonial Edit successfully with click on Save button
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
    When I enter all mandatory fields for "update" Testimonial
    And Click on "Save" button in "Testimonial"
    Then I should get "testimonial updated successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialActiveInactive
  Scenario: Testimonial Active Inactive
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And "Testimonial" is "Active"
    Then Make "Testimonial" "Inactive" and verify "success message"
    #Then Verify details in "Testimonial grid with other filters"
    When Verify details in "Testimonial"
    And "Testimonial" is "Inactive"
    Then Make "Testimonial" "Active" and verify "success message"

  @TestimonialDelete
  Scenario: Testimonial Delete successfully
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Delete" button in "Testimonial"
    Then I should get "have been deleted successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialAddSaveContinue
  Scenario: Testimonial Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save & Continue" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEditSaveContinue
  Scenario: Testimonial Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
    When I enter all mandatory fields for "edit" Testimonial
    And Click on "Save & Continue" button in "Testimonial"
    Then I should get "testimonial updated successfully" message on "Testimonial"
    Then Verify details in "Testimonial"
  #@TestimonialFrontVerification
  #Scenario: Testimonial verification on Front side
    #Given Login as Admin and Go to "Testimonials" Module
    #When Get Testimonial from Admin panel
    #Then Verify Testimonial in front side
