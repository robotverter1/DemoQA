package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;

@Epic("Alerts, Frame & Windows")
@Feature("Browser Windows")
public class BrowserWindowsTest extends BaseTest {

    @Test(description = "Новая вкладка открывает sample-страницу с ожидаемым заголовком")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldOpenNewTab() {
        var page = new BrowserWindowsPage(driver, wait);
        page.open();
        Assert.assertEquals(page.openNewTabReadHeadingAndClose(), "This is a sample page");
    }
}
