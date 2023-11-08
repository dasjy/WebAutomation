package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class SampleTest {

    WebDriver driver;

    @Test
    public void testApp() {

        WebDriverManager.chromedriver().setup();


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.trip.com/");

        driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
        //WebElement searchBox=driver.findElement(By.xpath("//input[@type='text']"));

        //Boolean result=searchBox.getAttribute("name").contains("das");
        // System.out.println(result);

        String fromDate = "31";

        List<WebElement> results = driver.findElements(By.xpath("(//div[@class='c-calendar-month'])[1]/div[2]/ul/li"));
        results.stream().map(WebElement::getText).forEach(p -> {
            System.out.println(p);
        });


        results.stream().map(s -> s.getAttribute("class").contains("is-disable")).forEach(p -> {
            System.out.println(p);
        });

        boolean areDatesDisabled = results.stream()
                .filter(option -> option.getAttribute("class").contains("is-disable")) // Assuming disabled dates have a specific CSS class
                .allMatch(option -> option.getText().compareTo(fromDate) < 0);


        System.out.println("Boolean value "+areDatesDisabled );


        driver.quit();

    }

    @Test
    public void test654(){
        Stream<String> stream = Stream.of("GEeks", "FOr",
                "GEEKSQUIZ", "GEeksforGeeks");

        // Check if Character at 1st index is
        // UpperCase in any string or not using
        // Stream anyMatch(Predicate predicate)
        boolean answer = stream.allMatch(str -> Character.isUpperCase(str.charAt(1)));

        // Displaying the result
        System.out.println(answer);
        String str = "jyoti ranjan das";
        List.of(str.split(" "));
        System.out.println( List.of(str.split(" ")).get(1));

    }
}
