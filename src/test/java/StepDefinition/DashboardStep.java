package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import utility.DriverFactory;
import utility.ExtentReportUtil;

public class DashboardStep {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Before
    public void setUp() {
        ExtentReportUtil.initExtentReport();
    }

    @Given("^User is logged in successfully$")
    public void user_is_logged_in_successfully() {
        ExtentReportUtil.startTest("Dashboard Test Case");
        try {
            driver.get("https://pharmacist-dev.arine.io/");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
            boolean isDashboardDisplayed = loginPage.isDashboardDisplayed();
            Assert.assertTrue(isDashboardDisplayed, "Login was not successful");
            ExtentReportUtil.logPass("User logged in successfully.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Login failed: " + e.getMessage());
            throw e; // Re-throw exception to fail the test
        }
    }

    @When("^User clicks on the Patient button$")
    public void user_clicks_on_patient_button() {
        try {
            dashboardPage.clickPatientButton();
            ExtentReportUtil.logPass("User clicked on the Patient button.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on the Patient button: " + e.getMessage());
            throw e;
        }
    }

    @Then("^User clicks on the Advanced button$")
    public void user_clicks_on_advanced_button() {
        try {
            dashboardPage.clickAdvancedButton();
            ExtentReportUtil.logPass("User clicked on the Advanced button.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on the Advanced button: " + e.getMessage());
            throw e;
        }
    }

    @Then("^User enters \"([^\"]*)\" in the firstname field$")
    public void user_enters_firstname(String firstname) {
        try {
            dashboardPage.enterFirstname(firstname);
            ExtentReportUtil.logPass("User entered '" + firstname + "' in the firstname field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter firstname: " + e.getMessage());
            throw e;
        }
    }

    @Then("^User enters \"([^\"]*)\" in the lastname field$")
    public void user_enters_lastname(String lastname) {
        try {
            dashboardPage.enterLastname(lastname);
            ExtentReportUtil.logPass("User entered '" + lastname + "' in the lastname field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter lastname: " + e.getMessage());
            throw e;
        }
    }

    @Then("^User enters \"([^\"]*)\" in the city field$")
    public void user_enters_city(String city) {
        try {
            dashboardPage.enterCity(city);
            ExtentReportUtil.logPass("User entered '" + city + "' in the city field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter city: " + e.getMessage());
            throw e;
        }
    }

