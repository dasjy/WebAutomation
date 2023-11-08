package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest1 {
    static WebDriver driver;
    @BeforeTest
    public void openApplication() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("config.properties");
//        Properties properties = new Properties();
//        properties.load(fileInputStream);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
