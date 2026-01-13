package assignment8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By checkOutBtn = By.xpath("//*[@id=\"funnel-wrapper\"]/div[4]/div/div[1]/div[2]/div/div/div[4]/button");

    public void clickCheckOutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }
}
