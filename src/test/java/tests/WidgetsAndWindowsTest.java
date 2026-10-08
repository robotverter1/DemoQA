package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.ButtonsPage;
import pages.SliderPage;

@Epic("Elements / Widgets / Windows")
@Feature("Buttons, Slider, Browser Windows")
public class WidgetsAndWindowsTest extends BaseTest {

    @Test(description = "Buttons: двойной клик показывает сообщение")
    @Story("Buttons")
    @Severity(SeverityLevel.NORMAL)
    public void shouldShowMessageOnDoubleClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.doubleClick();
        String msg = page.doubleClickMessage();
        Assert.assertEquals(msg, "You have done a double click");
    }

    @Test(description = "Buttons: правый клик показывает сообщение")
    @Story("Buttons")
    @Severity(SeverityLevel.NORMAL)
    public void shouldShowMessageOnRightClick() {
        var page = new ButtonsPage(driver, wait);
        page.open();
        page.rightClick();
        String msg = page.rightClickMessage();
        Assert.assertEquals(msg, "You have done a right click");
    }

    @Test(description = "Slider: 5 нажатий стрелки вправо увеличивают значение на 5")
    @Story("Slider")
    @Severity(SeverityLevel.MINOR)
    public void shouldIncreaseSliderValue() {
        var page = new SliderPage(driver, wait).open();
        int before = page.value();
        page.moveRight(5);
        Assert.assertEquals(page.value(), before + 5, "Значение слайдера изменилось неверно.");
    }

    @Test(description = "Browser Windows: новая вкладка содержит ожидаемый заголовок")
    @Story("Новая вкладка")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldOpenNewTabWithSamplePage() {
        var page = new BrowserWindowsPage(driver, wait);
        page.open();
        String heading = page.openNewTabReadHeadingAndClose();
        Assert.assertEquals(heading, "This is a sample page");
    }
}
