$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("java/features/Sample.feature");
formatter.feature({
  "line": 1,
  "name": "Proof of Concept",
  "description": "",
  "id": "proof-of-concept",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Sample Scenario Automating CAE Application",
  "description": "",
  "id": "proof-of-concept;sample-scenario-automating-cae-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 5,
      "value": "#    Given I Navigate to Zoo Site"
    },
    {
      "line": 6,
      "value": "##Given I open IE Browser and Navigate to CAE Homepage"
    }
  ],
  "line": 7,
  "name": "I open CAE using Firefox Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I enter \"LakshmiB\" in \"Username textbox\" in \"LoginPage\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I enter \"Appa102*\" in \"Password textbox\" in \"LoginPage\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on \"Login button\" in \"LoginPage\"",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepdefs.iOpenCAEUsingFirefoxBrowser()"
});
formatter.result({
  "duration": 3674024282,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LakshmiB",
      "offset": 9
    },
    {
      "val": "Username textbox",
      "offset": 23
    },
    {
      "val": "LoginPage",
      "offset": 45
    }
  ],
  "location": "MyStepdefs.iEnterInIn(String,String,String)"
});
formatter.result({
  "duration": 142436748,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Appa102*",
      "offset": 9
    },
    {
      "val": "Password textbox",
      "offset": 23
    },
    {
      "val": "LoginPage",
      "offset": 45
    }
  ],
  "location": "MyStepdefs.iEnterInIn(String,String,String)"
});
formatter.result({
  "duration": 74891851,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login button",
      "offset": 12
    },
    {
      "val": "LoginPage",
      "offset": 30
    }
  ],
  "location": "MyStepdefs.iClickOnIn(String,String)"
});
formatter.result({
  "duration": 144971568,
  "status": "passed"
});
});