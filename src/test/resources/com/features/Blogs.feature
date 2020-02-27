Feature: Blogs module scenarios 

  @blogAdd
  Scenario: Blog Add successfully with click on Save button
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blog" "Add" page gets open
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
    Then I should get "blog updated successfully" message on "Blogs"
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

  @blogAddSaveandContinue
  Scenario: Blogs Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blog" "Add" page gets open
    When I enter all mandatory fields for "add" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "blog added successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogEditSaveandContinue
  Scenario: Blogs Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Edit" button in "Blogs"
    Then "Blog" "Edit" page gets open
    When I enter all mandatory fields for "edit" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "blog updated successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogSettings
  Scenario: Blogs Settings field
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Blogs" Settings menu
    Then "Blogs" "Settings" page gets open
    When I enter all mandatory fields for "Blogs" Settings
    And Click on "Save" button in "Blogs" Settings
    Then I should get "Settings have been saved successfully" message on "Blogs" Settings

  @blogDelete
  Scenario: Blogs Delete successfully
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Delete" button in "Blogs"
    Then I should get "Selected blog(s) have been deleted successfully." message on "Blogs"
    Then Verify details in "Blogs"

  @blogFront
  Scenario: Blog verification on Front side
    Given Open Front site and Go to "BLOG" Module
    Then Verify Blog in front side
