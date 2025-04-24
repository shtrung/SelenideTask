package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashBoard {

    public final MenuBar menuBar = MenuBar.getInstance();

    private final SelenideElement anchor = $x("//div[@class='dashboard__ac1b']");

    {
        anchor.should(visible, Duration.ofSeconds(15));
    }


    public ProjectPage goProject() {
        menuBar.goProjects();
        return new ProjectPage();
    }

}
