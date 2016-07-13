@Feature_customerListFeature
Feature: Customer list table

@CustomerList @Search @High
Scenario Outline: Search
Given I`m on a homepage
When I enter in a text field called 'Enter search text' following text "<value>"
Then I see value "<value>" in "<column>" column
Examples:
| column            | value                             |
| Name              | Agility Logistics Co.             |
#   | Short             | SU                                |
#  | IATA CASS         | 4230415
# | Organisation Name | Expolanka International (Pvt) Ltd |

@CustomerList @Pagination_001 @High
Scenario: Pagination_001 next page
Given I`m on a homepage
When I save values from columns
And I press 'Next Page' button
Then I see value '2' in page text field
And columns values have changed

#@CustomerList @Pagination_002 @High
#Scenario: Pagination_002 last page
#  Given I`m on a homepage
#  When I save values from columns
#  And I press 'Last Page' button
#  Then I see value 'Last page' in page text field
#  And button 'Next Page' is not active
#  And button 'Last Page' is not active
#  And columns values have changed

#@Pagination_003 @High
#Scenario: Pagination_003 previous page
#  Given I`m on a homepage
#  When I press 'Last Page' button
#  And I save values from columns
#  And  I press 'Previous Page' button
#  Then I see value Last page "-1" in page text field
#  And columns values have changed

#@Pagination_004 @High
#Scenario: Pagination_004 first page
#  Given I`m on a homepage
#  When I press 'Last Page' button
#  And I save values from columns
#  And  I press 'First Page' button
#  Then I see value '1' in page text field
#  And button 'First Page' is not active
#  And button 'Previous Page' is not active
#  And columns values have changed

# @CustomerList @Pagination_005 @High
# Scenario: Pagination_005 page num
#   Given I`m on a homepage
#   When I save values from columns
#   And I enter "3" in 'Page' text field and press ENTER
#   Then I see value '3' in page text field
#   And columns values have changed

 #@CustomerList @Filter @Filter_001 @High
 #Scenario Outline: Filter_001 turn on
 #  Given I`m on a homepage
 #  When I save values from columns
 #  And I save number of pages
 #  And I select "<value>" from 'Customer Type' dropdown list
 #  Then number of pages is less than "saved one"
 #  And columns values have changed
 #  And filter "<value>" is displayed on page
 #  Examples:
 #    | value     |
 #    | Shipper   |
 #     | Agent     |
 #     | Consignee |
 #     | Airline   |

# @Filter @Filter_002 @High
# Scenario Outline: Filter_002
#   Given I`m on a homepage
#   When I select "<value>" from 'Customer Type' dropdown list
#   And I save number of pages
#   And I select "Agent" from 'Customer Type' dropdown list
#   Then number of pages is greater than "saved one"
#   And filter "Agent" is displayed on page
#   And filter "<value>" is displayed on page
#
#   Examples:
#     | value     |
#     | Shipper   |
#     | Consignee |
#     | Airline   |
#
# @Filter @Filter_003 @High
# Scenario: Filter_003
#   Given I`m on a homepage
#   When I save number of pages
#   And I select "Agent" from 'Customer Type' dropdown list
#   And I press 'Clear' link
#   Then number of pages is "saved one"
#   And filter "Agent" is not displayed on page
#
#  @CustomerList @Filter @Filter_004 @High
#  Scenario: Filter_004 deactivate filter
#    Given I`m on a homepage
#    When I select "Agent" from 'Customer Type' dropdown list
#    And I select "Shipper" from 'Customer Type' dropdown list
#    And I press remove "Shipper" filter
#    Then filter "Shipper" is not displayed on page

@CustomerList @Column_management @Column_management_001 @High
Scenario Outline: Column_management_001
Given I`m on a homepage
When I select "<value>" from Columns dropdown in header "Name" dropdown in customer details table
Then Column "<value>" is absent in customer list table
Examples:
| value             |
| Name              |
#  | Short             |
#  | IATA CASS         |
#  | Organisation Name |

# @CustomerList @Column_management @Column_management_002 @High
# Scenario Outline: Column_management_002 hide and show column
#   Given I`m on a homepage
#   When I select "<value>" from Columns dropdown in header "Name" dropdown in customer details table
#   And Column "<value>" is absent in customer list table
#   And I select "<value>" from Columns dropdown in header "Name" dropdown in customer details table
#   Then Column "<value>" is present in customer list table
#   Examples:
#     | value             |
#     | Short             |
#     | IATA CASS         |
#     | Organisation Name |

