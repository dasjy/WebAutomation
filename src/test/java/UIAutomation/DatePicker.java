package UIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class DatePicker {

    WebDriver driver;

    @Test
    public void testCalender() throws InterruptedException {
        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://fengyuanchen.github.io/datepicker/");
        driver.findElement(By.xpath("(//input[@name='date'])[1]")).click();

        WebElement previousMonthButton = driver.findElement(By.cssSelector(".datepicker-panel  li[data-view='month prev']"));
        WebElement currentData = driver.findElement(By.cssSelector(".datepicker-panel  li[data-view='month current']"));
        WebElement nextMonthButton = driver.findElement(By.cssSelector(".datepicker-panel  li[data-view='month next']"));
        WebElement datesTable = driver.findElement(By.cssSelector(".datepicker-panel  ul[data-view='days']"));

        List<WebElement> dates = datesTable.findElements(By.cssSelector("li[data-view='day']"));

        String expectedMonth = "may";
        String expectedYear = "2023";
        String expectedDate = "20";

        String getCurrentMonth[] = currentData.getText().split(",");
        System.out.println("Expected size : " + getCurrentMonth.length + getCurrentMonth);

        List<String> str = new ArrayList<String>();
        str = Arrays.asList(getCurrentMonth);
        System.out.println("Expected month : " + str.get(0) + " Expected year : " + str.get(1));


        if (str.get(0).equalsIgnoreCase(expectedMonth) && str.get(1).equalsIgnoreCase(expectedYear)) {

            System.out.println("Inside if block ");
            dates.forEach(p -> {
                System.out.println("p text value" + p.getText());
                if (p.getText().equalsIgnoreCase(expectedDate)) {
                    p.click();
                } else {
                    System.out.println("Invalid dates selected");
                }
            });
        } else {
            System.out.println("select valid month");
        }


        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test123() {
        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.in/");

        String data = "mobile phone ";
        ((JavascriptExecutor) driver).executeScript("document.getElementById('twotabsearchtextbox').value='"+data+"';");
    }
    @Test
    public void test1234() throws InterruptedException {
        Reporter.log("Execution Starts");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/p[1]")).click();


        WebElement date=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]/div[1]"));

        System.out.println("Inner t value: " + driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]/div[1]")).getText());

        String textValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", date);
        System.out.println("Inner HTML: " + textValue);

        // Use JavaScript to get the innerText property
        textValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", date);
        System.out.println("Inner Text: " + textValue);

        Thread.sleep(5000);
        driver.quit();


         }
}
