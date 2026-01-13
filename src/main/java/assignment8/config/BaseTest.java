package assignment8.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log = LogManager.getLogger(getClass());

    @BeforeMethod
    public void setUp() throws Exception {

        Dotenv dotenv = Dotenv.load();

        String username = dotenv.get("BROWSERSTACK_USERNAME");
        String accessKey = dotenv.get("BROWSERSTACK_ACCESS_KEY");
        String hubUrl = dotenv.get("BROWSERSTACK_URL");

        String remoteUrl = String.format(
                "https://%s:%s@%s",
                username,
                accessKey,
                hubUrl
        );

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "OS X");
        bstackOptions.put("osVersion", "Monterey");
        bstackOptions.put("sessionName", "Assignment 6 – F1 Ticket Test");
        bstackOptions.put("seleniumVersion", "4.17.0");

        caps.setCapability("bstack:options", bstackOptions);

        driver = new RemoteWebDriver(
                new URL(remoteUrl),
                caps
        );

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}