# @CustomerList @Column_management @Column_management_003 @High
# Scenario Outline: Column_management_003 hide some columns
#   Given I`m on a homepage
#   When I select "<valueOne>" from Columns dropdown in header "Name" dropdown in customer details table
#   And I select "<valueTwo>" from Columns dropdown in header "Name" dropdown in customer details table
#   Then Column "<valueOne>" is absent in customer list table
#   And Column "<valueTwo>" is absent in customer list table
#   Examples:
#     | valueOne          | valueTwo  |
#     | Short             | IATA CASS |
#     | IATA CASS         | Short     |
#     | Organisation Name | IATA CASS |

# @CustomerList @Column_management @Column_management_004 @High
# Scenario: Column_management_004 drag and drop column
#   Given I`m on a homepage
#   And The column "Name" on position "1"
#   When I drag column "Name" to position "3"
#   Then The column "Name" on position "3"

#@CompanyDetails @CompanyDetails_001 @High
#Scenario Outline: CompanyDetails_001
#  Given I`m on a homepage
#  When I enter in a text field called 'Enter search text' following text "<value>"
#  And I click on table row with "<value>"
#  Then CompanyDetail tab opens up
#  And I see that it's fields contain expected information
#  Examples:
#    | value                             |
#    | Agility Logistics Co.             |
#    | SU                                |
#    | 4230415                           |
#    | Expolanka International (Pvt) Ltd |

#CompanyDetails @CompanyDetails_002 @High
#cenario Outline: CompanyDetails_002 fill all fields
# Given I`m on a homepage
# When I enter in a text field called 'Enter search text' following text "<value>"
# And I click on table row with "<value>"
# And I enter in a text field called 'Name' following text "Name"
# And I enter in a text field called 'Legal' following text "Legal"
# And I enter in a text field called 'Short name' following text "Short"
# And I enter in a text field called 'Search' following text "Search"
# And I enter in a text field called 'IATA' following text "IATA"
# And I enter in a text field called 'CASS' following text "CASS"
# And I enter in a text field called 'Account No' following text "acccount"
# And I select checkbox "Agent"
# And I select checkbox "Shipper"
# And I select checkbox "Consignee"
# And checkbox "Agent" is selected
# And checkbox "Shipper" is selected
# And checkbox "Consignee" is selected
# And I unselect checkbox "Shipper"
# And I unselect checkbox "Consignee"
# And checkbox "Agent" is selected
# And checkbox "Shipper" is unselected
# And checkbox "Consignee" is unselected
# And I select "PANALPINA" from 'Organisation' dropdown list
# And text field 'Region' is readonly
# And text field 'City' is readonly
# And text field 'Airport' is readonly
# And text field 'Country' is readonly
# And I select "USD" from 'Currency' dropdown
# And I select "English" from 'Language' dropdown
# And I enter in a text field called 'Website' following text "http:\\some.site.com"
# And I select "PE" from 'Priority' dropdown
# Then I see in text field 'Priority'  text "Partner Elite"
# And I see that text field 'Priority' is readonly
# Examples:
#   | value                             |
#   | Agility Logistics Co.             |
#   | AC UK                                |
#   | 4230415                           |
#   | Expolanka International (Pvt) Ltd |

# @CustomerList @CompanyDetails @CompanyDetails_003 @High
# Scenario Outline: CompanyDetails_003 notifications
#   Given I`m on a homepage
#   When I enter in a text field called 'Enter search text' following text "<value>"
#   And I click on table row with "<value>"
#   And I click on a text field called 'Name' and clear it
#   And I click on a text field called 'Short name' and clear it
#   And I click on a text field called 'Search' and clear it
#   And I select checkbox "Agent"
#   And I unselect checkbox "Agent"
#   And I select checkbox "Shipper"
#   And I unselect checkbox "Shipper"
#   And I select checkbox "Consignee"
#   And I unselect checkbox "Consignee"
#   And I click on dropdown 'Currency' on text area and clear it
#   And I click on dropdown 'Language' on text area and clear it
#   Then I see that 'Name' text field shows that it's input is wrong
#   And I hover mouse over 'Name' text field
#   And I see that text "This field is required" appear
#   And I see that 'Short name' text field shows that it's input is wrong
#   And I hover mouse over 'Short name' text field
#   And I see that text "This field is required" appear
#   And I see that 'Search' text field shows that it's input is wrong
#   And I hover mouse over 'Search' text field
#   And I see that text "This field is required" appear
#   And I see that check box area shows that it's input is wrong
#   And I hover mouse over 'Agent' checkbox
#   And I see that text "You must select at least one item in this group" appear
#   And I see that 'Currency' dropdown shows that it's input is wrong
#   And I hover mouse over 'Currency' text field
#   And I see that text "This field is required" appear
#   And I see that 'Language' dropdown shows that it's input is wrong
#   And I hover mouse over 'Language' text field
#   And I see that text "This field is required" appear


