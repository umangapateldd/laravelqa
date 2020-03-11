Feature: Settings module scenario

  @Settings
  Scenario: Update Settings details
    Given Login as Admin and Go to "Settings" Module
    #When Data update and verify details for Admin "Settings" section
    And Verify test data with proper validation message for "Settings"
  #@Settings
  #Scenario: Other validations except Required Settings
    #Given	Login as Admin and Go to "Settings" Module
    #When	Company Detail__Check zip code and email field validations and verify error message
    #When	Email Settings__Check from email field validations and verify error message
    #When	Social Networking Links__Check URL field enter invalid URL and verify error message
    #When	Password Settings__Check No of attempt to block user while login field and User Block Time field to enter
     #invalid value and verify error message
    #When	Password Settings__Check Minimum Password Length field and invalid value and verify error message
#
