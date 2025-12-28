package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Scanner;

public class actionClass {

    public static void main(String[] args) {

        // Initialize WebDriver and open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Apply implicit wait to handle element lookup delays
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the Drag and Drop demo page
        driver.get("https://demo.automationtesting.in/Static.html");

        // Locate draggable element and drop target
        WebElement source = driver.findElement(By.id("angular"));
        WebElement target = driver.findElement(By.id("droparea"));

        // Action Class usage
        // Create Actions object to perform complex user interactions
        Actions actions = new Actions(driver);

        // Perform drag and drop operation using mouse actions
        actions
                .clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();

        // Test result output
        System.out.println("✅ Drag and Drop completed successfully");

        // Keep the browser open for manual verification
        // The browser will close after pressing ENTER
        new Scanner(System.in).nextLine();

        // Close the browser and end the WebDriver session
        driver.quit();
    }
}