#   Examples:
#     | value                 |
#     | Agility Logistics Co. |
#     | AC UK                    |

#@CompanyDetails @CompanyDetails_004 @High
#Scenario: CompanyDetails_004 try to create customer without one of required field
#  Given I`m on a homepage
#  When I press 'Add' button
#  And I enter in a text field called 'Name' following text "AlexTestCo"
#  And I enter in a text field called 'Short name' following text "Short"
#  And I select checkbox "Agent"
#  And I select "USD" from 'Currency' dropdown
#  And I press 'Save' button
#  Then I see message "Error" in 'Error Notification' container
#  And I close 'Notification' container
#  And I press 'Cancel' button
#  When I press 'Add' button
#  And I enter in a text field called 'Name' following text "AlexTestCo"
#  And I enter in a text field called 'Short name' following text "Short"
#  And I select checkbox "Agent"
#  And I select "English" from 'Language' dropdown
#  And I press 'Save' button
#  Then I see message "Error" in 'Error Notification' container
#  And I press 'Cancel' button
#  When I press 'Add' button
#  And I enter in a text field called 'Name' following text "AlexTestCo"
#  And I enter in a text field called 'Short name' following text "Short"
#  And I select "USD" from 'Currency' dropdown
#  And I select "English" from 'Language' dropdown
#  And I press 'Save' button
#  Then I see message "Error" in 'Error Notification' container
#  And I press 'Cancel' button
#  When I press 'Add' button
#  And I enter in a text field called 'Name' following text "AlexTestCo"
#  And I select checkbox "Agent"
#  And I select "USD" from 'Currency' dropdown
#  And I select "English" from 'Language' dropdown
#  And I press 'Save' button
#  Then I see message "Error" in 'Error Notification' container
#  And I press 'Cancel' button
#  When I press 'Add' button
#  And I enter in a text field called 'Short name' following text "Short"
#  And I select checkbox "Agent"
#  And I select "USD" from 'Currency' dropdown
#  And I select "English" from 'Language' dropdown
#  And I press 'Save' button
#  Then I see message "Error" in 'Error Notification' container
#  And I press 'Cancel' button


# @CustomerList @Membership @Membership_001 @High
# Scenario Outline: Membership_001 adding
#   Given I`m on a homepage
#   When I enter in a text field called 'Enter search text' following text "<value>"
#   And I click on table row with "<value>"
#   And I click on accordion "Memberships"
#   And I press button 'Add' on accordion 'Memberships'
#   And I select "BA Executive Club" from Type dropdown at 'Memberships' table
#   And I enter "21342134" into "Number" field at 'Memberships' table
#   And I enter "Tomorrow" into "From" field at 'Memberships' table
#   And I enter "20/02/2026" into "To" field at 'Memberships' table
#   And I press button "Update" at 'Memberships' table
#   Then I see that field "Type" in Membership table has value "BA Executive Club"
#   And I see that field "Number" in Membership table has value "21342134"
#   And I see that field "From" in Membership table has value "Tomorrow"
#   And I see that field "To" in Membership table has value "20/02/2026"

#   Examples:
#     | value                 |
#     | Agility Logistics Co. |
#     | SU                    |

# @CustomerList @Membership @Membership_002 @High
# Scenario Outline: Membership_002 check colors
#   Given I`m on a homepage
#   When I enter in a text field called 'Enter search text' following text "<value>"
#   And I click on table row with "<value>"
#   And I click on accordion "Memberships"
#   And I press button 'Add' on accordion 'Memberships'
#   Then I see that input field "Type" has red borders
#   And I hover cursor over input field "Type"
#   And I see that text "This field is required" appear
#   Then I see that input field "Number" has red borders
#   And I hover cursor over input field "Number"
#   And I see that text "This field is required" appear
#   And I see that button Update is not active
#   And I press button "Cancel" at 'Memberships' table
#   And I see that input field "Type" is not present
#   And I see that input field "Number" is not present

