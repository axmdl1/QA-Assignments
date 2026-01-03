package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TicketBookPage extends BasePage {

    private By bookBtn = By.cssSelector("div.t-leazy:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2) > span:nth-child(1)");

    public TicketBookPage(WebDriver driver) {
        super(driver);
    }

    public void clickBookBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookBtn)).click();
    }
}
