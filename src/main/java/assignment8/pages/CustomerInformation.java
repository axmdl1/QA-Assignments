package assignment8.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerInformation {

    private WebDriver driver;
    private WebDriverWait wait;

    public CustomerInformation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By alreadyHaveAccount =
            By.xpath("//*[@id='funnel-wrapper']//span[contains(text(),'Sign in')]");

    private By loginModal =
            By.cssSelector("form.login-wrapper");

    private By modalEmail =
            By.cssSelector("form.login-wrapper input[name='email']");

    private By modalPassword =
            By.cssSelector("form.login-wrapper input[name='password']");

    private By modalSignInBtn =
            By.cssSelector("form.login-wrapper button[type='submit']");

    public void openLoginModal() {
        wait.until(ExpectedConditions.elementToBeClickable(alreadyHaveAccount)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
    }

    public void fillInLoginData(String email, String password) {

        WebElement emailField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(modalEmail));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement passwordField =
                wait.until(ExpectedConditions.visibilityOfElementLocated(modalPassword));
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        WebElement btn = driver.findElement(modalSignInBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
}