#   Examples:
#     | value                 |
#     | Agility Logistics Co. |
#     | SU                    |

 # @CustomerList @Membership @Membership_003 @High
 # Scenario: Membership_003 edit
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "<value>"
 #   And I click on accordion "Memberships"
 #   And I press button 'Add' on accordion 'Memberships'
 #   And I select "BA Executive Club" from Type dropdown at 'Memberships' table
 #   And I enter "21342134" into "Number" field at 'Memberships' table
 #   And I enter "Tomorrow" into "From" field at 'Memberships' table
 #   And I enter "20/02/2026" into "To" field at 'Memberships' table
 #   And I press button "Update" at 'Memberships' table
 #   And I double click Type text field
 #   And I select "Cargo Connect" from Type dropdown at 'Memberships' table
 #   And I enter "123123" into "Number" field at 'Memberships' table
 #   And I enter "20/02/2020" into "From" field at 'Memberships' table
 #   And I enter "20/02/2027" into "To" field at 'Memberships' table
 #   And I press button "Update" at 'Memberships' table
 #   Then I see that field "Type" in Membership table has value "Cargo Connect"
 #   And I see that field "Number" in Membership table has value "123123"
 #   And I see that field "From" in Membership table has value "20/02/2020"
 #   And I see that field "To" in Membership table has value "20/02/2027"

 # @CustomerList @Membership @Membership_004 @High
 # Scenario: Membership_004 cancel edit
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "<value>"
 #   And I click on accordion "Memberships"
 #   And I press button 'Add' on accordion 'Memberships'
 #   And I select "BA Executive Club" from Type dropdown at 'Memberships' table
 #   And I enter "21342134" into "Number" field at 'Memberships' table
 #   And I enter "Tomorrow" into "From" field at 'Memberships' table
 #   And I enter "20/02/2026" into "To" field at 'Memberships' table
 #   And I press button "Update" at 'Memberships' table
 #   And I double click Type text field
 #   And I select "Cargo Connect" from Type dropdown at 'Memberships' table
 #   And I enter "123123" into "Number" field at 'Memberships' table
 #   And I enter "20/02/2020" into "From" field at 'Memberships' table
 #   And I enter "20/02/2027" into "To" field at 'Memberships' table
 #   And I press button "Cancel" at 'Memberships' table
 #   Then I see that field "Type" in Membership table has value "BA Executive Club"
 #   And I see that field "Number" in Membership table has value "21342134"
 #   And I see that field "From" in Membership table has value "Tomorrow"
 #   And I see that field "To" in Membership table has value "20/02/2026"
#
 # @CustomerList  @Membership @Membership_005 @High
 # Scenario: Membership_005 removing
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "<value>"
 #   And I click on accordion "Memberships"
 #   And I press button 'Add' on accordion 'Memberships'
 #   And I select "BA Executive Club" from Type dropdown at 'Memberships' table
 #   And I enter "21342134" into "Number" field at 'Memberships' table
 #   And I enter "Tomorrow" into "From" field at 'Memberships' table
 #   And I enter "20/02/2026" into "To" field at 'Memberships' table
 #   And I press button "Update" at 'Memberships' table
 #   And I click on 'Number' text field
 #   And I press button 'Remove'
 #   And I press button "OK" on Confirmation dialog
 #   Then I see that no text field "Number" with value "21342134"

 #@Addresses @Addresses_001 @High
 #Scenario Outline: Addresses_001
 #  Given I`m on a homepage
 #  When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #  And I click on table row with "Agility Logistics Co."
 #  And I click on accordion "Addresses"
 #  And I select "<value>" from Type dropdown in "first" Address form
 #  And I enter "some_address1" into 'Address Line 1' text field in "first" Address form
 #  And I enter "some_address2" into 'Address Line 2' text field in "first" Address form
 #  And I select "USA" in 'Country' dropdown in "first" Address form
 #  And I select "Florida" in 'State / County' dropdown in "first" Address form
 #  And I select "Aberdeen" in 'City' dropdown in "first" Address form
 #  And I enter "123456" into 'Zip / Postcode' text field in "first" Address form
 #  And I press 'Save' button
 #  And I enter in a text field called 'Enter search text' following text ""
 #  And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #  And I click on table row with "Agility Logistics Co."
 #  And I click on accordion "Addresses"
 #  Then I see value "<value>" in Type dropdown in "first" Address form
 #  And I see value "some_address1" in 'Address Line 1' text field in "first" Address form
 #  And I see value "some_address2" in 'Address Line 2' text field in "first" Address form
 #  And I see value "USA" in 'Country' dropdown in "first" Address form
 #  And I see value "Florida" in 'State / County' dropdown in "first" Address form
 #  And I see value "Aberdeen" in 'City' dropdown in "first" Address form
 #  And I see value "123456" in 'Zip / Postcode' text field in "first" Address form
 #  Examples:
 #    | value      |
 #    | Registered |
 #    | Mailing    |
 #    | Invoice    |


