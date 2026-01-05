package assignment4;

import assignment4.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {
        testMainPage();
    }

    private static void testMainPage() {

        //Creating webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //fetching tickets.kz website
        driver.get("https://tickets.kz/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //initializing tickets.kz main page
        MainPage mainPage = new MainPage(driver);

        //filling in data to the main page, destination point, date selection.
        mainPage.enterTo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.selectDate();
        mainPage.turnOffHotelSearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.clickSearchBtn();

        //waiting for loading next page (TicketBookPage) after main page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[3]/div[1]/div[2]/button")));

        //init TicketBookPage
        TicketBookPage ticketBookPage = new TicketBookPage(driver);
        ticketBookPage.clickBookBtn();

        //waiting while next page loads (PassengerDetails)
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".t-passenger-gender > button:nth-child(1)")));

        //init PassengerDetails and filling in data.
        PassengerDetailsPage enterDetailsPage = new PassengerDetailsPage(driver);
        enterDetailsPage.fillInDetails("James", "Kosinskiye");

        //waiting for next page

        //init SeatSelectionPage and selecting random seat.
        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(driver);
        seatSelectionPage.selectRandomSeat();

        //waiting for next page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div[2]/section/div/div[3]/div/button")));

        //init MealSelectionPage, and skipping meal selection.
        MealSelectionPage mealSelectionPage = new MealSelectionPage(driver);
        mealSelectionPage.clickSkipMealSelection();

        //After all successful operation click enter on keyboard for finishing test.
        new Scanner(System.in).nextLine();
        driver.quit();
    }
}