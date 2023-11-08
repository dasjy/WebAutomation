package LamdaTest;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriver implements Browser{
    @Override
    public WebDriver getDriver() {
        ChromeDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