# @Addresses @Addresses_002 @High
# Scenario: Addresses_002
#   Given I`m on a homepage
#   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#   And I click on table row with "Agility Logistics Co."
#   And I click on accordion "Addresses"
#   And I select "Registered" from Type dropdown in "first" Address form
#   And I enter "some_address1" into 'Address Line 1' text field in "first" Address form
#   And I enter "some_address2" into 'Address Line 2' text field in "first" Address form
#   And I select "USA" in 'Country' dropdown in "first" Address form
#   And I select "Florida" in 'State / County' dropdown in "first" Address form
#   And I select "Aberdeen" in 'City' dropdown in "first" Address form
#   And I enter "123456" into 'Zip / Postcode' text field in "first" Address form
#   And I press 'Save' button
#   And I enter in a text field called 'Enter search text' following text ""
#   And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#   And I click on table row with "Agility Logistics Co."
#   And I click on accordion "Addresses"
#   And I click on button Add in 'Addresses' accordion
#   And I select "Registered" from Type dropdown in "second" Address form
#   And I enter "some_address1" into 'Address Line 1' text field in "second" Address form
#   And I enter "some_address2" into 'Address Line 2' text field in "second" Address form
#   And I select "USA" in 'Country' dropdown in "second" Address form
#   And I select "Florida" in 'City' dropdown in "second" Address form
#   And I select "Aberdeen" in 'State / County' dropdown in "second" Address form
#   And I enter "123456" into 'Zip / Postcode' text field in "second" Address form
#   And I press 'Save' button
#   Then I see value "Registered" in Type dropdown in "second" Address form
#   And I see value "some_address1" in 'Address Line 1' text field in "second" Address form
#   And I see value "some_address2" in 'Address Line 2' text field in "second" Address form
#   And I see value "USA" in 'Country' dropdown in "second" Address form
#   And I see value "Florida" in 'State / County' dropdown in "second" Address form
#   And I see value "Aberdeen" in 'City' dropdown in "second" Address form
#   And I see value "123456" in 'Zip / Postcode' text field in "second" Address form
#   And I delete "second" address
#   And I press button "OK" on Confirmation dialog
#   And I enter in a text field called 'Enter search text' following text ""
#   And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#   And I click on table row with "Agility Logistics Co."
#   And I click on accordion "Addresses"
#   And I see 1 address avaliable


 #@Addresses @Addresses_003 @High
 #Scenario: Addresses_003
 #  Given I`m on a homepage
 #  When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #  And I click on table row with "Agility Logistics Co."
 #  And I click on accordion "Addresses"
 #  And I click on Type dropdown in "first" Address form  and clear it
 #  And I click on 'Address Line 1' text field in "first" Address form and clear it
 #  And I click on 'Country' dropdown in "first" Address form and clear it
 #  And I click on 'City' dropdown in "first" Address form and clear it
 #  And I click on 'Address Line 2' text field in "first" Address form and clear it
 #  And I see that Type dropdown in "first" Address form shows that it's input is wrong
 #  And I see that 'Address Line 1' text field in "first" Address form  shows that it's input is wrong
 #  And I see that Country dropdown in "first" Address form shows that it's input is wrong
 #  And I see that City dropdown in "first" Address form shows that it's input is wrong
 #  And I hover mouse over Type dropdown in "first" Address form
 #  And I see that text "This field is required" appear
 #  And I hover mouse over 'Address Line 1' text field in "first" Address form
 #  And I see that text "This field is required" appear
 #  And I hover mouse over Country dropdown in "first" Address form
 #  And I see that text "This field is required" appear
 #  And I hover mouse over City dropdown in "first" Address form
 #  And I see that text "This field is required" appear
 #  Then I see that button Add is not clickable


 # @CustomerList @Addresses @Addresses_004 @High
 # Scenario: Addresses_004
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Addresses"
 #   And I select "Registered" from Type dropdown in "first" Address form
 #   And I enter "some_address2" into 'Address Line 2' text field in "first" Address form
 #   And I select "USA" in 'Country' dropdown in "first" Address form
 #   And I select "Florida" in 'State / County' dropdown in "first" Address form
 #   And I select "Aberdeen" in 'City' dropdown in "first" Address form
 #   And I enter "123456" into 'Zip / Postcode' text field in "first" Address form
 #   Then I see that button Add is not clickable

