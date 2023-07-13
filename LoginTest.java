java
        Copy code
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.Common.Constants;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Constants.CHROME_ARGUMENT);
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void verifyLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "manager");
    }

    @Test
    public void verifyLoginWithIncorrectUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("User", "manager");
    }

    @Test
    public void verifyLoginWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "Password");
    }

    @Test
    public void verifySuccessfulLogout() {
        LoginPage loginPage = new LoginPage(driver);
        ReportsPage reportsPage = new ReportsPage(driver);

        loginPage.login("admin", "manager");
        // Perform actions after login
    }

    @Test
    public void verifyLoginWithEmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
    }

    @Test
    public void verifyLoginWithLockedAccount() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lockedUser", "password123");
    }

    @Test
    public void verifyAccessToReportsWithoutLogin() {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.open();
        // Perform actions without login
    }

    @Test
    public void reportsDashboard() {
        LoginPage loginPage = new LoginPage(driver);
        ReportsPage reportsPage = new ReportsPage(driver);

        loginPage.login("admin", "manager");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));

        reportsPage.clickReportsContainer();
    }
}