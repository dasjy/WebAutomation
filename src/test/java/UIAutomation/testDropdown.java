package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class testDropdown {

    public static WebDriver driver;

    @FindBy(xpath = "//*[@for='fromCity']")
    private static WebElement fromLocations;

    @FindBy(xpath = "//*[@for='toCity']")
    private static WebElement toLocations;

    @Test
    public void testDropdown() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.makemytrip.com/");

        WebElement from = driver.findElement(By.xpath("//*[@id='fromCity']"));
        from.click();
        WebElement fromLocations = driver.findElement(By.xpath("//*[@id='react-autowhatever-1']"));

        List<WebElement> locDeatails = fromLocations.findElements(By.xpath("//p[contains(@class,'appendBottom5 blackText')]"));

        List<String> data = new ArrayList<>();
        

        for (WebElement details : locDeatails) {
            data.add(details.getText());
        }
        //selectFromLocation(from, locDeatails, "Bangkok");

        List<String> updatedLoc=data.stream().sorted().collect(Collectors.toList());
        List<String> updatedLoc2= data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //  driver.quit();

        Boolean result=data.equals(updatedLoc);

        System.out.println(result);


    }

    private void selectFromLocation(WebElement from, List<WebElement> data, String place) {

        for (WebElement locs : data) {
            if (locs.getText().contains(place)) {
                locs.click();
            } else {
                System.out.println("Choose right place");
                // System.exit(0);
            }
        }

    }
}
