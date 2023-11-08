package UIAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GraphAutomation {

    @Test
    public void automateGraph() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://emicalculator.net/");

        //String barChat = "div#highcharts-jimv6ej-4 g[class$='group']";
        //String bars = "div#highcharts-jimv6ej-4 g[class$='group'] rect";

        // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By
        // .cssSelector(barChat)));

        Actions act = new Actions(driver);
//        act.moveToElement(driver.findElement(By.cssSelector(barChat))).perform();

        List<WebElement> bars = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])" +
                "[2]//*[name()='g' and @class='highcharts-series-group']//*[name()='g']//*[name()='rect']"));
        List<WebElement> graph = driver.findElements(By.xpath("((//*[local-name()='svg' and " +
                "@class='highcharts-root'])[2]//*[name()='g' ])[13]//*[name()='path']"));
        List<WebElement> tableData = driver.findElements(By.xpath("(//div[@id='emipaymenttable']//table//tbody)" +
                "[1]//tr[@class='row no-margin yearlypaymentdetails']"));

        //         for(WebElement e  : bars){
//             act.moveToElement(e).perform();
//
//             WebElement amount = driver.findElement(By.xpath("(//*[local-name()='svg' and
//             @class='highcharts-root'])[2]//*[name()='g' and @class='highcharts-label highcharts-tooltip
//             highcharts-color-undefined']"));
//             System.out.println(amount.getText());
//         }
//
        bars.stream().forEach(s -> {
            act.moveToElement(s).perform();
            WebElement amount = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])" +
                    "[2]//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']"));
            System.out.println(amount.getText());
        });

        graph.stream().forEach(s -> {
            act.moveToElement(s).perform();
            WebElement amount = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])" +
                    "[2]//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']"));
            System.out.println(amount.getText());
        });

        tableData.stream().forEach(s -> {
            act.moveToElement(s).perform();
            System.out.println(s.getText());
        });

        List<TableModals> columnsData = getTableData(tableData);

        columnsData.stream()
                .map(TableModals::getBalance)
                .collect(Collectors.toList()).stream().forEach(s -> {
                    System.out.println("balance" + s.toUpperCase().replaceAll("[^0-9]", ""));
                });

        columnsData.stream()
                .map(TableModals::getBalance)
                .collect(Collectors.toList()).stream().forEach(s -> {
                    System.out.println("balance" + s.toUpperCase().replaceAll("[^0-9]", ""));
                });

        columnsData.stream()
                .map(TableModals::getInterest)
                .collect(Collectors.toList()).stream().forEach(s -> {
                    System.out.println("Intesest " + s.toUpperCase());
                });

        columnsData.stream()
                .map(TableModals::getPrincipal)
                .collect(Collectors.toList()).stream().forEach(s -> {
                    System.out.println("principal  " + s.toUpperCase());
                });
//
//        bal.stream().forEach( s-> {
//            System.out.println("balance" + s.toUpperCase());
//        });
        driver.close();
    }

    private List<TableModals> getTableData(List<WebElement> tableData) {
        return tableData.stream().map(s -> getEachRowData(s)).collect(Collectors.toList());
    }

    private TableModals getEachRowData(WebElement s) {
        List<WebElement> d = s.findElements(By.tagName("td"));

        String Year1 = d.get(0).getText();
        String Principal1 = d.get(1).getText();
        String Interest = d.get(2).getText();
        String totalPayment1 = d.get(3).getText();
        String Balance1 = d.get(4).getText();
        String loan = d.get(5).getText();

        return TableModals.builder()
                .Year(Year1)
                .Principal(Principal1)
                .Interest(Interest)
                .totalPayment(totalPayment1)
                .Balance(Balance1)
                .loanToPaidDate(loan)
                .build();
    }
}
