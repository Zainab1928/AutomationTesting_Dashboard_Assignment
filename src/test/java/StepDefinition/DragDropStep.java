package StepDefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DragDropPage;
import pages.LoginPage;
import utility.AutomationException;
import utility.DriverFactory;

public class DragDropStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private DragDropPage dragAndDropPage;


    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        dragAndDropPage = new DragDropPage(driver);
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
    public void user_click_patient_button() throws AutomationException {
        DragDropPage.clickPatient();
    }

    @And("^User enters the patient ID \"([^\"]*)\"$")
    public void user_enter_patient_id(String patientId) throws AutomationException {
        try {
            DragDropPage.enterPatientID(patientId);
        } catch (Exception e) {
            throw new AutomationException("Failed to enter Patient ID: " + e.getMessage(), e);
        }
    }

    @When("User clicks on the task tab")
    public void user_clicks_on_the_task_tab() {
        try {
            dragAndDropPage.clickTaskTab();  // Click on the task tab
        } catch (AutomationException e) {
            Assert.fail("Failed to click on the task tab: " + e.getMessage());
        }
    }

    @When("User drags the {string} and drops it on {string}")
    public void user_drags_the_and_drops_it_on(String column1, String column2) {
        dragAndDropPage.dragAndDrop(column1, column2);
    }

    @Then("The new column index sequence should be:")
    public void the_new_column_index_sequence_should_be(DataTable expectedTable) {
        dragAndDropPage.validateColumns(expectedTable);
    }

    @When("User drags the {string} and drops it on {string} from show hide section")
    public void userDragsTheAndDropsItOnFromShowHideSection(String column1, String column2) {
        dragAndDropPage.clicksThreeDotAndShowHideButton();
        dragAndDropPage.dragAndDropInList(column1, column2);
    }

    @Then("The new column index sequence in a list should be:")
    public void theNewColumnIndexSequenceInAListShouldBe(DataTable expectedTable) throws InterruptedException {
        dragAndDropPage.validateList(expectedTable);
    }

    @And("User clicks on Reset Button")
    public void userClicksOnResetButton() {
        dragAndDropPage.clickResetButton();
    }
}
