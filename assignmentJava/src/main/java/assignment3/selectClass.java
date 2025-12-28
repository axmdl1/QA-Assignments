package assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Scanner;

public class selectClass {

    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open registration page
        driver.get("https://demo.automationtesting.in/Register.html");

        // Fill basic text fields
        driver.findElement(By.xpath("//input[@placeholder='First Name']"))
                .sendKeys("Akhmedali");

        driver.findElement(By.xpath("//input[@placeholder='Last Name']"))
                .sendKeys("Duisembayuly");

        driver.findElement(By.xpath("//textarea[@ng-model='Adress']"))
                .sendKeys("Astana IT University, Kazakhstan");

        driver.findElement(By.xpath("//input[@type='email']"))
                .sendKeys("akhmedali@example.com");

        driver.findElement(By.xpath("//input[@type='tel']"))
                .sendKeys("77771234567");

        // Select Gender (Radio Button)
        driver.findElement(By.xpath("//input[@value='Male']")).click();

        // Select Hobbies (Checkboxes)
        driver.findElement(By.id("checkbox1")).click(); // Cricket
        driver.findElement(By.id("checkbox2")).click(); // Movies

        // Select Class usage - Skills dropdown
        WebElement skills = driver.findElement(By.id("Skills"));
        Select skillsSelect = new Select(skills);
        skillsSelect.selectByVisibleText("Java");

        // Select Class usage - Country dropdown
        WebElement country = driver.findElement(By.id("countries"));
        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Australia");

        // Date of Birth selection
        new Select(driver.findElement(By.id("yearbox")))
                .selectByVisibleText("1999");

        new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")))
                .selectByVisibleText("March");

        new Select(driver.findElement(By.id("daybox")))
                .selectByVisibleText("15");

        // Password fields
        driver.findElement(By.id("firstpassword"))
                .sendKeys("StrongPassword123");

        driver.findElement(By.id("secondpassword"))
                .sendKeys("StrongPassword123");

        // Test completed
        System.out.println("✅ Registration form filled successfully");
        System.out.println("Press ENTER to close the browser...");

        new Scanner(System.in).nextLine();
        driver.quit();
    }
}