package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.PatientInformationVerificationPage;
import utility.AutomationException;
import utility.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PatientInformationVerificationStep {

    private WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    private PatientInformationVerificationPage patientPage = PageFactory.initElements(driver, PatientInformationVerificationPage.class);
    private static ExtentReports extent;
    private ExtentTest test;
    private static final String SCREENSHOT_PATH = "target/screenshots";

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

            // Log in to the system
            driver.get("https://pharmacist-dev.arine.io");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
        } catch (Exception e) {
            captureScreenshotOnFailure(test);
            throw new AutomationException("Failed during setup: " + e.getMessage(), e);
        }
    }

    @When("^click on patient tab$")
    public void click_on_patient_tab() throws AutomationException {
        try {
            patientPage.clickPatientTab();
        } catch (Exception e) {
            captureScreenshotOnFailure(test);
            throw new AutomationException("Failed to click on patient tab", e);
        }
    }

    @And("^search patient: \"([^\"]*)\"$")
    public void search_patient(String patientId) throws AutomationException {
        try {
            patientPage.enterPatientId(patientId);
            patientPage.waitForPatientDetailsToLoad();
        } catch (Exception e) {
            captureScreenshotOnFailure(test);
            throw new AutomationException("Failed to search patient with ID: " + patientId, e);
        }
    }

    @Then("^user verifies the patient details from patient info with provided info:$")
    public void user_verifies_patient_details(Map<String, String> patientData) throws AutomationException {
        try {
            // Check First Name
            String expectedFirstName = patientData.get("FirstName");
            String actualFirstName = patientPage.getFirstName();
            if (expectedFirstName != null && !expectedFirstName.isEmpty() && actualFirstName != null && !actualFirstName.isEmpty()) {
                assertEquals(expectedFirstName, actualFirstName);
                test.log(Status.PASS, "First Name matches: " + expectedFirstName);
            } else {
                test.log(Status.INFO, "First Name is empty, skipping verification.");
            }

            // Check Last Name
            String expectedLastName = patientData.get("LastName");
            String actualLastName = patientPage.getLastName();
            if (expectedLastName != null && !expectedLastName.isEmpty() && actualLastName != null && !actualLastName.isEmpty()) {
                assertEquals(expectedLastName, actualLastName);
                test.log(Status.PASS, "Last Name matches: " + expectedLastName);
            } else {
                test.log(Status.INFO, "Last Name is empty, skipping verification.");
            }

            // Check DOB
            String expectedDob = patientData.get("DOB");
            String actualDob = patientPage.getDob();
            if (expectedDob != null && !expectedDob.isEmpty() && actualDob != null && !actualDob.isEmpty()) {
                assertEquals(expectedDob, actualDob);
                test.log(Status.PASS, "DOB matches: " + expectedDob);
            } else {
                test.log(Status.INFO, "DOB is empty, skipping verification.");
            }

            // Check Address 1
            String expectedAddress1 = patientData.get("Address1");
            String actualAddress1 = patientPage.getAddress1();
            if (expectedAddress1 != null && !expectedAddress1.isEmpty() && actualAddress1 != null && !actualAddress1.isEmpty()) {
                assertEquals(expectedAddress1, actualAddress1);
                test.log(Status.PASS, "Address 1 matches: " + expectedAddress1);
            } else {
                test.log(Status.INFO, "Address 1 is empty, skipping verification.");
            }

            // Check Address 2
            String expectedAddress2 = patientData.get("Address2");
            String actualAddress2 = patientPage.getAddress2();
            if (expectedAddress2 != null && !expectedAddress2.isEmpty() && actualAddress2 != null && !actualAddress2.isEmpty()) {
                assertEquals(expectedAddress2, actualAddress2);
                test.log(Status.PASS, "Address 2 matches: " + expectedAddress2);
            } else {
                test.log(Status.INFO, "Address 2 is empty, skipping verification.");
            }

            // Check Preferred Phone
            String expectedPreferredPhone = patientData.get("PreferredPhone");
            String actualPreferredPhone = patientPage.getPreferredPhone();
            if (expectedPreferredPhone != null && !expectedPreferredPhone.isEmpty() && actualPreferredPhone != null && !actualPreferredPhone.isEmpty()) {
                assertEquals(expectedPreferredPhone, actualPreferredPhone);
                test.log(Status.PASS, "Preferred Phone matches: " + expectedPreferredPhone);
            } else {
                test.log(Status.INFO, "Preferred Phone is empty, skipping verification.");
            }

            // Check Email
            String expectedEmail = patientData.get("Email");
            String actualEmail = patientPage.getEmail();
            if (expectedEmail != null && !expectedEmail.isEmpty() && actualEmail != null && !actualEmail.isEmpty()) {
                assertEquals(expectedEmail, actualEmail);
                test.log(Status.PASS, "Email matches: " + expectedEmail);
            } else {
                test.log(Status.INFO, "Email is empty, skipping verification.");
            }

            // Check Zip Code
            String expectedZipCode = patientData.get("ZipCode");
            String actualZipCode = patientPage.getZipCode();
            if (expectedZipCode != null && !expectedZipCode.isEmpty() && actualZipCode != null && !actualZipCode.isEmpty()) {
                assertEquals(expectedZipCode, actualZipCode);
                test.log(Status.PASS, "Zip Code matches: " + expectedZipCode);
            } else {
                test.log(Status.INFO, "Zip Code is empty, skipping verification.");
            }

            // Check City
            String expectedCity = patientData.get("City");
            String actualCity = patientPage.getCity();
            if (expectedCity != null && !expectedCity.isEmpty() && actualCity != null && !actualCity.isEmpty()) {
                assertEquals(expectedCity, actualCity);
                test.log(Status.PASS, "City matches: " + expectedCity);
            } else {
                test.log(Status.INFO, "City is empty, skipping verification.");
            }

            // Check Sex
            String expectedSex = patientData.get("Sex");
            String actualSex = patientPage.getSex();
            if (expectedSex != null && !expectedSex.isEmpty() && actualSex != null && !actualSex.isEmpty()) {
                assertEquals(expectedSex, actualSex);
                test.log(Status.PASS, "Sex matches: " + expectedSex);
            } else {
                test.log(Status.INFO, "Sex is empty, skipping verification.");
            }

        } catch (Exception e) {
            captureScreenshotOnFailure(test);
            throw new AutomationException("Patient detail verification encountered an error", e);
        }
    }

    @After
    public void tearDown() {
        if (extent != null) {
            extent.flush();
        }
        driver.quit();
    }

    // Capture a screenshot and attach it to the Extent Report
    private static void captureScreenshotOnFailure(ExtentTest test) {
        WebDriver driver = DriverFactory.getDriver(); // Get WebDriver instance
        TakesScreenshot ts = (TakesScreenshot) driver;
        String screenshotFileName = "screenshot_" + System.currentTimeMillis() + ".png";
        String screenshotFilePath = SCREENSHOT_PATH + "/" + screenshotFileName;

        try {
            // Capture screenshot and save it to file
            File source = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), Paths.get(screenshotFilePath));

            // Use the relative path from the report to the screenshots folder
            String relativeScreenshotPath = "screenshots/" + screenshotFileName;

            // Attach screenshot to report using relative path for better compatibility
            test.fail("Screenshot of failure:",
                    MediaEntityBuilder.createScreenCaptureFromPath(relativeScreenshotPath).build());

        } catch (IOException e) {
            test.fail("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
