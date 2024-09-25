$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/dashboard.feature");
formatter.feature({
  "name": "Dashboard Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the birthdate input and tooltip",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is logged in successfully",
  "keyword": "Given "
});
formatter.match({
  "location": "DashboardStep.user_is_logged_in_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the Patient button",
  "keyword": "When "
});
formatter.match({
  "location": "DashboardStep.user_clicks_on_patient_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the Advanced button",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStep.user_clicks_on_advanced_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"65-746-98\" in the birthdate field and submits",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStep.user_enters_invalid_birthdate_and_submits(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Tooltip for birthdate with message \"Please match the requested format\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStep.tooltip_with_message_should_be_displayed_for_birthdate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});