package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.AutomationException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PatientInformationVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;
    private static final String SCREENSHOT_PATH = "target/screenshots";

    // Static XPaths for patient tab, input fields, and patient information fields
    public static final By PATIENT_TAB = By.xpath("//*[@id='router-wrapper']/div/div[1]/div[1]/button[2]");
    public static final By PATIENT_ID_INPUT = By.xpath("//input[@type='search']");
    public static final By NAME_INPUT = By.xpath("//div[contains(@class,'__patientName___3tbx5') and contains(@class, '__trimtext___1PFDy')]");
    public static final By PATIENT_INFO_DIV = By.xpath("//*[@id='router-wrapper']/div/div[2]/div/div[4]/div/div[5]/div/div/div[2]");

    // Static XPaths for patient information fields based on label and input association
    public static final By FIRST_NAME_LABEL = By.xpath("//label[text()='First Name']");
    public static final By LAST_NAME_LABEL = By.xpath("//label[text()='Last Name']");
    public static final By DOB_INPUT = By.xpath("//input[@name='birthDate']");
    public static final By SEX_LABEL = By.xpath("//label[text()='Sex']");
    public static final By ADDRESS1_LABEL = By.xpath("//label[text()='Address 1']");
    public static final By ADDRESS2_LABEL = By.xpath("//label[text()='Address 2']");
    public static final By ZIP_CODE_LABEL = By.xpath("//label[text()='Zip Code']");
    public static final By EMAIL_LABEL = By.xpath("//label[text()='Email']");
    public static final By CITY_LABEL = By.xpath("//label[text()='City']");
    public static final By PREFERRED_PHONE_LABEL = By.xpath("//label[text()='Preferred Phone']");

    // Constructor
    public PatientInformationVerificationPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait of 10 seconds
        this.test = test;
    }

    // Method to click on the patient tab
    public void clickPatientTab() throws AutomationException {
        try {
            driver.findElement(PATIENT_TAB).click();
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Failed to click on Patient Tab", e);
        }
    }

    // Method to enter patient ID
    public void enterPatientId(String patientId) throws AutomationException {
        try {
            WebElement inputField = driver.findElement(PATIENT_ID_INPUT);
            inputField.clear();
            inputField.sendKeys(patientId);
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Failed to enter Patient ID: " + patientId, e);
        }
    }

    // Method to wait for patient details page to load
    public void waitForPatientDetailsToLoad() throws AutomationException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(PATIENT_INFO_DIV));
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Patient details did not load properly", e);
        }
    }

    // Methods to retrieve patient information fields with AutomationException handling
    public String getFirstName() throws AutomationException {
        return getAttributeValue(FIRST_NAME_LABEL, "First Name");
    }

    public String getLastName() throws AutomationException {
        return getAttributeValue(LAST_NAME_LABEL, "Last Name");
    }

    public String getDob() throws AutomationException {
        try {
            WebElement input = driver.findElement(DOB_INPUT);
            return input.getAttribute("value");
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Failed to retrieve DOB", e);
        }
    }

    public String getSex() throws AutomationException {
        return getAttributeValue(SEX_LABEL, "Sex");
    }

    public String getAddress1() throws AutomationException {
        return getAttributeValue(ADDRESS1_LABEL, "Address 1");
    }

    public String getAddress2() throws AutomationException {
        return getAttributeValue(ADDRESS2_LABEL, "Address 2");
    }

    public String getZipCode() throws AutomationException {
        return getAttributeValue(ZIP_CODE_LABEL, "Zip Code");
    }

    public String getEmail() throws AutomationException {
        return getAttributeValue(EMAIL_LABEL, "Email");
    }

    public String getCity() throws AutomationException {
        return getAttributeValue(CITY_LABEL, "City");
    }

    public String getPreferredPhone() throws AutomationException {
        return getAttributeValue(PREFERRED_PHONE_LABEL, "Preferred Phone");
    }

    // Helper method to retrieve input field values associated with labels
    private String getAttributeValue(By labelLocator, String fieldName) throws AutomationException {
        try {
            WebElement label = driver.findElement(labelLocator);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Failed to retrieve " + fieldName, e);
        }
    }

    // New method: verify patient details
    public void verifyPatientDetails(Map<String, String> patientData) throws AutomationException {
        try {
            verifyField("First Name", patientData.get("FirstName"), getFirstName());
            verifyField("Last Name", patientData.get("LastName"), getLastName());
            verifyField("DOB", patientData.get("DOB"), getDob());
            verifyField("Address 1", patientData.get("Address1"), getAddress1());
            verifyField("Address 2", patientData.get("Address2"), getAddress2());
            verifyField("Preferred Phone", patientData.get("PreferredPhone"), getPreferredPhone());
            verifyField("Email", patientData.get("Email"), getEmail());
            verifyField("Zip Code", patientData.get("ZipCode"), getZipCode());
            verifyField("City", patientData.get("City"), getCity());
            verifyField("Sex", patientData.get("Sex"), getSex());
        } catch (Exception e) {
            captureScreenshotOnFailure();
            throw new AutomationException("Error verifying patient details", e);
        }
    }

    // Helper method for field verification
    private void verifyField(String fieldName, String expectedValue, String actualValue) {
        if (expectedValue != null && !expectedValue.isEmpty() && actualValue != null && !actualValue.isEmpty()) {
            assertEquals(expectedValue, actualValue);
            test.log(Status.PASS, fieldName + " matches: " + expectedValue);
        } else {
            test.log(Status.INFO, fieldName + " is empty, skipping verification.");
        }
    }

    // Helper method to capture screenshots on failure
    private void captureScreenshotOnFailure() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Ensure target screenshot directory exists
            Files.createDirectories(Paths.get(SCREENSHOT_PATH));

            // Construct the destination path
            String destinationPath = SCREENSHOT_PATH + "/screenshot_" + System.currentTimeMillis() + ".png";
            File destination = new File(destinationPath);

            // Copy screenshot to destination
            Files.copy(screenshotFile.toPath(), destination.toPath());

            // Log the screenshot in the Extent report
            test.fail("Failure screenshot", MediaEntityBuilder.createScreenCaptureFromPath(destination.getPath()).build());

        } catch (IOException ioException) {
            // Detailed logging for the failure to capture screenshot
            test.fail("Failed to capture screenshot: " + ioException.getMessage());
            ioException.printStackTrace();  // Print stack trace to help diagnose the problem
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            test.fail("An unexpected error occurred while capturing the screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
