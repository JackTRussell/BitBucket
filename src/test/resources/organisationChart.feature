@Feature_organisationChart @ST_700178687
Feature: Organisation tree

@dragAndDrop @dragAndDrop_001 @High @SC_720051439
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

@dragAndDrop @dragAndDrop_002 @High @SC_720051440
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
