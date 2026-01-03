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

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tickets.kz/en");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        MainPage mainPage = new MainPage(driver);

        mainPage.enterTo();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        mainPage.selectDate();
        mainPage.turnOffHotelSearch();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage.clickSearchBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[3]/div[1]/div[2]/button")));

        TicketBookPage ticketBookPage = new TicketBookPage(driver);
        ticketBookPage.clickBookBtn();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div[2]/section/div[4]/div/div[1]/div[2]/div/button[1]")));

        PassengerDetailsPage enterDetailsPage = new PassengerDetailsPage(driver);
        enterDetailsPage.fillInDetails("James", "Kosinskiye");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-avia\"]/div/div[2]/section/div/div[2]/div/div/div[2]/label[3]/div[3]/div[2]")));

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(driver);
        seatSelectionPage.selectRandomSeat();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div/div[2]/section/div/div[3]/div/button")));

        MealSelectionPage mealSelectionPage = new MealSelectionPage(driver);
        mealSelectionPage.clickSkipMealSelection();

        new Scanner(System.in).nextLine();
        driver.quit();
    }
}