Feature: Homeslider module scenario

  @HomesliderSettings
  Scenario: Homeslider Settings verify data
    Given Login as Admin and Go to "Home Page Sliders" Module
    When Click on "Home Page Sliders" Settings menu
    And I enter all mandatory fields for Homeslider setting
    Then Verify the front site

  @HomesliderAdd
  Scenario: Create Homeslider and verify details
    Given Login as Admin and Go to "Home Page Sliders" Module
    When Click on "Add" button in "Home Page Sliders"
    When I enter all mandatory fields for "add" Homeslider
    Then I should get "Slider(s) added successfully." message on "Home Page Sliders"
    Then Verify details in "Home Page Sliders"

  @HomesliderEdit
  Scenario: Edit Homeslider and verify details
    Given Login as Admin and Go to "Home Page Sliders" Module
    And Verify details in "Home Page Sliders"
    And Click on "Edit" button in "Home Page Sliders"
    Then "Slider" "Edit" page gets open
    When I enter all mandatory fields for "edit" Homeslider
    And Click on "Save" button in "Home Page Sliders"
    Then I should get "Slider(s) updated successfully." message on "Home Page Sliders"
    Then Verify details in "Home Page Sliders"

  @HomesliderDelete
  Scenario: Delete blog and verify details
    Given Login as Admin and Go to "Home Page Sliders" Module
    When Verify details in "Home Page Sliders"
    And Click on Delete button in Home Page Sliders
    Then I should get "Slider deleted successfully." message on "Home Page Sliders"

  @HomesliderStatus
  Scenario: Homeslider Active Inactive
    Given Login as Admin and Go to "Home Page Sliders" Module
    Then Make Home Page Sliders status and verify "success message"
