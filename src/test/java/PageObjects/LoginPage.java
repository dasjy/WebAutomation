package PageObjects;

import UIAutomation.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By closeButton = By.cssSelector("button[class='btn-close']");
    public static final By catlogOptions = By.xpath("//li[contains(@id,'menu')]");
    private static final By userName = By.cssSelector("input[type='text'][name='username']");
    private static final By password = By.cssSelector("input[type='password'][name='password']");
//    @FindBy(css = "input[type='password'][name='password']")
//    WebElement password;
    private static final By loginButton = By.cssSelector("button[type='submit']");
    private static final By salesOpt = By.cssSelector("li[id='menu-sale'] ul li");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUserName(String userId) {
        driver.findElement(userName).sendKeys(userId);
    }

    public void enterPassword(String pswd) {
        driver.findElement(password).sendKeys(pswd);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


}
