package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LamdaTest {
    WebDriver driver;

    @Test
    public void testSingleDropCDown() {
        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");

        //Try with Select value

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[1]/div[2]/span/span[1" +
                "]/span")).click();
        WebElement searchCountry = driver.findElement(By.xpath("(//*[@class='select2-search__field'])[2]"));
        WebElement searchResult = driver.findElement(By.xpath("//ul[@id='select2-country-results']"));

        String country = "Australia";
        searchResult.findElements(By.cssSelector(".select2-results__option"))
                .stream().map(s -> s.getText())
                .forEach(
                        p -> {

                        }
                );
        searchCountry.click();
        searchCountry.sendKeys(country);


    }

    @Test
    public void test123() {
        System.out.println("das");

        List<String> list1 = new ArrayList<>(List.of("abc", "ccd", "eef"));

        if (list1.contains("abc")) {
            System.out.println("abc");
        }
        if (list1.contains("ccd")) {
            System.out.println("ccd");
        }
        if (list1.contains("eef22")) {
            System.out.println("eef");
        }

        List<String> data = Arrays.asList("123", "456", "789", "101");
        data.get(0);
        List<String> data2 = Arrays.asList("123", "456", "789");
        List<String> data3 = Arrays.asList("789", "123", "456");
        List<String> data4 = Arrays.asList("789", "123", "456", "102");

        System.out.println(data.equals(data2));
        System.out.println(data.equals(data3));
        System.out.println(data.containsAll(data3));
        System.out.println(data.containsAll(data4));
    }

}

