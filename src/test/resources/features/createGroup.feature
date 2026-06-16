@createGroup
Feature: groupCreation

  Scenario Outline: as a user I want to login to ndosi website as admin and create a group
    Given i am ndosi automation homepage
    And i click login button
    When i am on the login page
    And i enter admin email <email>
    And i enter admin password <password>
    When i click login submit button
    Then i should be logged in successfully as admin
    When i click on the menu button
    And i click admin panel
    Then i should be redirected to admin dashboard
    When i click groups
    And i click create new group button
    And i enter the group name <groupName>
    And i enter the group description <groupDescription>
    And i enter the year <year>
    And i enter the max capacity <maxCapacity>
    And i enter the start date <startDate>
    And i enter the end date <endDate>
    And i click create button
    Then the group should be created
    When i click back to website button
    And i click on the menu button
    And i click logout button
    And i click OK to confirm logout
    Then i should be logged out successfully
    When i click login button
    And i click sign up here hyperlink
    Then the created group "<groupName>" should exist in the group dropdown


    Examples:
      |email            | password  | groupName | groupDescription     | year | maxCapacity | startDate   | endDate      |
      |admin@gmail.com  | @12345678 | Class ACT7 | The best of the best | 2027 | 67          | 2027-08-01  |  2028-12-01  |



