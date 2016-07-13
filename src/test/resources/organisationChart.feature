@Feature_organisationChart
Feature: Organisation tree

@dragAndDrop @dragAndDrop_001 @High
Scenario Outline: Drag And Drop Customer chartitem between branches
Given I`m on Organisation Chart page
And I select "<organisation>" from Select Organistion DropDown
#And I save structure of "<organisation>" organisation
And I expand "<organisation>" "Organisation" chartitem
And I expand "<continent 1>" "Continent" chartitem
And I expand "<region 1>" "Region" chartitem
And I expand "<country 1>" "Country" chartitem
And I expand "<city 1>" "City" chartitem
And I expand "<airport 1>" "Airport" chartitem
And I expand "<continent 2>" "Continent" chartitem
And I expand "<region 2>" "Region" chartitem
And I expand "<country 2>" "Country" chartitem
And I expand "<city 2>" "City" chartitem
And I expand "<airport 2>" "Airport" chartitem
When I drag "<customer 2>" "Customer" chartitem to "<airport 1>" "Airport" chartitem
Then I see "<airport 1>" "Airport" chartitem contains "<customer 2>" "Customer" chartitem
And I see "<airport 2>" "Airport" chartitem not contains "<customer 2>" "Customer" chartitem
#And I restore structure of "<organisation>" organisation
And I drag "<customer 2>" "Customer" chartitem to "<airport 2>" "Airport" chartitem

Examples:
| organisation                        | continent 1 | region 1    | country 1 | city 1 | airport 1 | continent 2 | region 2 | country 2 | city 2  | airport 2 | customer 2              |
| Chapman Freeborn Group of Companies | Asia        | Middle East | UAE       | Dubai  | DXB       | Africa      | Africa   | KENYA     | Nairobi | NBO       | Chapman Freeborn Torino |
@dragAndDrop @dragAndDrop_002 @High
Scenario Outline: Drag And Drop Airport chartitem between branches
Given I`m on Organisation Chart page
And I select "<organisation>" from Select Organistion DropDown
And I expand "<organisation>" "Organisation" chartitem
And I expand "<continent 1>" "Continent" chartitem
And I expand "<region 1>" "Region" chartitem
And I expand "<country 1>" "Country" chartitem
And I expand "<city 1>" "City" chartitem
And I expand "<continent 2>" "Continent" chartitem
And I expand "<region 2>" "Region" chartitem
And I expand "<country 2>" "Country" chartitem
And I expand "<city 2>" "City" chartitem
When I drag "<airport 1>" "Airport" chartitem to "<city 2>" "City" chartitem
Then I see "<city 2>" "City" chartitem contains "<airport 1>" "Airport" chartitem
And I see "<city 1>" "City" chartitem not contains "<airport 1>" "Airport" chartitem
And I drag "<airport 1>" "Airport" chartitem to "<city 1>" "City" chartitem
Examples:
| organisation                        | continent 1 | region 1    | country 1 | city 1 | airport 1 | continent 2 | region 2 | country 2 | city 2  |
| Chapman Freeborn Group of Companies | Asia        | Middle East | UAE       | Dubai  | DXB       | Africa      | Africa   | KENYA     | Nairobi |
# @dragAndDrop @dragAndDrop_003 @High
# Scenario Outline: Drag And Drop City chartitem between branches
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent 1>" "Continent" chartitem
#   And I expand "<region 1>" "Region" chartitem
#   And I expand "<country 1>" "Country" chartitem
#   And I expand "<continent 2>" "Continent" chartitem
#   And I expand "<region 2>" "Region" chartitem
#   And I expand "<country 2>" "Country" chartitem
#   When I drag "<city 2>" "City" chartitem to "<country 1>" "Country" chartitem
#   Then I see "<country 1>" "Country" chartitem contains "<city 2>" "City" chartitem
#   And I see "<country 2>" "Country" chartitem not contains "<city 2>" "City" chartitem
#   And I drag "<city 2>" "City" chartitem to "<country 2>" "Country" chartitem

