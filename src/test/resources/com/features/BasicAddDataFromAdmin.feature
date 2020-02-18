Feature: Sanity test functionalities of Laravel CMS
  As a admin user add, update, delete, search, verify details the below sanity functioanlities

  @userAdd
  Scenario: Create User and verify details
    Given Login as Admin and Go to "Users" Module
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    #And Verify test data with proper validation message for Users
    When I enter all mandatory fields for "add" User
    And Click on "Save" button in "Users"
    Then I should get "account created successfully" message on "Users"
    Then Verify details in "Users"

  @userEdit
  Scenario: Edit User and verify details
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "User" "Edit" page gets open
    When I enter all mandatory fields for "edit" User
    And Click on "Save" button in "Users"
    Then I should get "account updated successfully" message on "Users"
    Then Verify details in "Users"

  @userStatus
  Scenario: User Try Active before account verification
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And "User" is Inactive
    Then Make "User" "Active" and verify "error message"

  @userDelete
  Scenario: User Delete successfully
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Delete" button in "Users"
    Then I should get "acccount has been deleted successfully" message on "Users"
    Then Verify details in "Users"

  @useraddSaveandContinue
  Scenario: User Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Users" Module
    When Click on "Add" button in "Users"
    Then "User" "Add" page gets open
    When I enter all mandatory fields for "add" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account created successfully" message on "Users"
    Then Verify details in "Users"

  @userEditSaveandContinue
  Scenario: User Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Users" Module
    When Verify details in "Users"
    And Click on "Edit" button in "Users"
    Then "Users" "Edit" page gets open
    When I enter all mandatory fields for "edit" User
    And Click on "Save and Continue" button in "Users"
    Then I should get "account updated successfully" message on "Users"
    Then Verify details in "Users"

  @ourteamAdd
  Scenario: Our Team Member Add successfully with click on Save button
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "Our Team" "Add" page gets open
    #And	 Verify test data with proper validation message for "Our Team"
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamEdit
  Scenario: Edit Our Team Member and verify details
    Given Login as Admin and Go to "Our Team" Module
    And Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamStatus
  Scenario: Our Team Member Try InActive account
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And "Our Team" is "Active"
    Then Make "Our Team" "Inactive" and verify "success message"
    When Verify details in "Our Team"
    And "Our Team" is "Inactive"
    Then Make "Our Team" "Active" and verify "success message"

  @ourteamDelete
  Scenario: Our Team Member Delete successfully
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Delete" button in "Our Team"
    Then I should get "Selected team member(s) have been deleted successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamSaveandContinue
  Scenario: Our Team Member Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Our Team" Module
    When Click on "Add" button in "Our Team"
    Then "User" "Add" page gets open
    When I enter all mandatory fields for "add" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member added successfully" message on "Our Team"
    Then Verify details in "Our Team"

  @ourteamSaveandContinue
  Scenario: Our Team Member Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Our Team" Module
    When Verify details in "Our Team"
    And Click on "Edit" button in "Our Team"
    Then "Our Team" "Edit" page gets open
    When I enter all mandatory fields for "edit" Our Team
    And Click on "Save and Continue" button in "Our Team"
    Then I should get "member updated successfully" message on "Our Team"
    Then Verify details in "Our Team"

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

  @blogStatus
  Scenario: Blogs Try Active before account verification
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And "Blogs" is "Active"
    Then Make "Blogs" "Inactive" and verify "success message"
    When Verify details in "Blogs"
    And "Blogs" is "Inactive"
    Then Make "Blogs" "Active" and verify "success message"

  @blogDelete
  Scenario: Blogs Delete successfully
    Given Login as Admin and Go to "Blogs" Module
    When Verify details in "Blogs"
    And Click on "Delete" button in "Blogs"
    Then I should get "Selected blog(s) have been deleted successfully." message on "Blogs"
    Then Verify details in "Blogs"

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

  #@BlogFrontVerification
  #Scenario: Blog verification on Front side
  #Given	Login as Admin and Go to "Blogs" Module
  #When	Get Blog name from Admin panel
  #Then	Verify Blog name in front side
  @TestimonialAdd
  Scenario: Testimonial Add successfully with click on Save button
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    #And Verify test data with proper validation message for "Testimonials"
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEdit
  Scenario: Testimonial Edit successfully with click on Save button
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
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

  @TestimonialDelete
  Scenario: Testimonial Delete successfully
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Delete" button in "Testimonial"
    Then I should get "Selected testimonial(s) have been deleted successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialAddSaveContinue
  Scenario: Testimonial Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Add" button in "Testimonial"
    Then "Testimonial" "Add" page gets open
    When I enter all mandatory fields for "add" Testimonial
    And Click on "Save and Continue" button in "Testimonial"
    Then I should get "testimonial added successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialEditSaveContinue
  Scenario: Testimonial Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Testimonials" Module
    When Verify details in "Testimonial"
    And Click on "Edit" button in "Testimonial"
    Then "Testimonial" "Edit" page gets open
    When I enter all mandatory fields for "edit" Testimonial
    And Click on "Save and Continue" button in "Testimonial"
    Then I should get "testimonial updated successfully" message on "Testimonial"
    Then Verify details in "Testimonial"

  @TestimonialSettings
  Scenario: Testimonial Settings field
    Given Login as Admin and Go to "Testimonials" Module
    When Click on "Testimonial" Settings menu
    Then "Testimonial" "Settings" page gets open
    When I enter all mandatory fields for "Testimonial" Settings
    And Click on "Save" button in "Testimonial" Settings
    Then I should get "Settings have been saved successfully" message on "Testimonial" Settings

  #@TestimonialFrontVerification
  #Scenario: Testimonial verification on Front side
  #Given Login as Admin and Go to "Testimonials" Module
  #When Get Testimonial from Admin panel
  #Then Verify Testimonial in front side
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

  @FAQAdd
  Scenario: FAQ Add successfully with click on Save button
    Given Login as Admin and Go to "FAQs" Module
    When Click on "Add" button in "FAQs"
    Then "FAQ" "Add" page gets open
    #And Verify test data with proper validation message for "FAQs"
    When I enter all mandatory fields for "add" FAQ
    And Click on "Save" button in "FAQ"
    Then I should get "added successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQEdit
  Scenario: FAQ Edit successfully with click on Save button
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Edit" button in "FAQs"
    Then "FAQ" "Edit" page gets open
    When I enter all mandatory fields for "edit" FAQ
    And Click on "Save" button in "FAQ"
    Then I should get "updated successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQActiveInactive
  Scenario: FAQ Active - Inactive
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And "FAQs" is "Active"
    Then Make "FAQs" "Inactive" and verify "success message"
    When Verify details in "FAQs"
    And "FAQs" is "Inactive"
    Then Make "FAQs" "Active" and verify "success message"
    Then Verify details in "FAQs"

  @FAQDelete
  Scenario: FAQ Delete successfully
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Delete" button in "FAQs"
    Then I should get "Selected FAQ(s) have been deleted successfully." message on "FAQs"
    Then Verify details in "FAQs"

  @FAQAddSaveContinue
  Scenario: FAQ Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "FAQs" Module
    When Click on "Add" button in "FAQs"
    Then "FAQ" "Add" page gets open
    When I enter all mandatory fields for "add" FAQ
    And Click on "Save and Continue" button in "FAQ"
    Then I should get "added successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @FAQEditSaveContinue
  Scenario: FAQ Edit successfully with click on Save & Contnue button
    Given Login as Admin and Go to "FAQs" Module
    When Verify details in "FAQs"
    And Click on "Edit" button in "FAQs"
    Then "FAQ" "Edit" page gets open
    When I enter all mandatory fields for "edit" FAQ
    And Click on "Save and Continue" button in "FAQ"
    Then I should get "updated successfully." message on "FAQ"
    Then Verify details in "FAQs"

  @EventsAdd
  Scenario: Event Add successfully with click on Save button
    Given Login as Admin and Go to "Events" Module
    When Click on "Add" button in "Events"
    Then "Event" "Add" page gets open
    #And Verify test data with proper validation message for "Events"
    When I enter all mandatory fields for "add" Event
    And Click on "Save" button in "Event"
    Then I should get "event added successfully." message on "Events"
    Then Verify details in "Events"

  @EventsEdit
  Scenario: Category Edit successfully with click on Save button
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Edit" button in "Events"
    Then "Event" "Edit" page gets open
    When I enter all mandatory fields for "edit" Event
    And Click on "Save" button in "Event"
    Then I should get "event updated successfully." message on "Events"
    Then Verify details in "Events"

  @EventsActiveInactive
  Scenario: Event Active Inactive
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And "Events" is "Active"
    Then Make "Events" "Inactive" and verify "success message"
    #Then Verify details in "Events grid with other filters"
    When Verify details in "Events"
    And "Events" is "Inactive"
    Then Make "Events" "Active" and verify "success message"
    Then Verify details in "Events"

  @EventsDelete
  Scenario: Event Delete successfully
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Delete" button in "Events"
    Then I should get "Selected event(s) have been deleted successfully." message on "Events"
    Then Verify details in "Events"

  @EventsAddSaveContinue
  Scenario: Event Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Events" Module
    When Click on "Add" button in "Events"
    Then "Event" "Add" page gets open
    When I enter all mandatory fields for "add" Event
    And Click on "Save and Continue" button in "Event"
    Then I should get "event added successfully." message on "Events"
    Then Verify details in "Events"

  @EventsEditSaveContinue
  Scenario: Event Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Events" Module
    When Verify details in "Events"
    And Click on "Edit" button in "Events"
    Then "Event" "Edit" page gets open
    When I enter all mandatory fields for "edit" Event
    And Click on "Save and Continue" button in "Event"
    Then I should get "event updated successfully." message on "Event"
    Then Verify details in "Events"

  @PagesAdd
  Scenario: Page Add successfully with click on Save button
    Given Login as Admin and Go to "Pages" Module
    When Click on "Add" button in "Pages"
    Then "Page" "Add" page gets open
    #And Verify test data with proper validation message for "Pages"
    When I enter all mandatory fields for "add" Page
    And Click on "Save" button in "Page"
    Then I should get "page created successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesEdit
  Scenario: Page Edit successfully with click on Save button
    Given Login as Admin and Go to "Pages" Module
    When Verify details in "Pages"
    And Click on "Edit" button in "Pages"
    Then "Page" "Edit" page gets open
    When I enter all mandatory fields for "edit" Page
    And Click on "Save" button in "Page"
    Then I should get "page updated successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesActiveInactive
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
  Scenario: Page Add successfully with click on Save & Continue button
    Given Login as Admin and Go to "Pages" Module
    When Click on "Add" button in "Pages"
    Then "Page" "Add" page gets open
    When I enter all mandatory fields for "add" Page
    And Click on "Save and Continue" button in "Page"
    Then I should get "page created successfully." message on "Pages"
    Then Verify details in "Pages"

  @PagesEditSaveContinue
  Scenario: Page Edit successfully with click on Save & Continue button
    Given Login as Admin and Go to "Pages" Module
    When Verify details in "Pages"
    And Click on "Edit" button in "Pages"
    Then "Page" "Edit" page gets open
    When I enter all mandatory fields for "edit" Page
    And Click on "Save and Continue" button in "Page"
    Then I should get "page updated successfully." message on "Pages"
    Then Verify details in "Pages"

  #@PagesFrontVerification
  #Scenario: Page verification on Front side
  #Given	Login as Admin and Go to "Pages" Module
  #When	Get Page name from Admin panel
  #Then	Verify Page name in front side
  @Settings
  Scenario: Update Settings details
    Given Login as Admin and Go to "Settings" Module
    When Data update and verify details for Admin Settings section
    #Then Test case pass for Admin Settings section


  @Settings
  Scenario: Other validations except Required Settings
    Given	Login as Admin and Go to "Settings" Module
    When	Company Detail__Check zip code and email field validations and verify error message
    When	Email Settings__Check from email field validations and verify error message
    When	Social Networking Links__Check URL field enter invalid URL and verify error message
    When	Password Settings__Check No of attempt to block user while login field and User Block Time field to enter invalid value and verify error message
    When	Password Settings__Check Minimum Password Length field and invalid value and verify error message