    //verify error alert message when enter invalid zipcode and click on search button
    @Then("^User enters \"([^\"]*)\" in the zipcode field$")
    public void user_enters_zipcode(String zipcode) {
        try {
            dashboardPage.enterZipcode(zipcode);
            ExtentReportUtil.logPass("User entered '" + zipcode + "' in the zipcode field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter zipcode: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Error popup with message \"([^\"]*)\" should be displayed$")
    public void error_popup_with_message_should_be_displayed(String expectedMessage) {
        try {
            dashboardPage.verifyZipCodeErrorPopupDisplay(expectedMessage);
            ExtentReportUtil.logPass("Error popup displayed with expected message: " + expectedMessage);
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Error popup did not display: " + expectedMessage);
            throw e;
        }
    }


    //verify tooltip message when provide invalid zipcode
    @Then("^User enters \"([^\"]*)\" in the zipcode field and submits$")
    public void user_enters_invalid_zipcode_and_submits(String zipcode) {
        try {
            dashboardPage.enterInvalidZipcode(zipcode);
            ExtentReportUtil.logPass("User entered '" + zipcode + "' in the zipcode field and clicked submit.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter zipcode and submit search: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Tooltip with message \"([^\"]*)\" should be displayed$")
    public void tooltip_with_message_should_be_displayed(String expectedTooltipMessage) {
        try {
            dashboardPage.verifyTooltipMessage(expectedTooltipMessage);
            ExtentReportUtil.logPass("Tooltip displayed with expected message: " + expectedTooltipMessage);
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Tooltip did not display as expected: " + expectedTooltipMessage);
            throw e;
        }
    }

    //verify tooltip message when provide invalid phoneno
    @Then("^User enters \"([^\"]*)\" in the phoneno field and submits$")
    public void user_enters_invalid_phoneno_and_submits(String phoneno) {
        try {
            dashboardPage.enterInvalidPhoneno(phoneno);
            ExtentReportUtil.logPass("User entered '" + phoneno + "' in the phoneno field and clicked submit.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter phoneno and submit search: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Tooltip for phoneno with message \"([^\"]*)\" should be displayed$")
    public void tooltip_with_message_should_be_displayed_for_phoneno(String expectedTooltipMessage) {

        try {
            dashboardPage.verifyTooltipMessageForPhone(expectedTooltipMessage);
            ExtentReportUtil.logPass("Tooltip displayed with expected message: " + expectedTooltipMessage);
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Tooltip did not display as expected: " + expectedTooltipMessage);
            throw e;
        }
    }


    //verify tooltip message when provide invalid birthdate
    @Then("^User enters \"(\\d{2}-\\d{3}-\\d{2})\" in the birthdate field and submits$")
    public void user_enters_invalid_birthdate_and_submits(String birthdate) {
        try {
            dashboardPage.enterInvalidbirthdate(birthdate);
            ExtentReportUtil.logPass("User entered '" + birthdate + "' in the birthdate field and clicked submit.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter birthdate and submit search: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Tooltip for birthdate with message \"([^\"]*)\" should be displayed$")
    public void tooltip_with_message_should_be_displayed_for_birthdate(String expectedTooltipMessage) {

        try {
            dashboardPage.verifyTooltipMessageForBirthdate(expectedTooltipMessage);
            ExtentReportUtil.logPass("Tooltip displayed with expected message: " + expectedTooltipMessage);
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Tooltip did not display as expected: " + expectedTooltipMessage);
            throw e;
        }
    }

    //verify error alert message when enter invalid birthdate and click on search button
    @Then("^User enters \"([^\"]*)\" in the birthdate field$")
    public void user_enters_birthdate(String birthdate) {
        try {
            dashboardPage.enterBirthdate(birthdate);
            ExtentReportUtil.logPass("User entered '" + birthdate + "' in the birthdate field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter birthdate: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Invalid birthdate error popup should be displayed$")
    public void invalid_birthdate_error_popup_should_be_displayed() {
        try {
            dashboardPage.verifyInvalidBirthdateError();
            ExtentReportUtil.logPass("Invalid birthdate error popup displayed as expected.");
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Invalid birthdate error popup did not display as expected.");
            throw e;
        }
    }

    //verify error alert message when enter invalid mobile number and click on search button
    @Then("^User enters \"([^\"]*)\" in the mobile number field$")
    public void user_enters_mobile_number(String mobileNumber) {
        try {
            dashboardPage.enterMobileNumber(mobileNumber);
            ExtentReportUtil.logPass("User entered '" + mobileNumber + "' in the mobile number field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter mobile number: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Error popup should be displayed with message \"([^\"]*)\"$")
    public void error_popup_should_be_displayed_with_message(String expectedMessage) {
        try {
            dashboardPage.verifyMobileNumberErrorPopupDisplayed();
            ExtentReportUtil.logPass("Error popup displayed with expected message: " + expectedMessage);
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Error popup did not display the expected message: " + expectedMessage);
            throw e;
        }
    }

    @Then("^User enters \"([^\"]*)\" in the state field$")
    public void user_enters_state(String state) {
        try {
            dashboardPage.enterState(state);
            ExtentReportUtil.logPass("User entered '" + state + "' in the state field.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter state: " + e.getMessage());
            throw e;
        }
    }

    @Then("^Error popup should be displayed$")
    public void error_popup_should_be_displayed() {
        try {
            dashboardPage.verifyErrorPopupDisplayed();
            ExtentReportUtil.logPass("Error popup displayed as expected.");
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Error popup did not display as expected.");
            throw e;
        }
    }

    @Then("^Patient record should be displayed$")
    public void patient_record_should_be_displayed() {
        try {
            dashboardPage.verifyPatientRecordDisplayed();
            ExtentReportUtil.logPass("Patient record is displayed as expected.");
        } catch (AssertionError e) {
            ExtentReportUtil.logFail("Patient record is not displayed.");
            throw e;
        }
    }

    @After
    public void tearDown() {
        ExtentReportUtil.flushReport(); // Flush report at the end of each scenario
        DriverFactory.closeDriver(); // Close the driver after the scenario
    }
}
