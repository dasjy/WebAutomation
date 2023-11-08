package LamdaTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ChromeDriver implements  Browser{
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return new org.openqa.selenium.chrome.ChromeDriver();
    }
}
