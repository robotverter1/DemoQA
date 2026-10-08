package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage extends BasePage {
    private final By doubleClickBtn = By.id("doubleClickBtn");
    private final By rightClickBtn = By.id("rightClickBtn");
    private final By doubleMsg = By.id("doubleClickMessage");
    private final By rightMsg = By.id("rightClickMessage");

    public ButtonsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    @Step("Открыть страницу Buttons")
    public void open() { driver.get("https://demoqa.com/buttons"); }

    @Step("Выполнить двойной клик")
    public void doubleClick() {
        dispatchMouseEvent(doubleClickBtn, "dblclick", 0);
    }

    @Step("Выполнить правый клик")
    public void rightClick() {
        dispatchMouseEvent(rightClickBtn, "contextmenu", 2);
    }

    private void dispatchMouseEvent(By locator, String eventType, int button) {
        var element = el(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});" +
                "arguments[0].dispatchEvent(new MouseEvent(arguments[1], " +
                "{view: window, bubbles: true, cancelable: true, button: arguments[2]}));",
                element, eventType, button);
    }

    public String doubleClickMessage() { return el(doubleMsg).getText(); }

    public String rightClickMessage() { return el(rightMsg).getText(); }
}
