package utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

/** После прогона пишет environment.properties и categories.json в target/allure-results. */
public class EnvironmentListener implements ISuiteListener {

    @Override
    public void onFinish(ISuite suite) {
        try {
            Path dir = Paths.get("target", "allure-results");
            Files.createDirectories(dir);

            Properties p = new Properties();
            p.setProperty("os.name", System.getProperty("os.name") + " " + System.getProperty("os.version"));
            p.setProperty("jdk.version", System.getProperty("java.version"));
            p.setProperty("selenium", "4.22.0");
            p.setProperty("testng", "7.10.2");
            p.setProperty("allure", "2.25.0");
            p.setProperty("browsers", "Chrome; Firefox; Edge");
            p.setProperty("driver.manager", "SeleniumManager");
            p.setProperty("base.url", "https://demoqa.com");
            p.setProperty("parallel", "tests, thread-count=3");
            try (OutputStream out = Files.newOutputStream(dir.resolve("environment.properties"))) {
                p.store(out, "Allure environment");
            }

            Path cat = Paths.get("src", "test", "resources", "categories.json");
            if (Files.exists(cat)) {
                Files.copy(cat, dir.resolve("categories.json"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println("Не удалось записать environment.properties: " + e.getMessage());
        }
    }
}
