package UIAutomation;

import Modals.EcommerceTestData;
import Steps.EcommerceHomePageSteps;
import org.testng.annotations.Test;

import java.io.IOException;

public class EcommerceAppLogin extends BaseTest1 {

    EcommerceTestData ecommerceTestData;
    EcommerceHomePageSteps ecommerceHomePageSteps;
//    @BeforeMethod
//    public void getTestData() throws JsonProcessingException {
//        ecommerceTestData = TestDataProvider.getTestData("", EcommerceTestData.class);
//    }
    @Test
    public void test() throws IOException {
        ecommerceHomePageSteps = new EcommerceHomePageSteps(driver);
        ecommerceHomePageSteps.verifySearchBox();
        ecommerceHomePageSteps.enterTextSearchBox("das");
    }


}
