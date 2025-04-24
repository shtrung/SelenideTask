package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MenuBar {


    private final SelenideElement issues = $x("//a[@href='issues']");

    private final SelenideElement dashboard = $x("//a[@href='dashboard']");

    private final SelenideElement agiles = $x("a[data-test='ring-link agile-boards-button']");

    private final SelenideElement reports = $x("//a[@href='reports']");

    private final SelenideElement dropdown = $x("//div[@data-test='ring-dropdown show-more']");

    private final SelenideElement projects = $x("//a[@href='projects']");

    private final SelenideElement articles = $x("//a[@href='articles']");

    private final SelenideElement creates = $x("//div[@data-test='ring-dropdown create']");

    private final SelenideElement collapseBar = $x("//button[@data-test='ring-link collapse-sidebar-button-button']");

    private final SelenideElement expandBar = $x("//button[@data-test='ring-tooltip expand-sidebar-button']");

    private final SelenideElement profile = $x("//div[@data-test='ring-dropdown ring-profile']");

    private final SelenideElement exitButton = $x("//button[text()='Выйти']");


    private MenuBar() {
    }

    private static class MenuBarHolder {
        public static final MenuBar INSTANCE = new MenuBar();
    }

    public static MenuBar getInstance() {
        return MenuBarHolder.INSTANCE;
    }

    @Step("Перехожу в раздел 'Доски Agile'")
    public void goAgileBoard() {
        agiles.click();
    }

    @Step("Перехожу в раздел 'Проекты'")
    public void goProjects() {
        dropdown.click();
        projects.click();
    }

    @Step("Перехожу в раздел 'Создать статью'")
    public void goArticles() {
        dropdown.click();
        articles.click();
    }

    @Step("Выход из аккаунта")
    public void logout() {
        profile.click();
        exitButton.click();
    }

    @Step("Перехожу в раздел 'Задачи'")
    public void goIssues() {
        issues.click();
    }

}
