package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PatientInformationVerificationPage;
import utility.AutomationException;
import utility.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Map;

public class PatientInformationVerificationStep {

    private WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    private PatientInformationVerificationPage patientPage;
    private static ExtentReports extent;
    private ExtentTest test;

    @Before
    public void setUp() throws AutomationException {
        try {
            // Set up Extent Reports
            if (extent == null) {
                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/reports/PatientInformationVerificationReport.html");
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);
            }
            test = extent.createTest("Patient Information Verification Test");

            // Initialize the patient page with ExtentTest
            patientPage = new PatientInformationVerificationPage(driver, test);

            // Log in to the system
            driver.get("https://pharmacist-dev.arine.io");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
        } catch (Exception e) {
            throw new AutomationException("Failed during setup: " + e.getMessage(), e);
        }
    }

    @When("^click on patient tab$")
    public void click_on_patient_tab() throws AutomationException {
        patientPage.clickPatientTab();
    }

    @And("^user enters patient id (.*)$")
    public void user_enters_patient_id(String patientId) throws AutomationException {
        patientPage.enterPatientId(patientId);
        patientPage.waitForPatientDetailsToLoad();
    }

    @Then("^user verifies patient details$")
    public void user_verifies_patient_details(Map<String, String> patientData) throws AutomationException {
        patientPage.verifyPatientDetails(patientData);
    }

    @After
    public void tearDown() throws AutomationException {
        try {
            // Finalize and flush Extent Report
            extent.flush();
            driver.quit();
        } catch (Exception e) {
            throw new AutomationException("Failed during tearDown: " + e.getMessage(), e);
        }
    }
}