#  @Contacts @Contacts_001 @High
#  Scenario: Contacts_001
#    Given I`m on a homepage
#    When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#    And I click on table row with "Agility Logistics Co."
#    And I click on accordion "Contacts"
#    And I press button 'Add Contact'
#    And I select "Mr." from 'Title' dropdown
#    And I enter in a text field called 'First Name' value "John"
#    And I enter in a text field called 'Middle' value "Richard"
#    And I enter in a text field called 'Surname' value "Dou"
#    And I enter in a text field called 'Department' value "12312312"
#    And I select "English" from 'Language' dropdown in Contacts accordion
#    And I click on button Add in 'Contacts' accordion
#    And I select "Phone" from 'Type' dropdown in "last" contact row
#    And I enter in a text field called "Number/Email" value '88005553535' in "last" contact row
#    And I see that check box called priority is checked in "last" contact row
#    And I click on button Add in 'Contacts' accordion
#    And I select "Email" from 'Type' dropdown in "last" contact row
#    And I enter in a text field called "Number/Email" value '123@mail.com' in "last" contact row
#    And I check checkbox 'Primary' in "last" contact row
#    And I see that check box called priority is checked in "last" contact row
#    And I press 'Save' button
#    And I enter in a text field called 'Enter search text' following text ""
#    And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#  And I click on table row with "Agility Logistics Co."
#  And I click on accordion "Contacts"
#  Then I see that that Contacts section contains 1 section
#  And I see that 'Name' text field has value "Mr. Jhon Dou"
#  And I see that 'Phone' text field has value "123@mail.com"
#   And I click on expand button on "last" contact row
#  And I see that contacts contains 2 contacts line
#  And I see that text field 'Type' in "first" row has value "Phone"
#  And I see that text field 'Type' in "second" row has value "Email"
#  And I see that text field 'Number\Email' in "first" row has value "88005553535"
#  And I see that text field 'Number\Email' in "second" row has value "123@mail.com"
#  And I see that check box called priority is checked in "second" contact row
#  And I see that check box called priority is unchecked in "first" contact row
#  And I delete "last" contact
#  And I enter in a text field called 'Enter search text' following text ""
#  And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#  And I click on table row with "Agility Logistics Co."
#  And I click on accordion "Contacts"
#  And I see that that Contacts section contains 0 section


