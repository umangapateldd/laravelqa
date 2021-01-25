Feature: Blog module scenario

  @blogAdd
  Scenario: Create blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    #When Verify table column in each grid "Blogs" page
    When Click on "Add" button in "Blogs"
    Then "Blog" "Add" page gets open
    #And Verify test data with proper validation message for "Blogs"
    When I enter all mandatory fields for "add" Blogs
    And Click on "Save" button in "Blogs"
    Then I should get "blog added successfully." message on "Blogs"
    Then Verify details in "Blogs"

  @blogEdit
  Scenario: Edit Blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    And Verify details in "Blogs"
    And Click on "Edit" button in "Blogs"
    Then "Blog" "Edit" page gets open
    And Verify test data with proper validation message for "Blogs"
    When I enter all mandatory fields for "edit" Blogs
    And Click on "Save" button in "Blogs"
    Then I should get "blog updated successfully." message on "Blogs"
    Then Verify details in "Blogs"

  @blogStatus
  Scenario: Blogs Active Inactive
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And "Blogs" is "Active"
    Then Make "Blogs" "Inactive" and verify "success message"
    When Verify details in "Blogs"
    And "Blogs" is "Inactive"
    Then Make "Blogs" "Active" and verify "success message"

  @blogAddSaveandContinue
  Scenario: Create blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blog" "Add" page gets open
    When I enter all mandatory fields for "add" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "blog added successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogEditSaveandContinue
  Scenario: Edit blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Edit" button in "Blogs"
    Then "Blog" "Edit" page gets open
    When I enter all mandatory fields for "edit" Blogs
    And Click on "Save and Continue" button in "Blogs"
    Then I should get "blog updated successfully" message on "Blogs"
    Then Verify details in "Blogs"

  @blogSettings
  Scenario: Blogs Settings
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Blogs" Settings menu
    Then "Blogs" "Settings" page gets open
    When I enter all mandatory fields for "Blogs" Settings
    And Click on "Save" button in "Blogs" Settings
    Then I should get "Settings have been saved successfully." message on "Blogs" Settings
    When Go to "Blogs" Module
    And Verify record per page on blog listing page
    

  @blogDelete
  Scenario: Delete blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Delete" button in "Blogs"
    Then I should get "Selected blog(s) have been deleted successfully." message on "Blogs"
    Then Verify details in "Blogs"

  @blogFront
  Scenario: Blog verification on front side
    Given Open Front site and Go to "BLOG" Module
    Then Verify Blog in front side

  @multipleblogAdd
  Scenario: Add multiple blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    When Click on "Add" button in "Blogs"
    Then "Blog" "Add" page gets open
    When I enter all fields for "add" "Blogs"

  @multipleblogDelete
  Scenario: Delete multiple Blog and verify details
    Given Login as Admin and Go to "Blogs" Module
    And Select all record and Click on "Delete" button in "Blogs"
    Then I should get "Selected blog(s) have been deleted successfully." message on "Blogs"

  @blogPagination
  Scenario: Blog Pagination record verification
    Given Login as Admin and Go to "Settings" Module
    And value get in Settings Module
    And Verify Pagination count in "Blogs"

  @blogsorting
  Scenario: Blog Sorting record verification
    Given Login as Admin and Go to "Blogs" Module
    And Verify Sorting record in "Blogs"
