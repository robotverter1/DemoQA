package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

@Epic("Elements")
@Feature("Text Box")
public class TextBoxTest extends BaseTest {

    @Test(description = "Позитив: валидные данные приводят к отображению блока результата")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Фамилия Имя")
    public void shouldSubmitValidData() {
        var page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "ivan.petrov@example.com", "Current", "Permanent");
        Assert.assertTrue(page.isOutputVisible(), "Ожидалось появление блока результатов.");
    }

    @Test(description = "Негатив: невалидный email подсвечивается как ошибка")
    @Severity(SeverityLevel.NORMAL)
    public void shouldHighlightInvalidEmail() {
        var page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "not-an-email", "Current", "Permanent");
        Assert.assertTrue(page.emailFieldClass().contains("error") ||
                        page.emailFieldClass().contains("invalid"),
                "Ожидалась индикация ошибки для поля email.");
    }
}
