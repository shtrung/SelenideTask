package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class CreateDefaultProjectSteps {

    private DashBoard dashBoard;
    private ProjectPage projectPage;
    private IssuePage issuePage;

    @Given("Пользователь авторизован в системе c email {string} и паролем {string}")
    public void userAuthorization(String email, String pass){
        dashBoard = new LoginPage()
               .sendEmail(email)
               .sendPassword(pass)
               .loginClick();
    }

    @And("Открывает раздел проектов")
    public void openProjects() throws InterruptedException {
        projectPage = dashBoard.goProject();
    }

    @When("Нажимает кнопку создать новый проект")
    public void createProject(){
        projectPage = projectPage.createProjectClick();
    }

    @And("Создает новый дефолтный проект с именем {string} и сохраняет его")
    public void createDefaultProject(String projectName){
        projectPage = projectPage.createDefaultProject(projectName);
    }

    @Then("Проект {string} появляется в списке проектов")
    public void checkMyProject(String projectName) throws InterruptedException {
        projectPage = dashBoard.goProject();
        projectPage.checkProject(projectName);
    }

    @When("Пользователь переходит в созданный проект {string}")
    public void goToCreateProject(String projectName){
        projectPage = projectPage.clickProject(projectName);
    }

    @And("Создает задачу на проекте с содержанием {string} и описанием {string}")
    public void createIssueInProject(String summary, String description){
        issuePage = projectPage.createIssue()
                .sendSummary(summary)
                .sendDescription(description)
                .createIssueClick();
    }

    @Then("Задача {string} создана и отображается в проекте {string}")
    public void checkCreateIssue (String summary, String projectName) throws InterruptedException {
        issuePage.menuBar.goProjects();
        projectPage = projectPage.clickProject(projectName);
        issuePage.checkIssue(summary);
    }


}
