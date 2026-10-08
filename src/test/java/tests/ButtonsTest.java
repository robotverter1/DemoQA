package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;

@Epic("Elements")
@Feature("Buttons")
public class ButtonsTest extends BaseTest {

    @Test(description = "Двойной клик показывает сообщение")
    @Severity(SeverityLevel.NORMAL)
    public void shouldShowMessageOnDoubleClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.doubleClick();
        Assert.assertEquals(page.doubleClickMessage(), "You have done a double click");
    }

    @Test(description = "Правый клик показывает сообщение")
    @Severity(SeverityLevel.NORMAL)
    public void shouldShowMessageOnRightClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.rightClick();
        Assert.assertEquals(page.rightClickMessage(), "You have done a right click");
    }
}
