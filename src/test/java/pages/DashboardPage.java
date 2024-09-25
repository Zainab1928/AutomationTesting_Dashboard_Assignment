package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for the buttons and input fields
    private By patientButton = By.xpath("//button[contains(text(),'Patient')]");
    private By advancedButton = By.xpath("//span[contains(@class, 'src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__advancedSearchIndicator___2ckHf') and text()='ADVANCED']");
    private By firstnameInput = By.xpath("//input[@name='firstname']");
    private By lastnameInput = By.xpath("//input[@name='lastname']");
    private By cityInput = By.xpath("//input[@name='city']");
    private By zipcodeInput = By.xpath("//input[@name='zip_code']");
    private By stateDropdown = By.xpath("//input[@name='state']"); // Locator for the state dropdown
    private By searchButton = By.xpath("//button[@class='src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__button___2AW2O']");
    private By patientRecordDiv = By.xpath("//div[contains(@class, 'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__drugSelectContainer___2eR2Q')]");
    private By errorPopup = By.xpath("//div[contains(@class, 'swal2-popup')]");
    private By okButton = By.xpath("//button[@class='swal2-confirm swal2-styled']");
    private By birthdateInput = By.xpath("//input[@name='dob']");

    private By mobileInput = By.xpath("//input[@name='phone']");

    private By submitSearchButton = By.xpath("//button[@type='submit' and @aria-label='search button']");
    private By tooltip = By.xpath("//div[contains(@class, '__react_component_tooltip')]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickPatientButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientButton)).click();
            wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
        } catch (Exception e) {
            Assert.fail("Patient button not found or clickable: " + e.getMessage());
        }
    }

    public void clickAdvancedButton() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(advancedButton)).click();
        } catch (Exception e) {
            Assert.fail("Advanced button not found or clickable: " + e.getMessage());
        }
    }

    public void enterFirstname(String firstname) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameInput)).sendKeys(firstname);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        } catch (Exception e) {
            Assert.fail("Firstname input field or search button not found: " + e.getMessage());
        }
    }

    public void enterLastname(String lastname) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(lastnameInput)).sendKeys(lastname);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        } catch (Exception e) {
            Assert.fail("Lastname input field or search button not found: " + e.getMessage());
        }
    }

    public void enterCity(String city) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput)).sendKeys(city);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        } catch (Exception e) {
            Assert.fail("City input field or search button not found: " + e.getMessage());
        }
    }

    public void enterZipcode(String zipcode) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeInput)).sendKeys(zipcode);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        } catch (Exception e) {
            Assert.fail("ZIP code input field or search button not found: " + e.getMessage());
        }
    }

    public void verifyZipCodeErrorPopupDisplay(String expectedMessage) {
        try {
            // Wait for the error popup and verify the message
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
            String actualMessage = popup.getText();
            Assert.assertTrue(actualMessage.contains(expectedMessage), "Error popup message mismatch. Expected: " + expectedMessage + ", but got: " + actualMessage);

            // Click the OK button on the popup
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        } catch (Exception e) {
            Assert.fail("Error popup or OK button not found: " + e.getMessage());
        }
    }

    //verify tooltip message when provide invalid zipcode
    public void enterInvalidZipcode(String zipcode) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeInput)).sendKeys(zipcode);
            wait.until(ExpectedConditions.elementToBeClickable(submitSearchButton)).click();
        } catch (Exception e) {
            Assert.fail("ZIP code input field or search button not found: " + e.getMessage());
        }
    }

    public void verifyTooltipMessage(String expectedMessage) {
        try {
            // Wait for the zipcode input field to be visible
            WebElement zipcodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeInput));

            // Check different attributes for the tooltip message
            String actualMessage = zipcodeElement.getAttribute("validationMessage");  // Use 'validationMessage' for HTML5 validation tooltips

            // Verify the tooltip message
            Assert.assertTrue(actualMessage.contains(expectedMessage),
                    "Tooltip message mismatch. Expected: " + expectedMessage + ", but got: " + actualMessage);

        } catch (Exception e) {
            Assert.fail("Tooltip not found or did not match expected message: " + e.getMessage());
        }
    }


    //verify tooltip message when provide invalid phoneno
    public void enterInvalidPhoneno(String phoneno) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput)).sendKeys(phoneno);
            wait.until(ExpectedConditions.elementToBeClickable(submitSearchButton)).click();
        } catch (Exception e) {
            Assert.fail("phoneno input field or search button not found: " + e.getMessage());
        }
    }

    public void verifyTooltipMessageForPhone(String expectedMessage) {
        try {
            // Wait for the phoneno input field to be visible
            WebElement phonenoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput));

            // Check different attributes for the tooltip message
            String actualMessage = phonenoElement.getAttribute("validationMessage");  // Use 'validationMessage' for HTML5 validation tooltips

            // Verify the tooltip message
            Assert.assertTrue(actualMessage.contains(expectedMessage),
                    "Tooltip message mismatch. Expected: " + expectedMessage + ", but got: " + actualMessage);

        } catch (Exception e) {
            Assert.fail("Tooltip not found or did not match expected message: " + e.getMessage());
        }
    }







    //verify tooltip message when provide invalid birthdate
    public void enterInvalidbirthdate(String birthdate) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(birthdateInput)).sendKeys(birthdate);
            wait.until(ExpectedConditions.elementToBeClickable(submitSearchButton)).click();
        } catch (Exception e) {
            Assert.fail("Birthdate input field or search button not found: " + e.getMessage());
        }
    }

    public void verifyTooltipMessageForBirthdate(String expectedMessage) {
        try {
            // Wait for the birthdate input field to be visible
            WebElement birthdateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(birthdateInput));

            // Check different attributes for the tooltip message
            String actualMessage = birthdateElement.getAttribute("validationMessage");  // Use 'validationMessage' for HTML5 validation tooltips

            // Verify the tooltip message
            Assert.assertTrue(actualMessage.contains(expectedMessage),
                    "Tooltip message mismatch. Expected: " + expectedMessage + ", but got: " + actualMessage);

        } catch (Exception e) {
            Assert.fail("Tooltip not found or did not match expected message: " + e.getMessage());
        }
    }












    public void enterState(String state) {
        try {
            WebElement stateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown));
            stateElement.click();
            stateElement.sendKeys(state);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); // Click search button
        } catch (Exception e) {
            Assert.fail("State dropdown or search button not found: " + e.getMessage());
        }
    }

    public void verifyErrorPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
            Assert.assertTrue(driver.findElement(errorPopup).isDisplayed(), "Error popup is not displayed.");
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        } catch (Exception e) {
            Assert.fail("Error popup not found: " + e.getMessage());
        }
    }

    // Method to enter birthdate and verify the error popup
    public void enterBirthdate(String birthdate) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(birthdateInput)).sendKeys(birthdate);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); // Click search button
        } catch (Exception e) {
            Assert.fail("Birthdate input field or search button not found: " + e.getMessage());
        }
    }

    public void verifyInvalidBirthdateError() {
        try {
            String expectedErrorMessage = "Birth date does not match the requested format";
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
            String actualErrorMessage = driver.findElement(errorPopup).getText();
            Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Error message is incorrect.");
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click(); // Click OK button
        } catch (Exception e) {
            Assert.fail("Error popup not found or failed to verify: " + e.getMessage());
        }
    }

    // Add method to enter invalid mobile number
    public void enterMobileNumber(String mobileNumber) {
        try {
            WebElement mobileInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInput));
            mobileInputElement.clear();  // Clear the field if needed
            mobileInputElement.sendKeys(mobileNumber);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click(); // Click search button
        } catch (Exception e) {
            Assert.fail("Mobile number input field or search button not found: " + e.getMessage());
        }
    }

    // Update error popup verification method to check for the mobile number error message
    public void verifyMobileNumberErrorPopupDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
            WebElement errorElement = driver.findElement(errorPopup);
            Assert.assertTrue(errorElement.isDisplayed(), "Error popup is not displayed.");
            Assert.assertTrue(errorElement.getText().contains("Phone number does not match the requested format"),
                    "Unexpected error message. Expected 'Phone number does not match the requested format'");
            wait.until(ExpectedConditions.elementToBeClickable(okButton)).click(); // Click OK button
        } catch (Exception e) {
            Assert.fail("Error popup or OK button not found: " + e.getMessage());
        }
    }

    public void verifyPatientRecordDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientRecordDiv));
            Assert.assertTrue(driver.findElement(patientRecordDiv).isDisplayed(), "Patient record is not displayed.");
        } catch (Exception e) {
            Assert.fail("Patient record div not found: " + e.getMessage());
        }
    }
}
