package StepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages.LoginPage;
import pages.DragDropPage;
import utility.DriverFactory;
import utility.AutomationException;
import org.testng.Assert;

public class DragDropStep {
    WebDriver driver;
    LoginPage loginPage;
    DragDropPage dragDropPage;  // Ensure it's named consistently

    // Create an instance of DashboardStep for patient button click
    DashboardStep dashboardStep;

    // @Before Hook to initialize driver and pages before each scenario
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        dragDropPage = new DragDropPage(driver);  // Ensure it's initialized
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("https://pharmacist-dev.arine.io/");
        loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
        loginPage.enterPassword("Password1#");
        loginPage.clickSignIn();
        // Verify successful login
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Login failed, dashboard not displayed.");
    }

    @When("^User clicks on patient tab$")
    public void user_click_patient_button()throws AutomationException {
        DragDropPage.clickPatient();
    }

    @And("^User enters the patient ID \"([^\"]*)\"$")
    public void user_enterpatient_id(String patientId) throws AutomationException {
        try {
            DragDropPage.PatientID(patientId);
        } catch (Exception e) {
            throw new AutomationException("Failed to enter Patient ID: " + e.getMessage(), e);
        }
    }

    @When("User clicks on the task tab")
    public void user_clicks_on_the_task_tab() {
        try {
            dragDropPage.clickTaskTab();  // Click on the task tab
        } catch (AutomationException e) {
            Assert.fail("Failed to click on the task tab: " + e.getMessage());
        }
    }

    @Then("User verifies that the table headings are draggable")
    public void user_verifies_that_the_table_headings_are_draggable() {
        try {
            dragDropPage.verifyDraggableTableHeaders();  // Verify draggable headers
        } catch (AutomationException e) {
            Assert.fail("Failed to verify draggable table headings: " + e.getMessage());
        }
    }
}
