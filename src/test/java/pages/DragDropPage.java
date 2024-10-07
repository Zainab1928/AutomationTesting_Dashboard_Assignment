package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.AutomationException;

import java.time.Duration;

public class DragDropPage {
    private WebDriver driver;
    private static WebDriverWait wait;
    private Actions actions;

    // Locators
    public static final String PATIENT_INPUT = "//input[@type='search']";
    private By taskTab = By.xpath("//button[text()='Tasks']");
    private By moveButton = By.xpath("//*[@id='patientTriageGlobalTable']/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[6]/div[1]/div[2]/button[1]");
    private By tableHeadings = By.xpath("//table[@class='mantine-Table-root mantine-1yuh4td']//thead/tr/th");
    private static By patientMenu = By.xpath("//button[contains(text(),'Patient')]");

    // Constructor
    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    public static void clickPatient() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(patientMenu)).click();
            wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
        } catch (Exception e) {
            Assert.fail("Patient button not found or clickable: " + e.getMessage());
        }
    }

    public static void PatientID(String patientId) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATIENT_INPUT)));
        input.clear();
        input.sendKeys(patientId);
    }

    public void clickTaskTab() throws AutomationException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(taskTab)).click();
        } catch (Exception e) {
            throw new AutomationException("Failed to click on the Task tab: " + e.getMessage(), e);
        }
    }

    public void verifyDraggableTableHeaders() throws AutomationException {
        // Wait for the table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(moveButton));

        try {
            // Perform drag action on the 'Move' button of a column
            WebElement moveBtn = driver.findElement(moveButton);
            WebElement dueDateColumn = driver.findElement(By.xpath("//*[@id='patientTriageGlobalTable']/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[6]"));

            actions.clickAndHold(moveBtn)
                    .moveToElement(dueDateColumn)
                    .release()
                    .build()
                    .perform();

            System.out.println("Table heading 'Due Date' moved successfully.");
        } catch (Exception e) {
            throw new AutomationException("Failed to drag and drop the table heading: " + e.getMessage(), e);
        }
    }
}
