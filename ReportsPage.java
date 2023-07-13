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
import org.testng.annotations.Test;
import org.example.Common.Constants;

public class ReportsPage {
    private WebDriver driver;
    private By reportsContainer = By.id("container_reports");

    public ReportsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(Constants.WEB_URL);
        driver.manage().window().maximize();
    }

    public void clickReportsContainer() {
        driver.findElement(reportsContainer).click();
    }

    public void performActionOnReportsPage() {
        // Add your specific actions to be performed on the reports page
    }
}