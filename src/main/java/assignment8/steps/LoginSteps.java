package assignment8.steps;

import assignment8.config.DriverManager;
import assignment8.pages.BakuTicketSelection;
import assignment8.pages.CartPage;
import assignment8.pages.MainPage;
import assignment8.pages.CustomerInformation;
import assignment8.utils.ExcelReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class LoginSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private CustomerInformation customerInformation;

    public LoginSteps() {
        this.driver = DriverManager.getDriver();
    }

    @Given("the user is on the F1 Tickets checkout page")
    public void the_user_is_on_the_f1_tickets_checkout_page() {

        driver = DriverManager.getDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.openWebsite();
        mainPage.openBakuTicket();

        BakuTicketSelection baku = new BakuTicketSelection(driver);
        baku.clickSelectTicketBtn();
        baku.clickAddToCartBtn();
        baku.closeModalPage();
        baku.clickCheckOutBtn();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckOutBtn();
    }

    @Given("the user clicks on {string}")
    public void the_user_clicks_on(String text) {
        customerInformation = new CustomerInformation(driver);
        customerInformation.openLoginModal();
    }

    @When("the login modal is opened")
    public void the_login_modal_is_opened() {
        // modal already opened
    }

    @When("the user enters a valid email")
    public void the_user_enters_a_valid_email() {
        Map<String, String> creds = ExcelReader.getCredentials("Sheet1");
        customerInformation.fillInLoginData(creds.get("email"), "");
    }

    @When("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        Map<String, String> creds = ExcelReader.getCredentials("Sheet1");
        customerInformation.fillInLoginData("", creds.get("password"));
    }

    @When("the user clicks the Sign In button")
    public void the_user_clicks_the_sign_in_button() {
        customerInformation.clickSignIn();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        // Можно добавить assert по URL или элементу профиля
    }
}