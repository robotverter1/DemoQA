# UI-тесты DemoQA: Selenium + TestNG + Allure (Page Object, кроссбраузер)

## Требования

JDK 17+, Maven 3.9+, браузеры Chrome / Firefox / Edge (драйверы подтягивает Selenium Manager).

## Запуск

```bash
# все три браузера параллельно (testng.xml)
mvn clean test

# один браузер
mvn clean test -DsuiteXml=testng-single.xml -Dbrowser=firefox
mvn clean test -DsuiteXml=testng-single.xml -Dbrowser=chrome -Dheadless=true
```

## Allure

```bash
mvn allure:serve     # временный сервер, Ctrl+C для остановки
mvn allure:report    # HTML: target/site/allure-maven/index.html
```

## Структура

- `pages/` — Page Object (BasePage + страницы)
- `tests/` — BaseTest и тесты (7 сценариев)
- `utils/` — AllureAttachments, EnvironmentListener
