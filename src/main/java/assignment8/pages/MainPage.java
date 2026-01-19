package assignment8.pages;

import org.openqa.selenium.*;
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
        try {
            WebElement cookies =
                    new WebDriverWait(driver, Duration.ofSeconds(5))
                            .until(ExpectedConditions.elementToBeClickable(clickAcceptCookie));
            cookies.click();
        } catch (TimeoutException e) {
            // cookies баннера нет — это нормально
        }
    }

//    public void clickAcceptCookies() {
//        driver.findElement(clickAcceptCookie).click();
//    }

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
