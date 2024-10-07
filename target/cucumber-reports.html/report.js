$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/DragdropVerification.feature");
formatter.feature({
  "name": "Verify draggable table headings in the Patient Task",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify table heading drag functionality after login",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "DragDropStep.user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on patient tab",
  "keyword": "When "
});
formatter.match({
  "location": "DragDropStep.user_click_patient_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters patient ID \"da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9\"",
  "keyword": "And "
});
formatter.match({
  "location": "PatientStep.user_enters_the_patient_id(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the task tab",
  "keyword": "And "
});
formatter.match({
  "location": "DragDropStep.user_clicks_on_the_task_tab()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Failed to click on the task tab: Failed to click on the Task tab: element click intercepted: Element \u003cbutton class\u003d\"src-routes-PharmacistPortal-LandingPage-components-MenuBar-__regularButton___19gWx\" type\u003d\"button\"\u003e...\u003c/button\u003e is not clickable at point (32, 21). Other element would receive the click: \u003cdiv class\u003d\"src-components-Loading-__wrapper___20bLO\"\u003e...\u003c/div\u003e\n  (Session info: chrome\u003d129.0.6668.90)\nBuild info: version: \u00274.24.0\u0027, revision: \u0027748ffc9bc3\u0027\nSystem info: os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCommand: [245829409ffcbec20218f2b446fc3986, clickElement {id\u003df.AF631D5C33443C071E64A52ACD7A51AF.d.B35C11D956E8E7BE0440C27FFF7B30C8.e.84}]\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 129.0.6668.90, chrome: {chromedriverVersion: 129.0.6668.70 (df87d5cf12b1..., userDataDir: C:\\Users\\zaina\\AppData\\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:64786}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:64786/devtoo..., se:cdpVersion: 129.0.6668.90, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nElement: [[ChromeDriver: chrome on windows (245829409ffcbec20218f2b446fc3986)] -\u003e xpath: //button[text()\u003d\u0027Tasks\u0027]]\nSession ID: 245829409ffcbec20218f2b446fc3986\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat StepDefinition.DragDropStep.user_clicks_on_the_task_tab(DragDropStep.java:61)\r\n\tat ✽.User clicks on the task tab(src/test/java/features/DragdropVerification.feature:7)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});