#@Contacts @Contacts_002 @High
#Scenario: Contacts_002
#  Given I`m on a homepage
#  And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#  And I click on table row with "Agility Logistics Co."
#  And I click on accordion "Contacts"
#  And I press button 'Add Contact'
#  And I select "Mr." from 'Title' dropdown
#  And I enter in a text field called 'First Name' value "John"
#  And I enter in a text field called 'Middle' value "Richard"
#  And I enter in a text field called 'Surname' value "Dou"
#  And I enter in a text field called 'Department' value "12312312"
#  And I select "English" from 'Language' dropdown in Contacts accordion
#  And I click on button Add in 'Contacts' accordion
#  And I select "Phone" from 'Type' dropdown in "last" contact row
#  And I enter in a text field called "Number/Email" value '88005553535' in "last" contact row
#  And I see that check box called priority is checked in "last" contact row
#  And I click on button Add in 'Contacts' accordion
#  And I select "Email" from 'Type' dropdown in "last" contact row
#  And I enter in a text field called "Number/Email" value '123@mail.com' in "last" contact row
#  And I check checkbox 'Primary' in "last" contact row
#  And I see that check box called priority is checked in "last" contact row
#  And I press 'Save' button
#  And I enter in a text field called 'Enter search text' following text ""
#  And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#  And I click on table row with "Agility Logistics Co."
#  And I click on accordion "Contacts"
#  When I click on expand button on contact with name "Mr. John Dou"
#  And I select "Mrs." from 'Title' dropdown
#  And I enter in a text field called 'First Name' value "Jane"
#  And I enter in a text field called 'Middle' value "Emma"
#  And I click on Type cell in "first" contact row
#  And I select 'Fax' from 'Type' dropdown in "first" contact row
#  And I enter in a text field called "Number/Email" value '123test' in "first" contact row
#  And I check checkbox 'Primary' in "first" contact row
#  And I press 'Save' button
#  And I enter in a text field called 'Enter search text' following text ""
#  And I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#  And I click on table row with "Agility Logistics Co."
#  And I click on accordion "Contacts"
#  Then I see that that Contacts section contains 1 section
#  And I see that 'Name' text field has value "Mrs. Jane Dou"
#  And I see that 'Phone' text field has value "123test"
#  And I click on expand button on "last" contact row
#  And I see that contacts contains 2 contacts line
#  And I see that text field 'Type' in "first" row has value "Fax"
#  And I see that text field 'Type' in "second" row has value "Email"
#  And I see that text field 'Number\Email' in "first" row has value "123test"
#  And I see that text field 'Number\Email' in "second" row has value "123@mail.com"
#  And I see that check box called priority is unchecked in "second" contact row
#  And I see that check box called priority is checked in "first" contact row
#  And I delete "last" contact

# @Contacts @Contacts_003 @High
# Scenario: Contacts_003
#   Given I`m on a homepage
#   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
#   And I click on table row with "Agility Logistics Co."
#   And I click on accordion "Contacts"
#   And I press button 'Add Contact'
#   And I click on button Add in 'Contacts' accordion
#   And I click on 'Address Line 2' text field in "<string>" Address form and clear it
#   And I click on Department text field
#   Then I see that text field 'Title' shows that it`s contents are wrong
#   And I see that text field 'First Name' shows that it`s contents are wrong
#   And I see that text field 'Surname' shows that it`s contents are wrong
#   And I see that text field 'Language' shows that it`s contents are wrong
#   And I see that text field 'Type'




@CustomerList  @Membership @Membership_Column_management @Membership_Column_management_001 @High
Scenario: Membership_Column_management_001
Given I`m on a homepage
When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
And I click on table row with "Agility Logistics Co."
And I click on accordion "Memberships"
And I select "Type" from Columns dropdown in header "To" dropdown in membership table
And Column "Type" is absent in membership list table
And I select "Type" from Columns dropdown in header "To" dropdown in membership table
Then Column "Type" is present in membership list table


 # @CustomerList  @Membership @Membership_Column_management @Membership_Column_management_002 @High
 # Scenario Outline: Membership_Column_management_002
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Memberships"
 #   And I select "<value>" from Columns dropdown in header "Type" dropdown in membership table
 #   And Column "<value>" is absent in membership list table
 #   And I select "<value>" from Columns dropdown in header "Type" dropdown in membership table
 #   Then Column "<value>" is present in membership list table
 #   Examples:
 #     | value  |
 #     | To     |
 #     | From   |
 #     | Number |

 # @CustomerList @Membership @Membership_Column_management @Membership_Column_management_003 @High
 # Scenario Outline: Membership_Column_management_003
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Memberships"
 #   And I select "<valueOne>" from Columns dropdown in header "Type" dropdown in membership table
 #   And I select "<valueTwo>" from Columns dropdown in header "Type" dropdown in membership table
 #   Then Column "<valueOne>" is absent in membership list table
 #   And Column "<valueTwo>" is absent in membership list table
 #   Examples:
 #     | valueOne | valueTwo |
 #     | To       | From     |
 #     | To       | Number   |
 #     | From     | Number   |

 # @Membership @Membership_Column_management @Membership_Column_management_004 @High
 # Scenario: Membership_Column_management_004
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Memberships"
 #   And The column "Type" on position "1" in membership table
 #   And I drag column "Type" to position "3" in membership table
 #   Then The column "Type" on position "3" in membership table

 # @CustomerList @Contacts @Contacts_Column_management @Contacts_Column_management_001 @High
 # Scenario Outline: Membership_Column_management_001
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Contacts"
 #   And I select "<valueOne>" from Columns dropdown in header "<valueTwo>" dropdown in contacts table
 #   And Column "<valueOne>" is absent in contacts list table
 #   And I select "<valueOne>" from Columns dropdown in header "<valueTwo>" dropdown in contacts table
 #   Then Column "<valueOne>" is present in contacts list table
 #   Examples:
 #     | valueOne | valueTwo |
 #     | Name     | Phone    |
 #     | Phone    | Name     |

 # @Contacts @Contacts_Column_management @Contacts_Column_management_002 @High
 # Scenario: Contacts_Column_management_004
 #   Given I`m on a homepage
 #   When I enter in a text field called 'Enter search text' following text "Agility Logistics Co."
 #   And I click on table row with "Agility Logistics Co."
 #   And I click on accordion "Contacts"
 #   And The column "Name" on position "2" in contacts table
 #   And I drag column "Name" to position "3" in contacts table
 #   Then The column "Name" on position "3" in contacts table



