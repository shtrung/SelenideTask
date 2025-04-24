package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IssuePage {

    public final MenuBar menuBar = MenuBar.getInstance();

    private final SelenideElement summaryField = $("textarea[data-test='summary']");

    private final SelenideElement descriptionField = $x("//div[@data-test='wysiwyg-editor-content']");

    private final SelenideElement submitButton = $x("//button[@data-test='submit-button']");

    private final SelenideElement dialogCloseButton = $x("//button[@data-test='ring-dialog-close-button']");

    private final SelenideElement savedTaskButton = $x("//button[@data-test='ok-button']");


    @Step("Ввожу краткое описание задачи {string}")
    public IssuePage sendSummary(String summary) {
       summaryField.sendKeys(summary);
       return this;
    }

    @Step("Ввожу описание задачи")
    public IssuePage sendDescription(String description) {
        descriptionField.sendKeys(description);
        return this;
    }

    @Step("Нажимаю кнопку 'Создать' ")
    public IssuePage createIssueClick() {
        submitButton.click();
        return this;
    }

    @Step("Перехожу во складку 'Задачи'")
    public IssuePage goToIssues() {
        menuBar.goIssues();
        return this;
    }


    @Step("Проверка создание задачи {string} на проекте")
    public void checkIssue(String summary) {
        $(byText(summary)).shouldBe(visible);
    }

}
