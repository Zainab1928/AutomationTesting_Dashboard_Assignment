package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PatientPage;
import utility.DriverFactory;
import utility.AutomationException;
public class PatientStep {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    PatientPage patientPage = new PatientPage(driver);
    DashboardStep dashboardStep = new DashboardStep();  // Reusing DashboardStep


    @Given("^User is logged in successfully with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_logged_in_successfully_for_patient_search_with_credentials(String username, String password) throws AutomationException {
        try {
            driver.get("https://pharmacist-dev.arine.io/");
            loginPage.enterEmail(username);
            loginPage.enterPassword(password);
            loginPage.clickSignIn();
        } catch (Exception e) {
            throw new AutomationException("Login failed for patient search: " + e.getMessage(), e);
        }
    }

    @When("^User clicks on the Patient button for patient search$")
    public void user_clicks_on_patient_button() throws AutomationException {
        try {
            dashboardStep.user_clicks_on_patient_button();
        } catch (Exception e) {
            throw new AutomationException("Failed to click on the Patient button: " + e.getMessage(), e);
        }
    }

    @When("^User enters patient ID \"([^\"]*)\"$")
    public void user_enters_the_patient_id(String patientId) throws AutomationException {
        try {
            patientPage.enterPatientID(patientId);
        } catch (Exception e) {
            throw new AutomationException("Failed to enter Patient ID: " + e.getMessage(), e);
        }
    }

    @When("^User clicks on the Reports button$")
    public void user_clicks_on_reports_button() throws AutomationException {
        try {
            patientPage.clickReportsButton();
        } catch (Exception e) {
            throw new AutomationException("Failed to click on Reports button: " + e.getMessage(), e);
        }
    }

    @When("^User selects the date 10 days back$")
    public void user_selects_date_10_days_back() throws AutomationException {
        try {
            patientPage.selectDate10DaysBack();
        } catch (Exception e) {
            throw new AutomationException("Failed to select the date 10 days back: " + e.getMessage(), e);
        }
    }

    @Then("^User clicks on the Date Converstion button$")
    public void user_clicks_on_the_Date_Conversion_button() throws AutomationException {
        try {
            patientPage.clickSetReviewButton();
        } catch (Exception e) {
            throw new AutomationException("Failed to click on Date Conversion button: " + e.getMessage(), e);
        }
    }

    @And("^User logs out of the application$")
    public void user_logs_out_of_the_application() throws AutomationException {
        try {
            patientPage.logout();  // Call the combined logout method
        } catch (Exception e) {
            throw new AutomationException("Failed to log out: " + e.getMessage(), e);
        }
    }

    @Then("^User close browser$")
    public void user_close_browser() throws AutomationException {
        try {
            driver.quit();  // Close the browser
        } catch (Exception e) {
            throw new AutomationException("Failed to close the browser: " + e.getMessage(), e);
        }
    }
}
