package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages.LoginPage;
import utility.DriverFactory;

public class LoginStep {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        // Using DriverFactory to get the WebDriver instance
        driver = DriverFactory.getDriver();
        driver.get("https://pharmacist-dev.arine.io/");  // Update to your URL
        loginPage = new LoginPage(driver);
    }

    @When("User enters email {string}")
    public void user_enters_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks on the Sign In button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.clickSignIn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Verifying if the dashboard is displayed
        boolean isDashboardDisplayed = loginPage.isDashboardDisplayed();
        Assert.assertTrue(isDashboardDisplayed, "Dashboard is not displayed. Login might have failed.");

        // Scroll to the bottom of the page
       // loginPage.scrollToEndOfPage();

        // Click on the Accept button
        //loginPage.clickAcceptButton();

        // Quit the browser after the test
        DriverFactory.closeDriver();
    }
}
