package assignment5.tests;

import assignment5.config.BaseTest;
import assignment5.pages.CatalogPage;
import assignment5.pages.MainPage;
import assignment5.pages.ProductPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuyBookTest extends BaseTest {

    String bookName = "чистая архитектура";

    @Test
    public void buyCleanArchitectureBook() {

        log.info("Opening main page");
        MainPage mainPage = new MainPage(driver);
        mainPage.openWebsite();
        mainPage.searchField(bookName);

        log.info("Waiting for 5 seconds");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        log.info("Choosing our book in catalog page");
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openBookByName(bookName);

        log.info("Clicking add to cart button and going to cart page");
        ProductPage productPage = new ProductPage(driver);
        productPage.addAndGoToCart();

    }
}
