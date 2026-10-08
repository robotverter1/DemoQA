package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BrowserWindowsPage extends BasePage {
    private final By newTabBtn = By.id("tabButton");
    private final By sampleHeading = By.id("sampleHeading");

    public BrowserWindowsPage(WebDriver d, WebDriverWait w) { super(d, w); }

    @Step("Открыть страницу Browser Windows")
    public void open() { driver.get("https://demoqa.com/browser-windows"); }

    @Step("Открыть новую вкладку, прочитать заголовок, закрыть и вернуться")
    public String openNewTabReadHeadingAndClose() {
        String original = driver.getWindowHandle();
        Set<String> before = driver.getWindowHandles();
        click(newTabBtn);
        wait.until(ExpectedConditions.numberOfWindowsToBe(before.size() + 1));
        String newHandle = driver.getWindowHandles().stream()
                .filter(h -> !before.contains(h)).findFirst().orElseThrow();
        driver.switchTo().window(newHandle);
        String heading = el(sampleHeading).getText();
        driver.close();
        driver.switchTo().window(original);
        return heading;
    }
}
