package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage extends BasePage {
    private final By slider = By.cssSelector("input.range-slider");
    private final By sliderValue = By.id("sliderValue");

    public SliderPage(WebDriver d, WebDriverWait w) { super(d, w); }

    @Step("Открыть страницу Slider")
    public SliderPage open() {
        driver.get("https://demoqa.com/slider");
        el(slider);
        return this;
    }

    @Step("Сдвинуть слайдер вправо на {times} шагов")
    public SliderPage moveRight(int times) {
        var s = el(slider);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", s);
        for (int i = 0; i < times; i++) s.sendKeys(Keys.ARROW_RIGHT);
        return this;
    }

    public int value() {
        return Integer.parseInt(el(sliderValue).getAttribute("value"));
    }
}
