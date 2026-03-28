package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.ScreenshotUtil;
import utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com");

        // Extent report setup
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

            test.fail("Test Failed");
            test.addScreenCaptureFromPath(path);

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed");
        }

        extent.flush();

        if (driver != null) {
            driver.quit();
        }
    }
}