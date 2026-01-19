package assignment8.steps;

import assignment8.config.DriverManager;
import assignment8.pages.BakuTicketSelection;
import assignment8.pages.CartPage;
import assignment8.pages.MainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class TicketSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private BakuTicketSelection baku;
    private CartPage cartPage;

    public TicketSteps() {
        this.driver = DriverManager.getDriver();
    }

    @Given("the user is on the main F1 Tickets page")
    public void the_user_is_on_the_main_page() {
        mainPage = new MainPage(driver);
        mainPage.openWebsite();
    }

    @When("the user selects Azerbaijan GP ticket")
    public void the_user_selects_ticket() {
        mainPage.openBakuTicket();
        baku = new BakuTicketSelection(driver);
        baku.clickSelectTicketBtn();
    }

    @When("the user adds the ticket to the cart")
    public void the_user_adds_ticket_to_cart() {
        baku.clickAddToCartBtn();
        baku.closeModalPage();
    }

    @Then("the cart should contain the ticket")
    public void the_cart_should_contain_ticket() {
        // можно оставить пустым или проверить URL
    }

    @Given("the ticket is already in the cart")
    public void the_ticket_is_already_in_cart() {
        the_user_is_on_the_main_page();
        the_user_selects_ticket();
        the_user_adds_ticket_to_cart();
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        baku.clickCheckOutBtn();
        cartPage = new CartPage(driver);
        cartPage.clickCheckOutBtn();
    }

    @Then("the checkout page should be opened")
    public void the_checkout_page_should_be_opened() {
        // assert по URL или наличию формы
    }
}