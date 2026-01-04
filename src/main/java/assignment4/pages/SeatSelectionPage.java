package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeatSelectionPage extends BasePage {

    private By randomSeat = By.xpath("//*[@id=\"app-avia\"]/div/div[2]/section/div/div[2]/div/div/div[2]/label[3]/div[3]/div[2]");
    private By confirmBtn = By.xpath("/html/body/main/div/div[2]/section/div/div[3]/div/button");

    public SeatSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void selectRandomSeat() {
        driver.findElement(randomSeat).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBtn)).click();
    }
}
