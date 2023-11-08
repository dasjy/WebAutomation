package Steps;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageStep {
    LoginPage loginPage;

    public LoginPageStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public void verifyAndEnterUserName(String userName) {
        loginPage.enterUserName(userName);
    }

    public void verifyAndEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    public void verifyAndClickLoginBtn() {
        loginPage.clickLoginButton();
    }
}
