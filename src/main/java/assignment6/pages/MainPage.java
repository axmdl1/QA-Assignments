package assignment6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By clickAcceptCookie = By.id("onetrust-accept-btn-handler");
    private By bakuBookNow = By.xpath(
            "//a[contains(@href,'azerbaijan') and contains(@class,'event-link')]"
    );

    public void openWebsite() {
        driver.get("https://tickets.formula1.com/en");
        wait.until(ExpectedConditions.elementToBeClickable(clickAcceptCookie));
    }

    public void clickAcceptCookies() {
        driver.findElement(clickAcceptCookie).click();
    }

    public void openBakuTicket() {
        WebElement btn = wait.until(
                ExpectedConditions.presenceOfElementLocated(bakuBookNow)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                btn
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                btn
        );
    }
}
