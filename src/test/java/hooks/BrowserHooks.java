package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class BrowserHooks {


    @Before
    public void openBrowser() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 30000;
        Configuration.pollingInterval = 500;
        open("http://193.233.193.42:9091/");
    }

    @After
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
