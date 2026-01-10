package assignment6.tests;

import assignment6.config.BaseTest;
import assignment6.pages.BakuTicketSelection;
import assignment6.pages.CartPage;
import assignment6.pages.CustomerInformation;
import assignment6.pages.MainPage;
import assignment6.utils.ExcelReader;
import org.testng.annotations.Test;

import java.util.Map;

public class BuyF1TicketTest extends BaseTest {
    @Test
    public void buyFormula1Ticket() {
        MainPage mainPage = new MainPage(driver);
        log.info("opening website");
        mainPage.openWebsite();
        log.info("Clicking accept cookies button");
        mainPage.clickAcceptCookies();
        log.info("Choosing Azerbaijan GP, Baku circuit");
        mainPage.openBakuTicket();

        log.info("Selecting ticket for gran prix");
        BakuTicketSelection bakuTicketSelection = new BakuTicketSelection(driver);
        bakuTicketSelection.clickSelectTicketBtn();
        log.info("Adding ticket to card");
        bakuTicketSelection.clickAddToCartBtn();
        bakuTicketSelection.closeModalPage();
        log.info("Going to cart page");
        bakuTicketSelection.clickCheckOutBtn();

        CartPage cartPage = new CartPage(driver);
        log.info("In cart page, clicking check out button");
        cartPage.clickCheckOutBtn();

        log.info("Extracting data from excel");
        Map<String, String> creds = ExcelReader.getCredentials("Sheet1");

        String email = creds.get("email");
        String password = creds.get("password");

        CustomerInformation customerInformation = new CustomerInformation(driver);
        log.info("Filling in email and password for auth");
        customerInformation.openLoginModal();
        customerInformation.fillInLoginData(email, password);
        customerInformation.clickSignIn();
        log.info("Test completed!");
    }
}
