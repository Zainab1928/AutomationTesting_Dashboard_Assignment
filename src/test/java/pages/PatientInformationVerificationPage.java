package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.AutomationException;
import java.time.Duration;

public class PatientInformationVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

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
    public PatientInformationVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait of 10 seconds
    }

    // Method to click on the patient tab
    public void clickPatientTab() throws AutomationException {
        try {
            driver.findElement(PATIENT_TAB).click();
        } catch (Exception e) {
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
            throw new AutomationException("Failed to enter Patient ID: " + patientId, e);
        }
    }

    // Method to wait for patient details page to load
    public void waitForPatientDetailsToLoad() throws AutomationException {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(PATIENT_INFO_DIV));
        } catch (Exception e) {
            throw new AutomationException("Patient details did not load properly", e);
        }
    }

    // Methods to retrieve patient information fields with AutomationException handling
    public String getFirstName() throws AutomationException {
        try {
            WebElement label = driver.findElement(FIRST_NAME_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve First Name", e);
        }
    }

    public String getLastName() throws AutomationException {
        try {
            WebElement label = driver.findElement(LAST_NAME_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Last Name", e);
        }
    }

    public String getDob() throws AutomationException {
        try {
            WebElement input = driver.findElement(DOB_INPUT);
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve DOB", e);
        }
    }

    public String getSex() throws AutomationException {
        try {
            WebElement label = driver.findElement(SEX_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Sex", e);
        }
    }

    public String getAddress1() throws AutomationException {
        try {
            WebElement label = driver.findElement(ADDRESS1_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Address 1", e);
        }
    }

    public String getAddress2() throws AutomationException {
        try {
            WebElement label = driver.findElement(ADDRESS2_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Address 2", e);
        }
    }

    public String getZipCode() throws AutomationException {
        try {
            WebElement label = driver.findElement(ZIP_CODE_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Zip Code", e);
        }
    }

    public String getEmail() throws AutomationException {
        try {
            WebElement label = driver.findElement(EMAIL_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Email", e);
        }
    }

    public String getCity() throws AutomationException {
        try {
            WebElement label = driver.findElement(CITY_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve City", e);
        }
    }

    public String getPreferredPhone() throws AutomationException {
        try {
            WebElement label = driver.findElement(PREFERRED_PHONE_LABEL);
            WebElement input = label.findElement(By.xpath("./following-sibling::input"));
            return input.getAttribute("value");
        } catch (Exception e) {
            throw new AutomationException("Failed to retrieve Preferred Phone", e);
        }
    }
}
