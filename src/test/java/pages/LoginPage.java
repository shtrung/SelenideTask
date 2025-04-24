package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {


    private final SelenideElement emailField = $x("//input[@id='username']");
    private final SelenideElement passwordField = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//button[@data-test='login-button']");
    private final SelenideElement menuBar = $x("//div[@data-test='navigation-bar']");

    @Step("I`m on the login page and enter email {string}")
    public LoginPage sendEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("I`m on the login page and enter password {string}")
    public LoginPage sendPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }


    @Step("I click the login button")
    public DashBoard loginClick() {
        loginButton.click();
        if(isLogin()){
            return new DashBoard();
        }else {
            return null;
        }
    }

    @Step("Checking for successful login")
    public boolean isLogin() {
        try {
            menuBar.shouldBe(visible, Duration.ofSeconds(20));
            Allure.step("Successful login");
            return true;
        } catch (ElementNotFound | TimeoutException e) {
            Allure.step("Failed login");
            return false;
        }
    }


}
