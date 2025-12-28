package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class waits {

    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Initialize WebDriver (Chrome)
        // ------------------------------------------------------------
        WebDriver driver = new ChromeDriver();

        // ------------------------------------------------------------
        // IMPLICIT WAIT
        // Global wait for element lookup
        // ------------------------------------------------------------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open GitHub main page
        driver.get("https://github.com");

        // Click search button to open search dialog
        WebElement searchBtn = driver.findElement(
                By.cssSelector("button.header-search-button")
        );
        searchBtn.click();

        // ------------------------------------------------------------
        // EXPLICIT WAIT
        // Wait until search input appears (dynamic element)
        // ------------------------------------------------------------
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement realInput = explicitWait.until(
                d -> d.findElement(By.id("query-builder-test"))
        );

        // Enter repository name and submit search
        realInput.sendKeys("MedicalDataExchange\n");

        // ------------------------------------------------------------
        // FLUENT WAIT
        // Wait until repository link appears in search results
        // Uses polling + ignored exceptions
        // ------------------------------------------------------------
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(d -> {
           WebElement link = d.findElement(By.xpath("//a[@href='/axmdl1/MedicalDataExchange']"));
           link.click();
           return true;
        });

        System.out.println("✅ Search test PASSED successfully");

        // Keep browser open for manual verification
        System.out.println("Press ENTER to close the browser...");
        new Scanner(System.in).nextLine();

        driver.quit();
    }
}