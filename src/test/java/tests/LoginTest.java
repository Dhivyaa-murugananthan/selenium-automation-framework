package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"standard_user", "wrong_password", false},
                {"locked_out_user", "secret_sauce", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, boolean expectedResult) {

        log.info("========== START TEST ==========");
        log.info("Executing test for user: {}", username);

        test.info("Starting test for user: " + username);

        LoginPage loginPage = new LoginPage(driver);

        log.info("Entering username");
        test.info("Entering username");
        loginPage.enterUsername(username);

        log.info("Entering password");
        test.info("Entering password");
        loginPage.enterPassword(password);

        log.info("Clicking login button");
        test.info("Clicking login button");
        loginPage.clickLogin();

        boolean isLoggedIn;

        try {
            isLoggedIn = wait.until(ExpectedConditions.urlContains("inventory"));
            log.info("Login success condition detected");
            test.info("Login success condition detected");

        } catch (Exception e) {
            isLoggedIn = false;
            log.warn("Login failed or timeout for user: {}", username);
            test.warning("Login failed or timeout occurred");
        }

        log.info("Expected: {}, Actual: {}", expectedResult, isLoggedIn);
        test.info("Expected: " + expectedResult + " | Actual: " + isLoggedIn);

        Assert.assertEquals(isLoggedIn, expectedResult, "Test failed for user: " + username);

        log.info("========== END TEST ==========\n");
    }
}