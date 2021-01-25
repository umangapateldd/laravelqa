Feature: Category module scenario

  @CategoriesAdd
  Scenario: Create Category and verify details
    Given Login as Admin and Go to "Categories" Module
    When Verify table column in each grid "Categories" page
    When Click on "Add" button in "Categories"
    Then "Category" "Add" page gets open
    #And Verify test data with proper validation message for "Categories"
    When I enter all mandatory fields for "add" Category
    And Click on "Save" button in "Category"
    Then I should get "category added successfully" message on "Category"
    Then Verify details in "Categories"

  @CategoriesEdit
  Scenario: Edit Category and verify details
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Edit" button in "Categories"
    Then "Category" "Edit" page gets open
    #And Verify test data with proper validation message for "Categories"
    When I enter all mandatory fields for "edit" Category
    And Click on "Save" button in "Category"
    Then I should get "category updated successfully" message on "Category"
    Then Verify details in "Categories"

  @CategoriesActiveInactive
  Scenario: Category Active Inactive
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And "Categories" is "Active"
    Then Make "Categories" "Inactive" and verify "success message"
    #Then Verify details in "Categories grid with other filters"
    When Verify details in "Categories"
    And "Categories" is "Inactive"
    Then Make "Categories" "Active" and verify "success message"

  #Then Verify details in "Categories grid with other filters"
  @CategoriesDelete
  Scenario: Delete Category and verify details
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Delete" button in "Categories"
    Then I should get "Selected category(s) have been deleted successfully." message on "Categories"
    Then Verify details in "Categories"

  @CategoriesAddSaveContinue
  Scenario: Create Category and verify details
    Given Login as Admin and Go to "Categories" Module
    When Click on "Add" button in "Categories"
    Then "Category" "Add" page gets open
    When I enter all mandatory fields for "add" Category
    And Click on "Save and Continue" button in "Category"
    Then I should get "category added successfully" message on "Category"
    Then Verify details in "Categories"

  @CategoriesEditSaveContinue
  Scenario: Edit Category and verify details
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Edit" button in "Categories"
    Then "Category" "Edit" page gets open
    When I enter all mandatory fields for "edit" Category
    And Click on "Save and Continue" button in "Category"
    Then I should get "category updated successfully" message on "Category"
    Then Verify details in "Categories"

  @multiplecategoriesAdd
  Scenario: Add multiple page and verify details
    Given Login as Admin and Go to "Categories" Module
    When Click on "Add" button in "Categories"
    Then "Category" "Add" page gets open
    When I enter all fields for "add" "Categories"

  @multiplecategoriesDelete
  Scenario: Delete multiple Blog and verify details
    Given Login as Admin and Go to "Categories" Module
    And Select all record and Click on "Delete" button in "Categories"
    Then I should get "Selected category(s) have been deleted successfully." message on "Categories"

  @categoriesPagination
  Scenario: Categories Pagination record verification
    Given Login as Admin and Go to "Settings" Module
    And value get in Settings Module
    And Verify Pagination count in "Categories"

  @categoriessorting
  Scenario: Blog Sorting record verification
    Given Login as Admin and Go to "Categories" Module
    And Verify Sorting record in "Categories"
