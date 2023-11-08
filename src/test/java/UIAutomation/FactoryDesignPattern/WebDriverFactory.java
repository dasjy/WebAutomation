package UIAutomation.FactoryDesignPattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static WebDriver driver = null;

    public static WebDriver getDriver(String broswer) {
        Map<String, Runnable> map = new HashMap<>();
        map.put(broswer, () -> {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        });
        map.put(broswer, () -> {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        });

        Runnable driverSetUp = map.get(broswer.toLowerCase());
        if (driverSetUp != null) {
            driverSetUp.run();
            return driver;
        } else {
            throw new IllegalArgumentException("driver not supported");
        }
    }
}
