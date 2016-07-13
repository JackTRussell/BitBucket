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

@CustomerList @Pagination_001 @High
Scenario: Pagination_001 next page
Given I`m on a homepage
When I save values from columns
And I press 'Next Page' button
Then I see value '2' in page text field
And columns values have changed


@CustomerList @Column_management @Column_management_001 @High
Scenario Outline: Column_management_001
Given I`m on a homepage
When I select "<value>" from Columns dropdown in header "Name" dropdown in customer details table
Then Column "<value>" is absent in customer list table
Examples:
| value             |
| Name              |

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
