package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private By clickToField = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/section/div[1]/div/div[1]/div[2]/label/input");
    private By chooseCityAlmaty = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/section/div[1]/div/div[1]/div[2]/div/div/div/button[1]/span");
    private By clickDataPicker = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/section/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]/button[3]");
    private By chooseDate = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/section/div[1]/div/div[2]/div[2]/div[1]/button");
    private By turnOffHotelSearch = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/section/div[2]/label");
    private By searchBtn = By.xpath("/html/body/header/div/div[2]/div/div[2]/form/aside/button");

    public MainPage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public void enterTo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickToField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseCityAlmaty)).click();
    }

    public void selectDate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickDataPicker)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(chooseDate)).click();
    }

    public void turnOffHotelSearch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turnOffHotelSearch)).click();
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
    }

}