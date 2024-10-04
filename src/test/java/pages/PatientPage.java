package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientPage {
    private WebDriver driver;
    private WebDriverWait wait;


    // Locators
    public static final String PATIENT_ID_INPUT = "//input[@type='search']";
    public static final String REPORTS_BUTTON = "//div[contains(text(),'Reports')]";
    public static final String CALENDAR_INPUT = "//input[@name='conversationDate']";
    public static final String SET_REVIEW_BUTTON = "//button[contains(@class, 'src-routes-PharmacistPortal-LandingPage-components-composites-ViewLetter-__buttonConversation___1tdUr')]";

    public static final String okbutton = "/html/body/div[26]/div/div[3]/button[1]";

    // XPaths for calendar navigation
    public static final String CURRENT_MONTH_YEAR_TEXT = "//*[@id='router-wrapper']/div/div[2]/div/div[4]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div[1]";
    public static final String BACK_BUTTON = "//*[@id='router-wrapper']/div/div[2]/div/div[4]/div[1]/div[2]/div/div[2]/div[2]/div/button]";
    public static final String DYNAMIC_DATE_XPATH_FORMAT = "//div[contains(@class,'react-datepicker__day') and not(contains(@class, 'react-datepicker__day--outside-month')) and @aria-label and contains(text(), '%s')]";
    public static final String MONTH = "September 2024";

    // Logout locators
    public static final String LOGOUT_DROPDOWN_BUTTON = ".node_modules-react-multilevel-dropdown-__button___3qDO9.node_modules-react-multilevel-dropdown-__button-secondary___D25gR.src-routes-PharmacistPortal-LandingPage-components-MenuBar-__signOutButton___3_gq-.src-routes-PharmacistPortal-LandingPage-components-MenuBar-__regularButton___19gWx";
    public static final String SIGNOUT_BUTTON = "//*[@id='router-wrapper']/div/div[1]/div[2]/div[2]/span[2]/div/div/ul/li[3]";

    public PatientPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterPatientID(String patientId) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATIENT_ID_INPUT)));
        input.clear();
        input.sendKeys(patientId);
    }

    public void clickReportsButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(REPORTS_BUTTON)));
        button.click();
    }

    public void selectDate10DaysBack() throws InterruptedException {
        WebElement calendar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CALENDAR_INPUT)));
        calendar.click();

        Thread.sleep(2000);

        while (true) {
            String text = driver.findElement(By.xpath(CURRENT_MONTH_YEAR_TEXT)).getText();
            if (text.equals(MONTH)) {
                break;
            } else {
                driver.findElement(By.xpath(BACK_BUTTON)).click();
            }
        }

        String day = "17";
        String dynamicDateXPath = String.format(DYNAMIC_DATE_XPATH_FORMAT, day);
        driver.findElement(By.xpath(dynamicDateXPath)).click();
    }

    public void clickSetReviewButton() {
        WebElement setReviewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SET_REVIEW_BUTTON)));
        setReviewButton.click();  // Click the Set Review button

        // Wait for the OK button to be clickable and then click it
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(okbutton)));
        okButton.click();  // Click the OK button
    }

    // logout method
    public void logout() {
        try {
            WebElement logoutDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(LOGOUT_DROPDOWN_BUTTON)));
            logoutDropdown.click(); // Click the logout dropdown button

            WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIGNOUT_BUTTON)));
            signOutButton.click(); // Click the sign-out button
        } catch (Exception e) {
            throw new RuntimeException("Logout failed: " + e.getMessage());
        }
    }
}
