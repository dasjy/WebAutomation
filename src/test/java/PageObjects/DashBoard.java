package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DashBoard {

    public static final By closeButton = By.cssSelector("button[class='btn-close']");
    public static final By catlogOptions = By.xpath("//li[contains(@id,'menu')]");
    private static final By salesOpt = By.cssSelector("li[id='menu-sale'] ul li");
    WebDriver driver;

    public DashBoard(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCloseBtn() {
        driver.findElement(closeButton).click();
    }

    public void catlogOption(String catOpt) {
        driver.findElements(catlogOptions).stream()
                .forEach(s -> {
                    String cat = s.getText();
                    if (cat.contains(catOpt)) {
                        s.click();
                    }
                });


    }

    public void selectSaleOpt(String type) {
        driver.findElements(salesOpt).stream()
                .forEach(s -> {
                    String cat = s.getText();
                    if (cat.contains(type)) {
                        s.click();
                    }
                });
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.xpath("")).click();
        int size = driver.findElements(By.cssSelector("ul[class='pagination'] li ")).size();
        String totalpage = driver.findElements(By.cssSelector("ul[class='pagination'] li ")).get(size - 1).getText();
        System.out.println("total page " + totalpage);

    }
}