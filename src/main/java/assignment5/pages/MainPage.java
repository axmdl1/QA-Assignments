package assignment5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private By searchField = By.id("search");
    private By clickSearch = By.cssSelector("button.block-search-wrapper__button[type='submit']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://www.meloman.kz/");
    }

    public void searchField(String bookName) {
        driver.findElement(searchField).sendKeys(bookName);
        driver.findElement(clickSearch).click();
    }
}
