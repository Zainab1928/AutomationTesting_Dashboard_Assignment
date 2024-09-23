$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/dashboard.feature");
formatter.feature({
  "name": "Dashboard Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify birthdate input with invalid format and show error",
  "description": "",
  "keyword": "Scenario"
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
  "name": "User enters \"01/01/1965\" in the birthdate field",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStep.user_enters_birthdate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Invalid birthdate error popup should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStep.invalid_birthdate_error_popup_should_be_displayed()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Error popup not found or failed to verify: Expected condition failed: waiting for visibility of element located by By.xpath: //div[contains(@class, \u0027swal2-popup\u0027)] (tried for 20 second(s) with 500 milliseconds interval)\nBuild info: version: \u00274.24.0\u0027, revision: \u0027748ffc9bc3\u0027\nSystem info: os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 128.0.6613.138, chrome: {chromedriverVersion: 127.0.6533.99 (f31af5097d90..., userDataDir: C:\\Users\\zaina\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:60977}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:60977/devtoo..., se:cdpVersion: 128.0.6613.138, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 49cf01469817ad827bc780287a8aa011\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat pages.DashboardPage.verifyInvalidBirthdateError(DashboardPage.java:145)\r\n\tat StepDefinition.DashboardStep.invalid_birthdate_error_popup_should_be_displayed(DashboardStep.java:134)\r\n\tat ✽.Invalid birthdate error popup should be displayed(src/test/java/features/dashboard.feature:43)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});