package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class DatePickerTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
       driver.quit();
    }

    @Test
    public void testPagination(){
        List<Integer> selectPages = Arrays.asList(1,2);
        String select = "Table Pagination";
        String xpathExpression = format("//div[@class='container__selenium']/ul/li/a[text()='%s']", select);
        driver.findElement(By.xpath(xpathExpression)).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement paginationSection = driver.findElement(By.xpath("//div[@class='pagination-container']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pagination-container']")));
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//table[@id='table-id']/tbody")));
        String pageSelection = "//ul[@class='pagination_sp']/li[@data-page='%s']";
        if (paginationSection.isDisplayed()) {
            for (Integer page : selectPages) {
                driver.findElement(By.xpath(format(pageSelection, page))).click();
            }
        }

    }    @Test(description = "Date picker testing", groups = {"smoke-test","sm-1"})
    public void testDatePicker(){
        String select = "Bootstrap Date Picker";
        String xpathExpression = format("//div[@class='container__selenium']/ul/li/a[text()='%s']", select);
        final By birthDayCalender = By.xpath("//*[@id=\"birthday\"]");
        final By name = By.xpath("%s");

        driver.findElement(By.xpath(xpathExpression)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(birthDayCalender));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", elementToClick);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(birthDayCalender));
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[@placeholder='End date']")).click();
       }
}
