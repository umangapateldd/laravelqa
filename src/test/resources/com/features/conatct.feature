Feature: Conatct inquiries module scenario

  @conatctinquiries
  Scenario: Conatct Inquiries verify data
    Given Login as Admin and Go to "Contact Us" Module
    When Verify data in Contact Us

  #And Verify Sorting record in "Contact Us"
  @contactSettings
  Scenario: Conatct Inquiries setting verify data
    Given Login as Admin and Go to "Contact Us" Module
    When Click on "Contact Us" Settings menu
    And Verify admintest data for contactUs setting
    Then Verify the front site
