package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

@Feature("User Login")
public class TestLoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
    }

    @When("I enter valid email {string} and password {string}")
    public void i_enter_valid_credentials(String email, String password) {
        loginPage.sendEmail(email)
                .sendPassword(password);

    }

    @And("I click the login button")
    public void click() {
        loginPage.loginClick();
    }

    @Then("Login to the main page {booleanValue}")
    public void i_should_be_redirected_to_the_dashboard(boolean expected) {
        assertEquals(loginPage.isLogin(),expected);
    }

}
