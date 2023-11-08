package Steps;

import PageObjects.EcommerceHomePage;
import org.openqa.selenium.WebDriver;

public class EcommerceHomePageSteps {
    EcommerceHomePage ecommerceHomePage;
    public EcommerceHomePageSteps(WebDriver driver){
        ecommerceHomePage = new EcommerceHomePage(driver);
    }

    public void verifySearchBox(){
        ecommerceHomePage.isSearchFieldEnabled();
    }
    public void enterTextSearchBox(String text){
        ecommerceHomePage.enterTextInSearchBox(text);
    }
}
