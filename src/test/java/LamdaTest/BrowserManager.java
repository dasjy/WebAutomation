package LamdaTest;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserManager {
    public static Browser getBrowser(String browserType){
        switch (browserType.toLowerCase()){
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FireFoxDriver();
            default:
                throw new IllegalArgumentException("Invalid BrowserType");
        }
    }

    public static void setUrl(WebDriver driver, String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
