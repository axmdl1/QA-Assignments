package assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By clickAddToCart = By.xpath("/html/body/div[3]/main/div[2]/div/div[5]/div[2]/div[4]/div/form/div[1]/div/div/button");
    private By goToCart = By.xpath("/html/body/div[3]/main/div[2]/div/div[5]/div[2]/div[4]/div/form/div[1]/div/div/a");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addAndGoToCart() {
        driver.findElement(clickAddToCart).click();
        wait.until(ExpectedConditions.elementToBeClickable(goToCart)).click();
    }
}