#   Examples:
#     | organisation                        | continent 1 | region 1 | country 1 | continent 2   | region 2      | country 2 | city 2      |
#     | Chapman Freeborn Group of Companies | Asia        | Far East | CHINA     | North America | North America | USA       | New York NY |

# @dragAndDrop @dragAndDrop_004 @High
# Scenario Outline: Drag And Drop Country chartitem between branches
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent 1>" "Continent" chartitem
#   And I expand "<region 1>" "Region" chartitem
#   And I expand "<continent 2>" "Continent" chartitem
#   And I expand "<region 2>" "Region" chartitem
#   When I drag "<country 1>" "Country" chartitem to "<region 2>" "Region" chartitem
#   Then I see "<region 2>" "Region" chartitem contains "<country 1>" "Country" chartitem
#   And I see "<region 1>" "Region" chartitem not contains "<country 1>" "Country" chartitem
#   And I drag "<country 1>" "Country" chartitem to "<region 1>" "Region" chartitem

#   Examples:
#     | organisation                        | continent 1 | region 1 | country 1 | continent 2   | region 2      |
#     | Chapman Freeborn Group of Companies | Asia        | Far East | Vietnam   | North America | North America |

# @dragAndDrop @dragAndDrop_005 @High
# Scenario Outline: Drag And Drop Region chartitem between branches
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent 1>" "Continent" chartitem
#   And I expand "<continent 2>" "Continent" chartitem
#   When I drag "<region 1>" "Region" chartitem to "<continent 2>" "Continent" chartitem
#   Then I see "<continent 2>" "Continent" chartitem contains "<region 1>" "Region" chartitem
#   And I see "<continent 1>" "Continent" chartitem not contains "<region 1>" "Region" chartitem
#   And I drag "<region 1>" "Region" chartitem to "<continent 1>" "Continent" chartitem

#   Examples:
#     | organisation                        | continent 1 | region 1 | continent 2   |
#     | Chapman Freeborn Group of Companies | Africa      | Africa   | North America |

# @dragAndDrop @dragAndDrop_006 @High
# Scenario Outline: Drag And Drop "Customer" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<customer>" "Customer" chartitem to "<city>" "City" chartitem
#   Then I see "<city>" "City" chartitem not contains "<customer>" "Customer" chartitem
#   And I see "<airport>" "Airport" chartitem contains "<customer>" "Customer" chartitem
#   And I drag "<customer>" "Customer" chartitem to "<country>" "Country" chartitem
#   And I see "<country>" "Country" chartitem not contains "<customer>" "Customer" chartitem
#   And I drag "<customer>" "Customer" chartitem to "<region>" "Region" chartitem
#   And I see "<region>" "Region" chartitem not contains "<customer>" "Customer" chartitem
#   And I drag "<customer>" "Customer" chartitem to "<continent>" "Continent" chartitem
#   And I see "<continent>" "Continent" chartitem not contains "<customer>" "Customer" chartitem
#   And I drag "<customer>" "Customer" chartitem to "<organisation>" "Organisation" chartitem
#   And I see "<organisation>" "Organisation" chartitem not contains "<customer>" "Customer" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

# @dragAndDrop @dragAndDrop_007 @High
# Scenario Outline: Drag And Drop "Airport" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<airport>" "Airport" chartitem to "<customer>" "Customer" chartitem
#   Then I see "<customer>" "Customer" chartitem not contains "<airport>" "Airport" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<country>" "Country" chartitem
#   And I see "<country>" "Country" chartitem contains "<airport>" "Airport" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<city>" "City" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<region>" "Region" chartitem
#   And I see "<region>" "Region" chartitem contains "<airport>" "Airport" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<city>" "City" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<continent>" "Continent" chartitem
#   And I see "<continent>" "Continent" chartitem contains "<airport>" "Airport" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<city>" "City" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<organisation>" "Organisation" chartitem
#   And I see "<organisation>" "Organisation" chartitem contains "<airport>" "Airport" chartitem
#   And I drag "<airport>" "Airport" chartitem to "<city>" "City" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

