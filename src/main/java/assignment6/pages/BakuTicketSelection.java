package assignment6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BakuTicketSelection {
    private WebDriver driver;
    private WebDriverWait wait;

    public BakuTicketSelection(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By selectButton = By.xpath("//*[@id=\"10885\"]/div[2]/div[2]/a");
    private By addToCartBtn = By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div[3]/div[3]/div[2]/div[2]/div[2]/div[2]/button");
    private By closeModalPageBtn = By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div[1]/span");
    private By checkOutBtn = By.xpath("//*[@id=\"event-content-wrapper\"]/div[7]/div/div[2]/a");

    public void clickSelectTicketBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(selectButton)).click();
    }

    public void clickAddToCartBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void closeModalPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(closeModalPageBtn)).click();
    }

    public void clickCheckOutBtn() {
        driver.findElement(checkOutBtn).click();
    }
}
