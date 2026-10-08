package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/** Создание драйверов. Драйверы скачивает Selenium Manager (встроен в Selenium 4.6+). */
public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver create(String browser, boolean headless) {
        switch (browser.toLowerCase()) {
            case "firefox" -> {
                FirefoxOptions fo = new FirefoxOptions();
                if (headless) fo.addArguments("-headless");
                return new FirefoxDriver(fo);
            }
            case "edge" -> {
                EdgeOptions eo = new EdgeOptions();
                eo.addArguments("--lang=en-US", "--window-size=1920,1080");
                if (headless) eo.addArguments("--headless=new");
                return new EdgeDriver(eo);
            }
            default -> {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--lang=en-US", "--window-size=1920,1080");
                if (headless) co.addArguments("--headless=new");
                return new ChromeDriver(co);
            }
        }
    }
}
