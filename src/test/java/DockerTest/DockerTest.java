package DockerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class DockerTest {

    @Test(priority = 1, enabled = true, description = "")
    public void dockerTest1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.odoo.com/app/crm");
        System.out.println(driver.getTitle());
        WebElement dropDown = driver.findElement(By.cssSelector(".o_primary_nav .dropdown .dropdown-toggle"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", dropDown);
       // dropDown.click();

        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[contains(text(),'Discover')]"))
                        .stream().forEach(link ->{
                            link.click();
                            driver.navigate().back();
              });

        driver.quit();
    }
    @Test
    public void test2(){
        List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        List<String> words2 = Arrays.asList("dog", "cat", "elephant");

        BiFunction<String, String, Integer> sumLengths = (str1, str2) -> str1.length() + str2.length();

        List<Integer> lengthsSum = words1.stream()
                .flatMap(word1 -> words2.stream().map(word2 -> sumLengths.apply(word1, word2)))
                .collect(Collectors.toList());

        System.out.println(lengthsSum);  // Output: [10, 9, 12, 11, 13, 12, 15, 14, 17]

    }
    @Test
    public void test20(){
        List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        List<String> words2 = Arrays.asList("dog", "cat", "elephant");

        BiFunction<String, String, Integer> sumLengths = (str1, str2) -> str1.length() + str2.length();

        List<Integer> lengthsSum = words1.stream()
                .flatMap(word1 -> words2.stream().map(word2 -> sumLengths.apply(word1, word2)))
                .collect(Collectors.toList());

        System.out.println(lengthsSum);
    }
}
