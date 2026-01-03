package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MealSelectionPage extends BasePage{

    private By skipMealSelection = By.xpath("/html/body/main/div/div[2]/section/div/div[3]/div/button");

    public MealSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void clickSkipMealSelection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipMealSelection)).click();
    }
}
