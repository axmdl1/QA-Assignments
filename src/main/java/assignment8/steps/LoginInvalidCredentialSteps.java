package assignment8.steps;

import assignment8.config.DriverManager;
import assignment8.pages.CustomerInformation;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginInvalidCredentialSteps {

    private WebDriver driver;
    private CustomerInformation customerInformation;

    public LoginInvalidCredentialSteps() {
        this.driver = DriverManager.getDriver();
        this.customerInformation = new CustomerInformation(driver);
    }

    @When("the user enters an invalid email")
    public void the_user_enters_an_invalid_email() {
        customerInformation.fillInLoginData("wrong@email.com", "");
    }

    @When("the user enters an invalid password")
    public void the_user_enters_an_invalid_password() {
        customerInformation.fillInLoginData("", "wrongPassword123");
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {

    }
}