# @dragAndDrop @dragAndDrop_008 @High
# Scenario Outline: Drag And Drop "City" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<city>" "City" chartitem to "<customer>" "Customer" chartitem
#   Then I see "<customer>" "Customer" chartitem not contains "<city>" "City" chartitem
#   And I drag "<city>" "City" chartitem to "<airport>" "Airport" chartitem
#   And I see "<airport>" "Airport" chartitem not contains "<city>" "City" chartitem
#   And I drag "<city>" "City" chartitem to "<region>" "Region" chartitem
#   And I see "<region>" "Region" chartitem contains "<city>" "City" chartitem
#   And I drag "<city>" "City" chartitem to "<country>" "Country" chartitem
#   And I drag "<city>" "City" chartitem to "<continent>" "Continent" chartitem
#   And I see "<continent>" "Continent" chartitem contains "<city>" "City" chartitem
#   And I drag "<city>" "City" chartitem to "<country>" "Country" chartitem
#   And I drag "<city>" "City" chartitem to "<organisation>" "Organisation" chartitem
#   And I see "<organisation>" "Organisation" chartitem contains "<city>" "City" chartitem
#   And I drag "<city>" "City" chartitem to "<country>" "Country" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

# @dragAndDrop @dragAndDrop_009 @High
# Scenario Outline: Drag And Drop "Country" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<country>" "Country" chartitem to "<customer>" "Customer" chartitem
#   Then I see "<customer>" "Customer" chartitem not contains "<country>" "Country" chartitem
#   And I drag "<country>" "Country" chartitem to "<airport>" "Airport" chartitem
#   And I see "<airport>" "Airport" chartitem not contains "<country>" "Country" chartitem
#   And I drag "<country>" "Country" chartitem to "<city>" "City" chartitem
#   And I see "<city>" "City" chartitem not contains "<country>" "Country" chartitem
#   And I drag "<country>" "Country" chartitem to "<continent>" "Continent" chartitem
#   And I see "<continent>" "Continent" chartitem contains "<country>" "Country" chartitem
#   And I drag "<country>" "Country" chartitem to "<region>" "Region" chartitem
#   And I drag "<country>" "Country" chartitem to "<organisation>" "Organisation" chartitem
#   And I see "<organisation>" "Organisation" chartitem contains "<country>" "Country" chartitem
#   And I drag "<country>" "Country" chartitem to "<region>" "Region" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

# @dragAndDrop @dragAndDrop_010 @High
# Scenario Outline: Drag And Drop "Region" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<region>" "Region" chartitem to "<customer>" "Customer" chartitem
#   Then I see "<customer>" "Customer" chartitem not contains "<region>" "Region" chartitem
#   And I drag "<region>" "Region" chartitem to "<airport>" "Airport" chartitem
#   And I see "<airport>" "Airport" chartitem not contains "<region>" "Region" chartitem
#   And I drag "<region>" "Region" chartitem to "<city>" "City" chartitem
#   And I see "<city>" "City" chartitem not contains "<region>" "Region" chartitem
#   And I drag "<region>" "Region" chartitem to "<country>" "Country" chartitem
#   And I see "<country>" "Country" chartitem not contains "<region>" "Region" chartitem
#   And I drag "<region>" "Region" chartitem to "<organisation>" "Organisation" chartitem
#   And I see "<organisation>" "Organisation" chartitem contains "<region>" "Region" chartitem
#   And I drag "<region>" "Region" chartitem to "<continent>" "Continent" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

