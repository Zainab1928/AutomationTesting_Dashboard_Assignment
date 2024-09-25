package StepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.PatientPage;
import utility.DriverFactory;
import utility.ExtentReportUtil;


import java.time.Duration;

public class PatientStep {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    PatientPage patientPage = new PatientPage(driver);
    DashboardStep dashboardStep = new DashboardStep();  // Reusing DashboardStep

    @Before
    public void setUp() {
        ExtentReportUtil.initExtentReport();
    }

    @Given("^User is logged in successfully for patient search$")
    public void user_is_logged_in_successfully_for_patient_search() {
        ExtentReportUtil.startTest("Patient Search Test Case");
        try {
            driver.get("https://pharmacist-dev.arine.io/");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
            boolean isDashboardDisplayed = loginPage.isDashboardDisplayed();
            Assert.assertTrue(isDashboardDisplayed, "Login was not successful");
            ExtentReportUtil.logPass("User logged in successfully for patient search.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Login failed for patient search: " + e.getMessage());
            throw e; // Re-throw exception to fail the test
        }
    }

    @When("^User clicks on the Patient button for patient search$")
    public void user_clicks_on_patient_button() {
        try {
            dashboardStep.user_clicks_on_patient_button();  // Reuse the function from DashboardStep
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on the Patient button: " + e.getMessage());
            throw e;
        }
    }

    @When("^User enters the patient ID \"([^\"]*)\"$")
    public void user_enters_the_patient_id(String patientId) {
        try {
            patientPage.enterPatientID(patientId);
            ExtentReportUtil.logPass("Patient ID entered: " + patientId);
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter Patient ID: " + e.getMessage());
            throw e;
        }
    }

    @When("^User clicks on the Reports button$")
    public void user_clicks_on_reports_button() {
        try {
            patientPage.clickReportsButton();
            ExtentReportUtil.logPass("Reports button clicked.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on Reports button: " + e.getMessage());
            throw e;
        }
    }

    @When("^User selects the date 10 days back$")
    public void user_selects_date_10_days_back() {
        try {
            patientPage.selectDate10DaysBack();
            ExtentReportUtil.logPass("Date 10 days back selected.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to select the date 10 days back: " + e.getMessage());
            throw e;
        }
    }

    @Then("^User clicks on the Date Converstion button$")
    public void user_clicks_on_set_review_button() {
        try {
            patientPage.clickSetReviewButton();
            ExtentReportUtil.logPass("Date Convertion button clicked.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on Date Converstion button: " + e.getMessage());
            throw e;
        }
    }
}
