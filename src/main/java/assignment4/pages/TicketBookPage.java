package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TicketBookPage extends BasePage {

//    private By bookBtn = By.xpath(
//            "//div[contains(@class,'avia-item')]" +
//                    "[.//span[contains(normalize-space(),'10 KG')]]" +
//                    "//div[contains(@class,'avia-flexible-tickets-results')]" +
//                    "//button[.//span[normalize-space()='Book']]"
//    );

    private By bookBtn = By.xpath("//div[contains(@class,'avia-item')]" +
            "[.//div[contains(text(),'SCAT JSC Aircompany')]]" +
            "//div[.//div[normalize-space()='Standard Ticket']]" +
            "//button[.//span[normalize-space()='Book']]");

    public TicketBookPage(WebDriver driver) {
        super(driver);
    }

    public void clickBookBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookBtn)).click();
    }
}
