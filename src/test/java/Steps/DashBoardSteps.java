package Steps;

import PageObjects.DashBoard;
import org.openqa.selenium.WebDriver;

public class DashBoardSteps {

    private final DashBoard dashBoard;

    public DashBoardSteps(WebDriver driver) {
        dashBoard = new DashBoard(driver);
    }

    public void verifyAncClickCloseBtn() {
        dashBoard.clickOnCloseBtn();
    }

    public void selectCalatog(String catOption){
        dashBoard.catlogOption(catOption);
    }

    public void selectOption(String type){
        dashBoard.selectSaleOpt(type);
    }
}
