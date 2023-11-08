package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageMethods {
   private static WebDriver driver;
   private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   public BasePageMethods(WebDriver driver){
       this.driver = driver;
   }

   public  boolean waitUntilVisible(By locator){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       return driver.findElements(locator).size()>1;
   }
}
