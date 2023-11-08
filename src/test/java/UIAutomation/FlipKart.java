package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.BreakIterator;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FlipKart {
    @Test
    public void testFlipkart()
    {
        String fromLocation="Mumbai";
        String country="IN";

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//*[contains(@class,'_2KpZ6l _2doB4z')]")).click();

//        Actions act=new Actions(driver);
//        act.contextClick(driver.findElement(By.xpath("//div[text()='Fashion']")))
//                        .build().perform();

        driver.findElement(By.xpath("//div[text()='Travel']")).click();
        WebElement from=driver.findElement(By.xpath("(//*[@class='_3qBKP_ _1Jqgld']/input[@type='text'])[1]"));
        from.click();       from.sendKeys(fromLocation.concat(", ").concat(country));


        WebElement cities=driver.findElement(By.xpath("(//*[@class='_1fa_Yn HQlQNF _18Y7Fu'])[1]"));
        List<WebElement> data=cities.findElements(By.xpath("//*[@class='_3uA4ax']/div/div/span"));
//        for(WebElement textData: data)
//        {
//            System.out.println(textData.getText());
//        }
        data.forEach(text->{
            System.out.println(text.getText());
        });
        //driver.quit();
    }
    @Test
    public void test2()
    {


        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mercurytravels.co.in/");
        List<WebElement> packages=driver.findElements(By.xpath("//*[contains(text(),'-- Select Holiday Type --')]/../option"));

        List<String> packageTypes= packages.stream().map(each-> each.getText()).map(data->data.replaceAll(","," ")).collect(Collectors.toList());

        System.out.println(packageTypes);
//        WebElement dropDown=driver.findElement(By.xpath("//*[contains(text(),'-- Select Holiday Type --')]/.."));
//        dropDown.click();
//        Select se= new Select(dropDown);

       // se.selectByIndex(3);


        driver.findElement(By.xpath("//*[@id='dphh1']")).click();

        WebElement datePickerTable=driver.findElement(By.xpath("(//*[@class=' table-condensed'])[7]"));

        driver.findElement(By.xpath("(//*[@class=' table-condensed'])[7]/thead/tr/th[2]")).click();
        WebElement Months=driver.findElement(By.xpath("(//*[@class='table-condensed'])[13]"));

        List<WebElement> months= Months.findElements(By.xpath("(//*[@class='table-condensed'])[13]/tbody/tr/td/span"));

        List<String> selectMonths=months.stream().map(each->each.getText()).collect(Collectors.toList());
        System.out.println(selectMonths);

        WebElement nextButton=driver.findElement(By.xpath("(//*[@class='table-condensed'])[13]/thead/tr/th[3]"));
        WebElement year=driver.findElement(By.xpath("(//*[@class='table-condensed'])[13]/thead/tr/th[2]"));

        if(selectMonths.contains("mar") && year.getText().equalsIgnoreCase("2024") )
        {

        }
        else
        {
            nextButton.click();
        }

    }
    @Test
    public void table()
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mercurytravels.co.in/");
    }

    @Test
    public void sample()
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        WebElement from=driver.findElement(By.id(""));
        WebElement fromLocs=driver.findElement(By.id(""));
//        selectFromLoaction(from, Collections.singletonList("data"));
//
//        SelectFromPlace(from,fromLocs,"Msg");

        WebElement to=driver.findElement(By.id(""));;

    }

//    private void SelectFromPlace(WebElement from, WebElement fromLocs, String msg) {
//        List<WebElement> fromLocdetais=from.findElements(By.tagName(""))    }
//
//    private void selectFromLoaction(WebElement from, List<String> data) {
//
//        Select sele=new Select(from);
//
//        List<WebElement> a=sele.getOptions();
//        for(WebElement b:a)
//        {
//            if(data.stream().anyMatch(b.getText()::contains))
//            {
//                b.click();
//                break;
//            }
//            ;
//        }
//
//    }
}
