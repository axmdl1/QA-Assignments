package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeatSelectionPage extends BasePage {

    private By randomSeat = By.xpath("//button[contains(@class,'preset-2') and .//text()[contains(.,'Continue without selecting seats')]]");
    //private By confirmBtn = By.xpath("/html/body/main/div/div[2]/section/div/div[3]/div/button");

    public SeatSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomSeat() {
        wait.until(ExpectedConditions.elementToBeClickable(randomSeat)).click();
    }
}
