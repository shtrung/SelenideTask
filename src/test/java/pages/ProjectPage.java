package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectPage {

    public final MenuBar menuBar = MenuBar.getInstance();

    private final SelenideElement createProjectButton = $x("//a[@href='projects/create']");

    private final ElementsCollection projects = $$x("//div[@data-test='project']");

    private final SelenideElement projectDefault = $x("//button[@data-test='template'][1]");

    private final SelenideElement projectScrum = $x("//button[@data-test='template'][3]");

    private final SelenideElement projectDemo = $x("//button[@data-test='template'][5]");

    private final SelenideElement acceptButton = $x("//button[@data-test='accept-button']");

    private final SelenideElement inputName = $x("//input[@data-test='project-name']");

    private final SelenideElement createButton = $x("//button[@data-test='create-button']");

    private final SelenideElement skipButton = $x("//button[@data-test='skip']");

    private final SelenideElement crateIssue = $x("//*[text()='Новая задача']");

    @Step("Создание дефолтного проекта с именем {string}")
    public ProjectPage createDefaultProject(String projectName) {
        projectDefault.click();
        acceptButton.click();
        inputName.sendKeys(projectName);
        createButton.click();
        skipButton.click();
        return this;
    }

    @Step("Клик по кнопке создания проекта")
    public ProjectPage createProjectClick() {
        createProjectButton.click();
        return this;
    }

    @Step("Проверка создания проекта {string} в общем списке")
    public void checkProject(String projectName) {
        $(byText(projectName)).shouldBe(visible);
    }

    @Step("Переходим в созданный проект {string}")
    public ProjectPage clickProject(String projectName) {
        $(byText(projectName))
                .click();
        return this;
    }

    @Step("Клик по кнопке моздания задачи на проекте")
    public IssuePage createIssue() {
        crateIssue.click();
        return new IssuePage();
    }
}
