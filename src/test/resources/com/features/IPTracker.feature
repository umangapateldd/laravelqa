Feature: IPTracker module scenario

  @Iptracker
  Scenario: Search data and verify details
    Given Login as Admin and Go to "IP Tracker" Module
    When Verify table column in each grid "IP Tracker" page
    Then Verify details in "IP Tracker"

  @Iptrackersorting
  Scenario: Page Sorting record verification
    Given Login as Admin and Go to "IP Tracker" Module
    And Verify Sorting record in "IP Tracker"
