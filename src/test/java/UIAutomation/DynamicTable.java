package UIAutomation;

import Steps.DashBoardSteps;
import Steps.LoginPageStep;
import org.testng.annotations.Test;

public class DynamicTable extends BasePage {

    private LoginPageStep loginPageStep;
    private DashBoardSteps dashBoardSteps;

    @Test
    public void dynamicTableTest() {

        loginPageStep = new LoginPageStep(driver);
        dashBoardSteps = new DashBoardSteps(driver);

        loginPageStep.verifyAndEnterUserName("demo");
        loginPageStep.verifyAndEnterPassword("demo");
        loginPageStep.verifyAndClickLoginBtn();

        dashBoardSteps.verifyAncClickCloseBtn();
        dashBoardSteps.selectCalatog("Sale");
        dashBoardSteps.selectOption("Order");
//        loginPage.catlogOption();
//        loginPage.selectSaleOpt();
    }
}
