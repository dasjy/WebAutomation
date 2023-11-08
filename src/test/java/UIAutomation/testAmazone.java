package UIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class testAmazone {

    @Test
    public void test10() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        System.out.println(driver.getTitle());

        driver.quit();

      /*  ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
        String remote_url_chrome = "http://localhost:4444/wd/hub";

        ChromeOptions options = new ChromeOptions();
        driver.set(new RemoteWebDriver(new URL(remote_url_chrome), options));
*/



    }
}