#
#  @Deleting_001 @High
#  Scenario Outline: Deleting_001
#    Given I`m on a homepage
#    When I enter "<value>" in 'Enter search text' text field
#    And I press "Delete" button in "Action" column for "<value>" field
#    And I enter "<value>" in 'Enter search text' text field
#    Then I see empty table
#
#    Examples:
#      | value                             |
#      | Agility Logistics Co.             |
#      | SU                                |
#      | 4230415                           |
#      | Expolanka International (Pvt) Ltd |
#
#
# @Adding_001 @High
# Scenario: Adding_001
#   Given I`m on a homepage
#   When I press 'Add' button
#   And I enter in a text field called 'Name' following text "Test_company_001"
#   And I enter in a text field called 'Legal' following text "Legal"
#   And I enter in a text field called 'Short name' following text "Short"
#   And I enter in a text field called 'Search' following text "Search"
#   And I enter in a text field called 'IATA' following text "IATA"
#   And I enter in a text field called 'CASS' following text "CASS"
#   And I enter in a text field called 'Account No' following text "acccount"
#   And I select checkbox "Agent"
#   And I select checkbox "Shipper"
#   And I select "PANALPINA" from 'Organisation' dropdown list
#   And I select "USD" from 'Currency' dropdown
#   And I select "English" from 'Language' dropdown
#   And I enter in a text field called 'Website' following text "http:\\some.site.com"
#   And I select "PE" from 'Priority' dropdown
#   And I press 'Save' button
#   And I enter in a text field called 'Enter search text' following text "Test_company_001"
#   And I click on table row with "Test_company_001"
#   Then I see that text field called 'Name' contains following text "Test_company_001"
#   And I see that text field called 'Legal' contains following text "Legal"
#   And I see that text field called 'Short name' contains following text "Short"
#   And I see that text field called 'Search' contains following text "Search"
#   And I see that text field called 'IATA' contains following text "IATA"
#   And I see that text field called 'CASS' contains following text "CASS"
#   And I see that text field called 'Account No' contains following text "acccount"
#   And checkbox "Shipper" is selected
#   And checkbox "Agent" is selected
#   And I see that dropdown 'Organisation' contains value "PANALPINA"
#   And I see that dropdown 'Currency' contains value "USD"
#   And I see that dropdown 'Language' contains value "English"
#   And I see that dropdown 'Priority' contains value "PE"
#   And I see in text field 'Priority'  text "Partner Elite"
#   And I see that text field called 'Website' contains following text "http:\\some.site.com"
#   And I delete record "Test_company_001"
#   And I press button "OK" on Confirmation dialog
#   And I enter in a text field called 'Enter search text' following text "Test_company_001"
#   And I see no result "Test_company_001"

# @Adding_002 @High
# Scenario: Adding_002 with required fields only
#   Given I`m on a homepage
#   When I press 'Add' button
#   And I enter in a text field called 'Name' following text "Test_company_001"
#   And I enter in a text field called 'Short name' following text "Short"
#   And I enter in a text field called 'Search' following text "Search"
#   And I select checkbox "Agent"
#   And I select "USD" from 'Currency' dropdown
#   And I select "English" from 'Language' dropdown
#   And I press 'Save' button
#   And I enter in a text field called 'Enter search text' following text "Test_company_001"
#   And I see value "Test_company_001" in "Name" column
#   And I delete record "Test_company_001"
#   And I press button "OK" on Confirmation dialog
#   And I enter in a text field called 'Enter search text' following text "Test_company_001"
#   And I see no result "Test_company_001"


