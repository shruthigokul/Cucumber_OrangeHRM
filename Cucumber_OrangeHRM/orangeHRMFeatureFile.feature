@tag
Feature: Scenarios to test OrangeHRM
	
	Background: User is logged in
		Given user is on orangeHRM page with url "http://alchemy.hguy.co/orangehrm"
	  When user enters id "orange" and password "orangepassword123"
	  Then user logs in
	
  @Scenario1
  Scenario: To create a job vacancy for “DevOps Engineer”
    Given User navigates to Recruitment page
    When User clicks on the Vacancies menu item
    And User clicks Add job vacancy button
    And user fills out Add Job Vacancy form with title "DevOps Engineer",vacany "Engineer3", manager "orange hrm"
    And User clicks save job vacancy button
    Then User checks if Vacancy with title "DevOps Engineer",vacanyID "1092", managerID "1670" is successfully created
    
  @Scenario2
  Scenario: Add information about a candidate for recruitment
    Given User navigates to Recruitment page
    When User clicks Add Candidate button
    And User fills out candidate details with firstName "Har", lastName "App", email "har@aaa.com"
    And User uploads resume
    And User clicks save candidate button
    Then User checks if candidate with name "Har App" was saved
    
  @Scenario3
  Scenario Outline: Add Employee information
    Given User navigates to PIM page
    When User clicks Add Employee button
    And User fills out employee details with firstName "<firstName>", lastName "<lastName>"
    And User checks Create Login Details
    And User fills out login details with userName "<userName>"
    And User clicks save employee button
    Then User checks if employee was added
    
  Examples: 
      | firstName  | lastName | userName  |
      | Har | App | HarApp |
      | Har1 | App1 | HarApp1 |
      
  @Scenario4
  Scenario Outline: To create multiple job vacancies
    Given User navigates to Recruitment page
    When User clicks on the Vacancies menu item
    And User clicks Add job vacancy button
    And user fills out Add Job Vacancy form with title "<title>",vacany "<vacany>", manager "<manager>"
    And User clicks save job vacancy button
    Then User checks if Vacancy with title "<title>",vacany "<vacany>", manager "<manager>" is successfully created

  Examples: 
      | title  | vacany | manager  |
      | DevOps Engineer | Engineer4 | orange hrm |
      | Android Developer | Engineer5 | SDET RESKILL |
    