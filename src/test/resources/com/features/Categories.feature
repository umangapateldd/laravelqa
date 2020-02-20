Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @CategoriesAdd
  Scenario: Category Add successfully with click on Save button
    Given Login as Admin and Go to "Categories" Module
    When Click on "Add" button in "Categories"
    Then "Category" "Add" page gets open
    #And Verify test data with proper validation message for "Categories"
    When I enter all mandatory fields for "add" Category
    And Click on "Save" button in "Category"
    Then I should get "category added successfully" message on "Category"
    Then Verify details in "Categories"

  @CategoriesEdit
  Scenario: Category Edit successfully with click on Save button
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Edit" button in "Categories"
    Then "Category" "Edit" page gets open
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
  Scenario: Category Delete successfully
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Delete" button in "Categories"
    Then I should get "Selected category(s) have been deleted successfully." message on "Categories"
    Then Verify details in "Categories"

  @CategoriesAddSaveContinue
  Scenario: Category Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Categories" Module
    When Click on "Add" button in "Categories"
    Then "Category" "Add" page gets open
    When I enter all mandatory fields for "add" Category
    And Click on "Save and Continue" button in "Category"
    Then I should get "category added successfully" message on "Category"
    Then Verify details in "Categories"

  @CategoriesEditSaveContinue
  Scenario: Category Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Categories" Module
    When Verify details in "Categories"
    And Click on "Edit" button in "Categories"
    Then "Category" "Edit" page gets open
    When I enter all mandatory fields for "edit" Category
    And Click on "Save and Continue" button in "Category"
    Then I should get "category updated successfully" message on "Category"
    Then Verify details in "Categories"