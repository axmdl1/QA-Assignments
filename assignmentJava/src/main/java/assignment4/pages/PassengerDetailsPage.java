package assignment4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PassengerDetailsPage extends BasePage{

    private By clickMaleBtn = By.xpath("/html/body/main/div/div[2]/section/div[4]/div/div[1]/div[2]/div/button[1]");
    private By enterSurname = By.name("lastName");
    private By enterName = By.name("firstName");
    private By birthday = By.name("birthday");
    private By selectDocType = By.xpath("/html/body/main/div/div[2]/section/div[4]/div/div[1]/div[7]/div/div[2]/div[2]/div/button[1]");
    private By docNumber = By.name("docnum");
    private By docExpiry = By.name("docExpireDate");
    private By taxID = By.name("ipn");
    private By additionalBaggage = By.xpath("/html/body/main/div/div[2]/section/div[4]/div/div[2]/div[2]/div[3]/label[2]/div[3]/div[2]");
    private By email = By.name("email");
    private By phone = By.name("phone");
    private By flexibleTicket = By.xpath("/html/body/main/div/div[2]/section/div[6]/div[3]/label[1]");
    private By continueBtn = By.xpath("/html/body/main/div/div[2]/section/div[7]/div/button");

    public PassengerDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void fillInDetails(String surname, String firstName) {
        driver.findElement(clickMaleBtn).click();
        driver.findElement(enterSurname).sendKeys(surname);
        driver.findElement(enterName).sendKeys(firstName);
        driver.findElement(birthday).sendKeys("01.01.1990");
        driver.findElement(By.name("docType")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDocType)).click();
        driver.findElement(docNumber).sendKeys("764382465");
        driver.findElement(docExpiry).sendKeys("18.01.2032");
        driver.findElement(taxID).sendKeys("900101341531");
        driver.findElement(additionalBaggage).click();
        driver.findElement(email).sendKeys("mr.john@gmail.com");
        driver.findElement(phone).sendKeys("7774563646");
        driver.findElement(flexibleTicket).click();
        driver.findElement(continueBtn).click();
    }
}
