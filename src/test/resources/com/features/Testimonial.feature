Feature: Testimonial module scenario

  @TestimonialAdd
  Scenario: Create Testimonial and verify details
    Given Login as Admin and Go to "Testimonials" Module
    When Verify table column in each grid "Testimonials" page
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    And Verify test data with proper validation message for "Testimonials"
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEdit
  Scenario: Edit Testimonial and verify details
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
    And Verify test data with proper validation message for "Testimonials"
    When I enter all mandatory fields for "edit" Testimonial
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

  @TestimonialAddSaveContinue
  Scenario: Create Testimonial and verify details
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save and Continue" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEditSaveContinue
  Scenario: Edit Testimonial and verify details
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
    When I enter all mandatory fields for "edit" Testimonial
    And Click on "Save and Continue" button in "Testimonial"
    Then I should get "testimonial updated successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialDelete
  Scenario: Testimonial Delete successfully
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Delete" button in "Testimonial"
    Then I should get "Selected testimonial(s) have been deleted successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

 @TestimonialDelete
  Scenario: Delete Testimonial and verify details
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Delete" button in "Testimonial"
    Then I should get "Selected testimonial(s) have been deleted successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialSettings
  Scenario: Testimonial Settings field
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Testimonial" Settings menu
    Then "Testimonial" "Settings" page gets open
    When I enter all mandatory fields for "Testimonial" Settings
    And Click on "Save" button in "Testimonial" Settings
    Then I should get "Settings have been saved successfully" message on "Testimonial" Settings

  @Testimonial1
  Scenario: Testimonial verification on Front side
    Given Open Front site and Go to "TESTIMONIAL" Module
    Then Verify Testimonial in front side
