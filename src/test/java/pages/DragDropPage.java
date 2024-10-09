package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.AutomationException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DragDropPage {
    private WebDriver driver;
    private static WebDriverWait wait;
    private Actions actions;

    // Locators declared as static final fields
    public static final String PATIENT_ID_INPUT = "//input[@type='search']";
    public static final String TASK_TAB = "//button[text()='Tasks']";
    //public static final String MOVE_BUTTON = "//*[@id='patientTriageGlobalTable']/div/div/div[2]/div/div[2]/div[2]/table/thead/tr/th[6]/div[1]/div[2]/button[1]";
    public static final String TABLE_HEADINGS = "//table[@class='mantine-Table-root mantine-1yuh4td']//thead/tr/th";
    public static final String PATIENT_MENU = "//button[contains(text(),'Patient')]";
    public static final String TASK_TABLE = "//tr[@class='mantine-fvktgm']";
    public static final String THREE_DOT_BUTTON = "//button[contains(@class,'mantine-4nqhrt')]";
    public static final String SHOW_HIDE_BUTTON = "//button[@aria-label='Show/Hide columns']";
    public static final String SHOW_HIDE_DROPDOWN = "//button[@class='mantine-Menu-item mantine-1okg4gn']";
    public static final String RESET_BUTTON = "(//button[contains(@class,'mantine-Button-root')])[2]";

    // Constructor
    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    // Method to click the Patient button
    public static void clickPatient() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATIENT_MENU))).click();
            wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
        } catch (Exception e) {
            Assert.fail("Patient button not found or clickable: " + e.getMessage());
        }
    }

    // Method to enter Patient ID
    public static void enterPatientID(String patientId) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PATIENT_ID_INPUT)));
        input.clear();
        input.sendKeys(patientId);
    }

    // Method to click the Task tab
    public void clickTaskTab() throws AutomationException {
        try {
            WebElement taskTabElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TASK_TAB)));

            // Use JavaScript Executor to click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", taskTabElement);
        } catch (Exception e) {
            throw new AutomationException("Failed to click on the Task tab: " + e.getMessage(), e);
        }
    }

    // Method to click three-dot and Show/Hide button
    public void clicksThreeDotAndShowHideButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_TABLE)));

        WebElement threeDotBtn = driver.findElement(By.xpath(THREE_DOT_BUTTON));
        actions.moveToElement(threeDotBtn).click().perform();
        WebElement showHideBtn = driver.findElement(By.xpath(SHOW_HIDE_BUTTON));
        actions.moveToElement(showHideBtn).click().perform();
    }

    // Click reset button
    public void clickResetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RESET_BUTTON))).click();
    }

    // Method to drag and drop columns
    public void dragAndDrop(String column1, String column2) {
        By sourceColumnButton = By.xpath("//div[text()='" + column1 + "']/parent::div/following-sibling::div/child::button[1]");
        By destinationColumnButton = By.xpath("//div[text()='" + column2 + "']/parent::div/following-sibling::div/child::button[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TASK_TABLE)));
        WebElement sourceColumn = driver.findElement(sourceColumnButton);
        WebElement destinationColumn = driver.findElement(destinationColumnButton);
        actions.dragAndDrop(sourceColumn, destinationColumn).perform();
    }

    public void dragAndDropInList(String column1, String column2) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SHOW_HIDE_DROPDOWN)));
        By sourceColumnButton = By.xpath("//label[text()='" + column1 + "']/parent::div/parent::div/parent::div/preceding-sibling::button");
        By destinationColumnButton = By.xpath("//label[text()='" + column2 + "']/parent::div/parent::div/parent::div/preceding-sibling::button");

        WebElement sourceColumn = driver.findElement(sourceColumnButton);
        WebElement destinationColumn = driver.findElement(destinationColumnButton);
        actions.dragAndDrop(sourceColumn, destinationColumn).perform();
    }

    // Validate columns after drag and drop
    public void validateColumns(DataTable expectedTable) {
        List<Map<String, String>> expectedColumns = expectedTable.asMaps(String.class, String.class);
        List<String> expectedColumnOrder = new ArrayList<>();
        for (Map<String, String> row : expectedColumns) {
            expectedColumnOrder.add(row.get("Column"));
        }

        // Fetch the actual column order from the table
        List<WebElement> columns = driver.findElements(By.xpath(TABLE_HEADINGS));

        List<String> actualColumnOrder = new ArrayList<>();
        for (WebElement column : columns) {
            String columnName = column.getText().trim();
            // Ensure you're only adding non-empty column names
            if (!columnName.isEmpty()) {
                actualColumnOrder.add(columnName);
            }
        }

        // Validate the sequence
        Assert.assertEquals(actualColumnOrder, expectedColumnOrder, "The column sequence is incorrect after drag and drop.");
    }

    public void validateList(DataTable expectedTable) throws InterruptedException {
        Thread.sleep(5000);
        List<Map<String, String>> expectedColumns = expectedTable.asMaps(String.class, String.class);
        List<String> expectedColumnOrder = new ArrayList<>();
        for (Map<String, String> row : expectedColumns) {
            expectedColumnOrder.add(row.get("Column"));
        }

        // Re-fetch the actual column order from the table
        List<WebElement> columns = driver.findElements(By.xpath("//label[contains(@class,'mantine-Switch-label')]"));
        List<String> actualColumnOrder = new ArrayList<>();
        for (WebElement column : columns) {
            actualColumnOrder.add(column.getText());
        }

        // Skip the first element of actualColumnOrder
        List<String> actualColumnOrderWithoutFirst = actualColumnOrder.subList(1, actualColumnOrder.size());

        // Validate the sequence (skipping the first element of actualColumnOrder)
        Assert.assertEquals(actualColumnOrderWithoutFirst, expectedColumnOrder, "The column sequence is incorrect after drag and drop.");
    }

}
