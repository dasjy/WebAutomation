package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AmazoneTest {

    WebDriver driver;

    @Test(description = "Test Amazone application")
    public void testAmazonApplication() {

        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']")).click();

        driver.quit();
    }

    @Test(priority = 1, description = "checkbox")
    public void testCheckBox() throws InterruptedException {
        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'input-body ')]/div/div[2]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        List<WebElement> options = element.findElements(By.xpath("//div/input[@type='checkbox']"));
       // List<String> details = new ArrayList<>();
        List<String> details2 = new ArrayList<>(List.of("option 1", "option 2"));
        options.forEach(
                p -> {
                    List<String> details = options.stream().map(pa->pa.getText()).collect(Collectors.toList());
                    if (p.getText().equalsIgnoreCase("option 90")){
                        p.click();
                    }
                    else{
                        Assert.fail("Execution Failed !!");
                    }

                }
        );

        driver.findElement(By.xpath("//input[@value='check all']")).click();
        System.out.println("is Enable" +  driver.findElement(By.xpath("//input[@value='check all']")).isEnabled());
        driver.findElement(By.xpath("//input[@value='uncheck all']")).click();

        options.forEach(
                p -> {
                    System.out.println("selected or not" + p.isSelected());
                    Assert.assertFalse(p.isSelected(), "false");
                }
        );


    }

}