# @dragAndDrop @dragAndDrop_011 @High
# Scenario Outline: Drag And Drop "Continent" chartitem over hierarchy
#   Given I`m on Organisation Chart page
#   And I select "<organisation>" from Select Organistion DropDown
#   And I expand "<organisation>" "Organisation" chartitem
#   And I expand "<continent>" "Continent" chartitem
#   And I expand "<region>" "Region" chartitem
#   And I expand "<country>" "Country" chartitem
#   And I expand "<city>" "City" chartitem
#   And I expand "<airport>" "Airport" chartitem
#   When I drag "<continent>" "Continent" chartitem to "<customer>" "Customer" chartitem
#   Then I see "<customer>" "Customer" chartitem not contains "<continent>" "Continent" chartitem
#   And I drag "<continent>" "Continent" chartitem to "<airport>" "Airport" chartitem
#   And I see "<airport>" "Airport" chartitem not contains "<continent>" "Continent" chartitem
#   And I drag "<continent>" "Continent" chartitem to "<city>" "City" chartitem
#   And I see "<city>" "City" chartitem not contains "<continent>" "Continent" chartitem
#   And I drag "<continent>" "Continent" chartitem to "<country>" "Country" chartitem
#   And I see "<country>" "Country" chartitem not contains "<continent>" "Continent" chartitem
#   And I drag "<continent>" "Continent" chartitem to "<region>" "Region" chartitem
#   And I see "<region>" "Region" chartitem not contains "<continent>" "Continent" chartitem

#   Examples:
#     | organisation                        | continent     | region        | country | city        | airport | customer          |
#     | Chapman Freeborn Group of Companies | North America | North America | USA     | New York NY | JFK     | Chapman NY Department |

