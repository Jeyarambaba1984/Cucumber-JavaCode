Feature: Proof of Concept

  Scenario: Sample Scenario Automating CAE Application

    Given I open "CAE" Application using given Browser
      | BrowserType |Option1|Option2      |Option3      |
      | IE32        |Hover  |ProtectedMode|clean session|
    When I enter "LakshmiB" in "Username textbox" in "LoginPage"
      And I enter "Appa102*" in "Password textbox" in "LoginPage"
      And I click on "Login button" in "LoginPage"
   # When I switch to "Default frame" in "CAE" Application
    #And I click on "Search Image" in "LeftPanel"

