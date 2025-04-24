Feature: Управление дефолтным проектом и задачами в нем

  Background:
    Given Пользователь авторизован в системе c email "shtrung.se@yandex.ru" и паролем "shtrungSem24F"
    And Открывает раздел проектов

  Scenario: Create default project
    When Нажимает кнопку создать новый проект
    And Создает новый дефолтный проект с именем "Default" и сохраняет его
    Then Проект "Default" появляется в списке проектов

  Scenario: Create issue in default project
    When Пользователь переходит в созданный проект "Default"
    And  Создает задачу на проекте с содержанием "Task in project default" и описанием "Description"
    Then Задача "Task in project default" создана и отображается в проекте "Default"