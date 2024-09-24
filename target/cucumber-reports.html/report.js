$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Patient.feature");
formatter.feature({
  "name": "Patient Search Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search for a patient by ID and set a review date",
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
  "name": "User is logged in successfully for patient search",
  "keyword": "Given "
});
formatter.match({
  "location": "PatientStep.user_is_logged_in_successfully_for_patient_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the Patient button for patient search",
  "keyword": "When "
});
formatter.match({
  "location": "PatientStep.user_clicks_on_patient_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters the patient ID \"da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9\"",
  "keyword": "And "
});
formatter.match({
  "location": "PatientStep.user_enters_the_patient_id(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the Reports button",
  "keyword": "And "
});
formatter.match({
  "location": "PatientStep.user_clicks_on_reports_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User selects the date 10 days back",
  "keyword": "And "
});
formatter.match({
  "location": "PatientStep.user_selects_date_10_days_back()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the Date Converstion button",
  "keyword": "Then "
});
formatter.match({
  "location": "PatientStep.user_clicks_on_set_review_button()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});