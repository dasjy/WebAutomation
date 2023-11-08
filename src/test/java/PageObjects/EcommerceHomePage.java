package PageObjects;

import Utils.BasePageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EcommerceHomePage extends BasePageMethods {
    private static final By homePageImage = By.cssSelector("img[title='naveenopencart']");
    private static final By searchField = By.cssSelector("input[type='text'][name='search']");
    private static final By allCatlogs = By.xpath("//*[@class='nav navbar-nav']/li/a[@href]");
    private static WebDriver driver;
    public EcommerceHomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isHomePageImageAvail() {
        waitUntilVisible(homePageImage);
        return driver.findElement(homePageImage).isDisplayed();
    }

    public Boolean isSearchFieldEnabled() {
        return driver.findElement(searchField).isEnabled();
    }

    public void enterTextInSearchBox(String messages) {
        driver.findElement(searchField).sendKeys(messages);
    }
}