#  @CreateAndDeleteTree @CreateTree_001 @High
#  Scenario Outline: Creating chartiem tree
#
#    Given I`m on a homepage
#    And I press 'Add' button
#    And I enter in a text field called 'Name' following text "<customer>"
#    And I enter in a text field called 'Short name' following text "Short"
#    And I enter in a text field called 'Search' following text "Search"
#    And I select checkbox "Agent"
#    And I select "USD" from 'Currency' dropdown
#    And I select "English" from 'Language' dropdown
#    And I press 'Save' button
#    And I`m on Organisation Chart page
#    When I select "<organisation>" from Select Organistion DropDown
#    And I drag "Continent" chartitem from Structure table to "<organisation>" "Organisation" chartitem
#    And I type "<continent>" in 'Enter name' field on 'New Item' dialog
#    And I press "OK" button on 'New Item' dialog
#    Then I see ""<organisation>" "Organisation" chartitem contains "<continent>" "Continent" chartitem
#    And I drag "Region" chartitem from Structure table to "<continent>" "Continent" chartitem
#    And I type "<region>" in 'Enter name' field on 'New Item' dialog
#    And I press "OK" button on 'New Item' dialog
#    And I see "<continent>" "Continent" chartitem contains "<region>" "Region" chartitem
#    And I drag "Country" chartitem from Structure table to "<region>" "Region" chartitem
#    And I type "<country>" in 'Enter name' field on 'New Item' dialog
#    And I press "OK" button on 'New Item' dialog
#    And I see "<region>" "Region" chartitem contains "<country>" "Country" chartitem
#    And I drag "City" chartitem from Structure table to "<country>" "Country" chartitem
#    And I type "<city>" in 'Enter name' field on 'New Item' dialog
#    And I press "OK" button on 'New Item' dialog
#    And I see "<country>" "Country" chartitem contains "<city>" "City" chartitem
#    And I drag "Airport" chartitem from Structure table to "<city>" "City" chartitem
#    And I type "<airport>" in 'Enter name' field on 'New Item' dialog
#    And I press "OK" button on 'New Item' dialog
#    And I see "<city>" "City" chartitem contains "<airport>" "Airport" chartitem
#    And I drag "<customer>" customer chartitem from Customer table to "<airport>" "Airport" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<airport>" "Airport" chartitem contains "<customer>" "Customer" chartitem
#
#    Examples:
#      | organisation                        | continent | region | country | city    | airport | customer       |
#      | Chapman Freeborn Group of Companies | Europe    | Europe | UKRAINE | Kharkov | HRK     | Alex Expolanka |
#
#
#  @CreateAndDeleteTree @DeleteChartItem_001 @High
#  Scenario Outline: Trying to delete chart item with customer
#    Given I`m on Organisation Chart page
#    And I select "<organisation>" from Select Organistion DropDown
#    And I expand "<organisation>" "Organisation" chartitem
#    And I expand "<continent>" "Continent" chartitem
#    And I expand "<region>" "Region" chartitem
#    And I expand "<country>" "Country" chartitem
#    And I expand "<city>" "City" chartitem
#    And I expand "<airport>" "Airport" chartitem
#    When I delete "<continent>" "Continent" chartitem
#    Then I see message "Action is not allowed!" in 'Error Notification' container
#    And I see "<organisation>" "Organisation" chartitem contains "<continent>" "Continent" chartitem
#    And I delete "<region>" "Region" chartitem
#    And I see message "Action is not allowed!" in 'Error Notification' container
#    And I see "<continent>" "Continent" chartitem contains "<region>" "Region" chartitem
#    And I delete "<country>" "Country" chartitem
#    And I see message "Action is not allowed!" in 'Error Notification' container
#    And I see "<region>" "Region" chartitem contains "<country>" "Country" chartitem
#    And I delete "<city>" "City" chartitem
#    And I see message "Action is not allowed!" in 'Error Notification' container
#    And I see "<country>" "Country" chartitem contains "<city>" "City" chartitem
#    And I delete "<airport>" "Airport" chartitem
#    And I see message "Action is not allowed!" in 'Error Notification' container
#    And I see "<city>" "City" chartitem contains "<airport>" "Airport" chartitem
#
#    Examples:
#      | organisation                        | continent | region | country | city    | airport |
#      | Chapman Freeborn Group of Companies | Europe    | Europe | UKRAINE | Kharkov | HRK     |
#
#  @CreateAndDeleteTree @DeleteChartItem_002 @High
#  Scenario Outline: Deleting chart item without childrens
#    Given I`m on Organisation Chart page
#    And I select "<organisation>" from Select Organistion DropDown
#    And I expand "<organisation>" "Organisation" chartitem
#    And I expand "<continent>" "Continent" chartitem
#    And I expand "<region>" "Region" chartitem
#    And I expand "<country>" "Country" chartitem
#    And I expand "<city>" "City" chartitem
#    And I expand "<airport>" "Airport" chartitem
#    When I delete "<customer>" "Customer" chartitem
#    And I press button "OK" on Confirmation dialog
#    Then I see "<airport>" "Airport" chartitem not contains "<customer>" "Customer" chartitem
#    And I delete "<airport>" "Airport" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<city>" "City" chartitem not contains "<airport>" "Airport" chartitem
#    And I delete "<city>" "City" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<country>" "Country" chartitem not contains "<city>" "City" chartitem
#    And I delete "<country>" "Country" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<region>" "Region" chartitem not contains "<country>" "Country" chartitem
#    And I delete "<region>" "Region" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<continent>" "Continent" chartitem not contains "<region>" "Region" chartitem
#    And I delete "<continent>" "Continent" chartitem
#    And I press button "OK" on Confirmation dialog
#    And I see "<organisation>" "Organisation" chartitem not contains "<continent>" "Continent" chartitem
#    And I`m on a homepage
#    And I enter in a text field called 'Enter search text' following text "<customer>"
#    And I delete record "<customer>"
#    And I press button "OK" on Confirmation dialog
#
#    Examples:
#      | organisation                        | continent | region | country | city    | airport | customer       |
#      | Chapman Freeborn Group of Companies | Europe    | Europe | UKRAINE | Kharkov | HRK     | Alex Expolanka |
#
