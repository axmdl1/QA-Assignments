package assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatalogPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private String bookByNameXpath =
            "//a[contains(@class,'product-item-link') and " +
                    "contains(translate(normalize-space(.), " +
                    "'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ', " +
                    "'абвгдеёжзийклмнопрстуфхцчшщъыьэюя'), '%s')]";

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openBookByName(String bookName) {
        By bookLocator = By.xpath(String.format(bookByNameXpath, bookName.toLowerCase()));

        wait.until(ExpectedConditions.presenceOfElementLocated(bookLocator));
        wait.until(ExpectedConditions.elementToBeClickable(bookLocator)).click();
    }
}