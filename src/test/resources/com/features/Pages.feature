Feature: Pages module scenario

  @PagesAdd
  Scenario: Create Page and verify details
    Given Login as Admin and Go to "Pages" Module
    When Verify table column in each grid "Pages" page
    When Click on "Add" button in "Pages"
    Then "Page" "Add" page gets open
    And Verify test data with proper validation message for "Pages"
    When I enter all mandatory fields for "add" Page
    And Click on "Save" button in "Page"
    Then I should get "page created successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesEdit
  Scenario: Edit Page and verify details
    Given Login as Admin and Go to "Pages" Module
    When Verify details in "Pages"
    And Click on "Edit" button in "Pages"
    Then "Page" "Edit" page gets open
    When I enter all mandatory fields for "edit" Page
    And Click on "Save" button in "Page"
    Then I should get "page updated successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesStatus
  Scenario: Page Active Inactive
    Given Login as Admin and Go to "Pages" Module
    When Verify details in "Pages"
    And "Pages" is "Active"
    Then Make "Pages" "Inactive" and verify "success message"
    #Then Verify details in "Pages grid with other filters"
    When Verify details in "Pages"
    And "Pages" is "Inactive"
    Then Make "Pages" "Active" and verify "success message"
    Then Verify details in "Pages"

  @PagesAddSaveContinue
  Scenario: Create Page and verify details
    Given Login as Admin and Go to "Pages" Module
    When Click on "Add" button in "Pages"
    Then "Page" "Add" page gets open
    When I enter all mandatory fields for "add" Page
    And Click on "Save and Continue" button in "Page"
    Then I should get "page created successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesEditSaveContinue
  Scenario: Edit Page and verify details
    Given Login as Admin and Go to "Pages" Module
    When Verify details in "Pages"
    And Click on "Edit" button in "Pages"
    Then "Page" "Edit" page gets open
    When I enter all mandatory fields for "edit" Page
    And Click on "Save and Continue" button in "Page"
    Then I should get "page updated successfully." message on "Pages"
    Then Verify details in "Pages"

  @Pages1
  Scenario: Page verification on Front side
   Given Login as Admin and Go to "Pages" Module
   When Verify details in Pages with other filters
   Then Get list of pages title
   And Open Front site and Go to "PAGES" Module
   Then Open front side and compare pages title with admin list
   
   @multiplepageAdd
  Scenario: Add multiple page and verify details
    Given Login as Admin and Go to "Pages" Module
    When Click on "Add" button in "Pages"
    Then "Page" "Add" page gets open
    When I enter all fields for "add" "Pages"
    #And Click on "Save" button in "Users"
    #Then I should get "account created successfully." message on "Users"
    #Then Verify details in "Users"
   
