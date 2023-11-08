package LamdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LamdaTest {
    @Test
    public void testLamda(){
        WebDriver driver = BrowserManager.getBrowser("firefox").getDriver();
        BrowserManager.setUrl(driver, "https://www.lambdatest.com/selenium-playground/");
        driver.findElement(By.xpath("//a[contains(text(),'Bootstrap Alerts')]")).click();
        driver.findElement(By.xpath("//button[text()='Autoclosable Success Message']")).click();
        String textValue = driver.findElement(By.xpath("//*[contains(text(),'Normal Success Message')]")).getText();
        System.out.println(textValue);
        driver.findElement(By.xpath("//*[@class='container']/div[contains(@class,'flex')]/div/div/div[2]/div/a")).click();

    }
}
