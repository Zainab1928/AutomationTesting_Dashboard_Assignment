package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    public static By emailField = By.xpath("//input[@name='email']");
    public static By passwordField = By.xpath("//input[@name='password']");
    public static By signInButton = By.xpath("//button[text()='Sign In']");
    public static By dashboardElement = By.xpath("//div[@id='dashboard']");  // Replace with a valid element after login
    public static By acceptButton = By.xpath("//button[contains(@class, 'swal2-confirm')]");  // Locator for "Accept" button

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust timeout as needed
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    // Check if dashboard is displayed
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
    }

    // Scroll to the end of the page
    //public void scrollToEndOfPage() {
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    //}

    // Click on the Accept button
    //public void clickAcceptButton() {
       // WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
       // acceptBtn.click();
    //}
}
