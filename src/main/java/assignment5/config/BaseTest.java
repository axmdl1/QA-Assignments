package assignment5.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log = LogManager.getLogger(getClass());

    @BeforeMethod
    public void setUp() {
        log.info("Starting browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

//    protected void waitForEnterAndClose() {
//        log.info("Press ENTER to close the browser...");
//        new Scanner(System.in).nextLine();
//
//        if (driver != null) {
//            log.info("Closing browser after ENTER");
//            driver.quit();
//            driver = null;
//        }
//    }

    @AfterMethod
    public void tearDown() {
        if (driver != null){
            log.info("Closing browser");
            driver.close();
        }
    }
}
