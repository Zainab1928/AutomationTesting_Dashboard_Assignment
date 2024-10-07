package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static final String REPORT_PATH = "target/reports"; // Report path
    private static final String SCREENSHOT_PATH = "target/reports/screenshots"; // Screenshot directory

    // Initialize the Extent Report
    public static void initExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH + "/DashboardPage.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Ensure the screenshot directory exists
        File screenshotDir = new File(SCREENSHOT_PATH);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
    }

    // Start the test with the given name
    public static void startTest(String testName) {
        test = extent.createTest(testName).assignAuthor("Zainab").assignCategory("Functional testcase").assignDevice("Windows");
    }

    // Log information messages
    public static void logInfo(String message) {
        test.info(message);
    }

    // Log pass status
    public static void logPass(String message) {
        test.pass(message);
    }

    // Log fail status and capture screenshot
    public static void logFail(String message) {
        test.fail(message);
        captureScreenshot(); // Capture screenshot on failure
    }

    // Finalize the report
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Capture a screenshot and attach it to the Extent Report
    private static void captureScreenshot() {
        WebDriver driver = DriverFactory.getDriver(); // Get WebDriver instance
        TakesScreenshot ts = (TakesScreenshot) driver;
        String screenshotFileName = "screenshot_" + System.currentTimeMillis() + ".png";
        String screenshotFilePath = SCREENSHOT_PATH + "/" + screenshotFileName;

        try {
            // Capture screenshot and save it to file
            File source = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), Paths.get(screenshotFilePath));

            // Use the relative path from the report to the screenshots folder
            // Since the report is in "target/reports", the relative path to the screenshots is "screenshots/screenshot_<timestamp>.png"
            String relativeScreenshotPath = "screenshots/" + screenshotFileName;

            // Attach screenshot to report using relative path for better compatibility
            test.fail("Screenshot of failure:",
                    MediaEntityBuilder.createScreenCaptureFromPath(relativeScreenshotPath).build());

        } catch (IOException e) {
            test.fail("Failed to capture screenshot: " + e.getMessage());
        }
    }


    // Log the result of the test based on the ITestResult status
    public static void logTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                test.fail("TEST CASE FAILED: " + result.getName());
                test.fail(result.getThrowable()); // Log the exception details
                captureScreenshot(); // Capture and attach screenshot
                break;
            case ITestResult.SKIP:
                test.skip("Test Case SKIPPED: " + result.getName());
                break;
            case ITestResult.SUCCESS:
                test.pass("Test Case PASSED: " + result.getName());
                break;
        }
    }
}
