package assignment8.tests;

import assignment8.config.BaseTest;
import assignment8.pages.BakuTicketSelection;
import assignment8.pages.CartPage;
import assignment8.pages.CustomerInformation;
import assignment8.pages.MainPage;
import assignment8.utils.ExcelReader;
import org.testng.annotations.Test;

import java.util.Map;

public class BuyF1TicketTest extends BaseTest {
    @Test
    public void buyFormula1Ticket() {
        MainPage mainPage = new MainPage(driver);
        log.info("opening website");
        mainPage.openWebsite();
        log.info("Clicking accept cookies button");
//        mainPage.clickAcceptCookies();
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
